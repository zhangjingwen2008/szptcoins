package com.zjingwen.szptcoins.blockchain;

import com.zjingwen.szptcoins.utils.Encryption;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class BlockWallet {
    private String publicKey;                   //公钥
    private String privateKey;                  //原始私钥
    private String privateKey_WIF;              //WIF非压缩格式私钥
    private String privateKey_WIF_compressed;   //WIF压缩格式私钥
    private String privateKey_Base58;           //Base58格式私钥
    private String coinAddress;                 //支付地址
    private String hash160;                     //RIPEMD160码

    public String getHash160() {
        return hash160;
    }

    public void setHash160(String hash160) {
        this.hash160 = hash160;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPrivateKey_Base58() {
        return privateKey_Base58;
    }

    public void setPrivateKey_Base58(String privateKey_Base58) {
        this.privateKey_Base58 = privateKey_Base58;
    }

    public String getPrivateKey_WIF_compressed() {
        return privateKey_WIF_compressed;
    }

    public void setPrivateKey_WIF_compressed(String privateKey_WIF_compressed) {
        this.privateKey_WIF_compressed = privateKey_WIF_compressed;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey_WIF() {
        return privateKey_WIF;
    }

    public void setPrivateKey_WIF(String privateKey_WIF) {
        this.privateKey_WIF = privateKey_WIF;
    }

    public String getCoinAddress() {
        return coinAddress;
    }

    public void setCoinAddress(String coinAddress) {
        this.coinAddress = coinAddress;
    }

    private Encryption enc;

    public BlockWallet(){
        enc=new Encryption();
        generatePublicKey();
        generatePrivateKey();
        generateCoinAddress();
    }


    /**
     * 生成公钥
     */
    public void generatePublicKey(){
        publicKey=enc.generateECDSA();
    }

    /**
     * 生成私钥
     */
    public void generatePrivateKey(){
        //获得原始私钥
        privateKey=enc.y;

        //生成WIF非压缩私钥
        String wIF="80"+privateKey;
        String doubleSHA256=enc.toSHA256(enc.toSHA256(wIF));
        String checkSum=doubleSHA256.substring(0,8);
        String result=wIF+checkSum;
        privateKey_WIF=enc.Base58(result);

        //生成WIF-Compressed压缩私钥
        String wIFC="80"+privateKey+"01";
        String dSHA256=enc.toSHA256(enc.toSHA256(wIFC));
        String cSum=dSHA256.substring(0,8);
        String r=wIFC+cSum;
        privateKey_WIF_compressed=enc.Base58(r);

        //生成Base58方式私钥
        privateKey_Base58=enc.Base58(privateKey.toString());
    }

    /**
     * 生成地址
     */
    public void generateCoinAddress(){
        try {
            String sha256=enc.toSHA256(publicKey);
            String ripemd160=enc.generateRIPEMD160(sha256);
            String addressOriginal=enc.addressOriginal(ripemd160);
            String base58=enc.Base58(addressOriginal);

            hash160=ripemd160;
            coinAddress=base58;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
