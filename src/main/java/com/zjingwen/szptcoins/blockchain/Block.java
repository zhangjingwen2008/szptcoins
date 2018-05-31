package com.zjingwen.szptcoins.blockchain;

/**
 * 区块：主要容纳区块头的数据
 */
public class Block {

    private int height;          //块在链中的高度

    private String preHash;     //32字节，前一区块的Hash值
    private String merkleRoot;  //32字节，该区块数据的Merkle树根的Hash值
    private String version;     //4字节，区块版本号
    private String timeStamp;   //4字节，时间戳
    private String bits;        //4字节，难度目标
    private String nonce;       //4字节，随机数

    private String difficulty;  //难度值，由前面bits算出
    private String hash;        //本区块Hash值，由前面6项数据算出

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPreHash() {
        return preHash;
    }

    public void setPreHash(String preHash) {
        this.preHash = preHash;
    }

    public String getMerkleRoot() {
        return merkleRoot;
    }

    public void setMerkleRoot(String merkleRoot) {
        this.merkleRoot = merkleRoot;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getBits() {
        return bits;
    }

    public void setBits(String bits) {
        this.bits = bits;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
