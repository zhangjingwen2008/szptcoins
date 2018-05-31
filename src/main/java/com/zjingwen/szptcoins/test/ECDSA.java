package com.zjingwen.szptcoins.test;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 椭圆曲线数字签名算法
 * @author sunx
 *
 */
public class ECDSA {

    private static String src = "securtity ECDSA";

    public static void main(String[] args) {
        jdkECDSA();
    }

    public static void jdkECDSA(){

        //1、初始化密钥
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(256);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            ECPublicKey ecPublicKey = (ECPublicKey) keyPair.getPublic();
            ECPrivateKey ecPrivateKey = (ECPrivateKey) keyPair.getPrivate();

            //2、执行签名
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(ecPrivateKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initSign(privateKey);
            signature.update(src.getBytes());
            byte[] result = signature.sign();
            System.out.println("jdk ecdsa sign:" + result.length);

            //3、验证签名
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(ecPublicKey.getEncoded());
            keyFactory = KeyFactory.getInstance("EC");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            signature = Signature.getInstance("SHA256withECDSA");
            signature.initVerify(publicKey);
            signature.update(src.getBytes());
            boolean bool = signature.verify(result);
            System.out.println(bool);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}