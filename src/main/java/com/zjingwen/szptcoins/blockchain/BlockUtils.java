package com.zjingwen.szptcoins.blockchain;

import com.zjingwen.szptcoins.utils.Encryption;
import com.zjingwen.szptcoins.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BlockUtils {

    private static final Logger LOGGER= LoggerFactory.getLogger(BlockUtils.class);
    private static List<Block> blockChain=new LinkedList<>();
    private static int difficulty=1;

    /**
     * 计算区块的Hash值
     *      1. 获取【Version】【PreHash】【MerkleRoot】【TimeStemp】【bits】【nonce】
     *      2. 将数据拼接成一个80字节的数据，并使用Double SHA256进行加密
     *      3. 将加密所得数据以String的形式返回
     */
    public static String calHash(Block block){
        String record=block.getVersion()+block.getPreHash()+block.getMerkleRoot()+block.getTimeStamp()+block.getBits()+block.getNonce();
        return Encryption.toSHA256(Encryption.toSHA256(record));
    }

    /**
     * 生成区块
     */
    public static Block generateBlock(Block oldBlock){

        //创建新的块对象
        Block newBlock=new Block();

        //1. 设置块版本
        newBlock.setVersion("1");

        //2. 设置前一个块的Hash值
        newBlock.setPreHash(oldBlock.getHash());

        //3. 设置MerkleRoot(暂时使用前一个块的MerkleRoot）
        newBlock.setMerkleRoot(oldBlock.getMerkleRoot());

        //4. 设置时间戳
        newBlock.setTimeStamp(Integer.toHexString((int)new Date().getTime()));

        //5.设置难度系数，并计算Target值、设置Difficulty
        newBlock.setBits(oldBlock.getBits());

        //6.设置随机值Nonce
        for(int i=0;;i++){
            newBlock.setNonce(Integer.toHexString(i));
            String hash=Encryption.toSHA256(BlockUtils.calHash(newBlock));
            if(!isHashValid(hash,newBlock.getBits())){
                LOGGER.info("{} need do more work.",hash);
            }else{
                LOGGER.info("{} work down!",hash);
                newBlock.setHash(hash);
                break;
            }
        }

        return newBlock;
    }

    /**
     * 检验Hash的合法性
     *      1. 输入SHA256所得结果【hash】和难度目标【bits】
     *      2. 若【hash】< Target则合法，否则不合法
     */
    public static boolean isHashValid(String h, String bits){
        BigInteger target=new BigInteger(calTarget(Integer.parseInt(bits,16)),16);
        BigInteger hash=new BigInteger(h,16);

        int result=hash.compareTo(target);
        if(result<=0){
            return true;
        }
        return false;
    }

    /**
     * 检验区块的合法性（有效性）
     *      新区快的PreHash是否跟上一区块的hash相等
     *      当前区块的hash是否与计算的一致
     */
    public static boolean isBlockValid(Block oldBlock,Block newBlock){
        if (oldBlock.getHeight() + 1 != newBlock.getHeight()) {
            return false;
        }
        if (!oldBlock.getHash().equals(newBlock.getPreHash())) {
            return false;
        }
        if (!calHash(newBlock).equals(newBlock.getHash())) {
            return false;
        }
        return true;
    }

    /**
     * 计算当前区块的Difficulty值
     * 步骤
     *      1. 传入16进制的Target值作为参数，并转换成10进制
     *      2. 根据公式使用BigDecimal数据类型进行除法计算
     *              difficulty = difficulty_1_target / current_target
     *              difficulty_1_target：区块#0的Target，即最低难度，默认为00000000FFFF0000000000000000000000000000000000000000000000000000
     *              current_target：传入的要计算的Target值
     *      3. 对结果数据加上逗号，以便展示
     */
    public static String calDifficulty(String target){
        //创建difficulty_1_target和current_target对象
        String current=new BigInteger(target,16).toString(10);
        String difficulty_1=new BigInteger("00000000FFFF0000000000000000000000000000000000000000000000000000",16).toString(10);
        BigDecimal current_target=new BigDecimal(current);
        BigDecimal difficulty_1_target=new BigDecimal(difficulty_1);

        //根据公式 difficulty = difficulty_1_target / current_target 计算结果
        BigDecimal difficulty=difficulty_1_target.divide(current_target,2,BigDecimal.ROUND_HALF_UP);

        //调用setToken()方法对数据加上逗号
        String result=StringUtil.setToken(difficulty.toString());

        return result;

    }



    /**
     * 计算当前区块的Target值
     * @param bits 当前区块的Bits值
     * @return 返回32字节的16进制数据
     * 步骤：
     *      1. 将传入的10进制数据转为16进制形式
     *      2. 在大端模式下，提取高位第1个字节为“指数”Exponent，剩下3个字节为“有效尾数”Significand
     *      3. 因16进制转换成10进制后数字过大，故使用BigInteger类型来处理数据
     *              Target = Significand * 256 ^ (Exponent - 3)
     *      4. 若Target不足64位，则在前面补0x00至共64位
     */
    public static String calTarget(int bits){
        if(bits!=486604799) {
            //10进制转换成16进制
            String hex = Integer.toHexString(bits);

            //拆解16进制数据
            String exponent = hex.substring(0, 2);
            String significand = hex.substring(2, 8);

            //Target = Significand * 256 ^ (Exponent - 3)
            BigInteger mantissa = new BigInteger(String.valueOf(Integer.parseInt(significand, 16)));
            BigInteger base = new BigInteger("256");
            int ex = Integer.parseInt(exponent, 16) - 3;
            BigInteger result = mantissa.multiply(base.pow(ex));

            //将结果从BigInteger类型变成16进制字符串
            String re = new BigInteger(result.toString(), 10).toString(16);

            //补0x00至共64位
            if (re.length() < 64) {
                StringBuilder builder = new StringBuilder("");
                for (int i = re.length() + 1; i <= 64; i++) {
                    builder.append("0");
                }
                re = builder.toString() + re;
            }
            return re;
        }
//        return "00000000FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";
        return "000000FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";
    }

    //MerkleRoot获得
//    public static String getMerkleRoot(ArrayList<Transaction> transactions) {
//        int count = transactions.size();
//
//        List<String> previousTreeLayer = new ArrayList<String>();
//        for(Transaction transaction : transactions) {
//            previousTreeLayer.add(transaction.transactionId);
//        }
//        List<String> treeLayer = previousTreeLayer;
//
//        while(count > 1) {
//            treeLayer = new ArrayList<String>();
//            for(int i=1; i < previousTreeLayer.size(); i+=2) {
//                treeLayer.add(applySha256(previousTreeLayer.get(i-1) + previousTreeLayer.get(i)));
//            }
//            count = treeLayer.size();
//            previousTreeLayer = treeLayer;
//        }
//
//        String merkleRoot = (treeLayer.size() == 1) ? treeLayer.get(0) : "";
//        return merkleRoot;
//    }

}
