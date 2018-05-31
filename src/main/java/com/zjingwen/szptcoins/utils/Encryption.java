package com.zjingwen.szptcoins.utils;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.asn1.eac.ECDSAPublicKey;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKey;

import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;

public class Encryption {
    public String x;
    public String y;

    /**
     * 【RSA算法】：使用RSA，随机生成256位随机数，并以32字节的16进制形式输出
     */
    public static String generate256Random() {
        try {
            //使用BouncyCastle包初始化键对生成器gg
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());

            //指定长度为256位
            final int KEY_SIZE = 256;

            //使用SecureRandom初始化
            keyGen.initialize(KEY_SIZE, new SecureRandom());
            KeyPair key = keyGen.generateKeyPair();

            //获得字符串中私钥部分
            int begin = key.getPublic().toString().indexOf("modulus:") + 9;
            int end = begin + 64;
            return key.getPublic().toString().substring(begin, end);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 【椭圆曲线算法】：用ECDSA生成公钥，返回65字节的非压缩公钥
     */
    public String generateECDSA() {
        try {
            //载入BouncyCastle包，并调用ECDSA算法
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

            //指定椭圆曲线算法中使用的曲线为secp256k1
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256k1");

            //初始化生成键和生成键对
            keyGen.initialize(ecSpec, random);
            KeyPair keyPair = keyGen.generateKeyPair();

            //从键对中获取公钥和私钥
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            //获得X和Y的坐标值
            String pub = publicKey.toString();
            x = pub.substring(pub.indexOf("X") + 3, pub.indexOf("X") + 67);
            y = pub.substring(pub.indexOf("Y") + 3, pub.indexOf("Y") + 67);

            //拼接非压缩公钥（65字节）：1字节0x04 + 32字节X + 32字节Y
            //0x04：一般公钥即非压缩公钥的版本代码，其他版本为0x02、0x03、0x04
            String result = "04" + x + y;
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 【SHA256加密】：返回长为64位的16进制数据
     */
    public static String toSHA256(String record){
        //初始化MessageDigest
        MessageDigest digest = DigestUtils.getSha256Digest();
        byte[] hash = digest.digest(StringUtils.getBytesUtf8(record));
        return Hex.encodeHexString(hash);
    }

    /**
     * 【RIPEMD-160算法】：返回长为40位的16进制数据
     * */
    public String generateRIPEMD160(String record) throws Exception{
        //加入BouncyCastleProvider的支持
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        //初始化MessageDigest
        MessageDigest md=MessageDigest.getInstance("RipeMD160");
        byte[] data=record.getBytes();

        //执行消息摘要
        byte[] result=md.digest(data);

        return Hex.encodeHexString(result);
    }

    /**
     * 得到最终支付地址的原始16进制形式的字符串
     * 步骤：
     *      1.输入40位RIPEMD160字符串，加上0x00前缀（0x00：Bitcoin Address规定前缀）
     *      2.对【步骤1】进行两次SHA256计算，得到长为64位的字符串
     *      3.取【步骤2】的前8位作为校验码checkSum
     *          checkSum 后缀校验码：checkSum=SHA256(SHA256(0x00 + RIPEMD160))
     *      4.将checkSum拼接到【步骤1】结果的后面，形成一个长为50位的数据
     */
    public String addressOriginal(String ripemd160){
        String str="00" + ripemd160;
        String doubleSHA256 = toSHA256(toSHA256(str));
        String checkSum = doubleSHA256.substring(0,8);
        return str + checkSum;
    }

    /**
     * 将16进制原始地址转换为Base58形式数据输出
     * Base58 VS Base64：去除了会令人迷惑的字符
     *      1. 去除【大写O】与【数字0】
     *      2. 去除【大写I】与【小写l】
     *      3. 去除【+】与【/】，会影响鼠标双击全选
     *      4. 最终包含的字符为123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz
     *
     * 转换步骤：
     *      1. 输入25字节的16进制数据，并转换为大数字（使用Java的BigInteger类型接收，普通Integer或Long容量不够）
     *      2. 将这个大数字每次除以58，记录下每次的余数所对应Base58表中的字符
     *      3. 将最终所得进行反转即可得到最终地址
     */
    public String Base58(String record){
        char[] char58="123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();

        //获得前导0
        int zero=0;
        int index=0;
        while(record.charAt(index)=='0'){
            index++;
            zero++;
        }

        //将输入数据转换为大数字
        String str=new BigInteger(record,16).toString(10);

        //初始化BigInteger，接收大数字
        BigInteger b=new BigInteger(str);
        BigInteger divide58=new BigInteger("58");
        StringBuilder base58builder=new StringBuilder();

        //若大数字不为零，则继续进行先模后除操作
        while(!b.equals(BigInteger.ZERO)){
            int r=b.remainder(divide58).intValue();
            base58builder.append(char58[r]);
            b=b.divide(divide58);
        }

        //若有前导0，则计算0除以58获得对应Base58表中的字符
        if(zero>0){
            base58builder.append(char58[0/58]);
        }

        //反转操作
        String result=base58builder.reverse().toString();
        return result;
    }
}
