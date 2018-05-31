package com.zjingwen.szptcoins.pojo;

public class Wallet {
    private Integer id;

    private String publicKey;

    private String privateKey;

    private Integer uid;

    private String wif;

    private String wifCompressed;

    private String base58;

    private String address;

    private String hash160;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey == null ? null : publicKey.trim();
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey == null ? null : privateKey.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getWif() {
        return wif;
    }

    public void setWif(String wif) {
        this.wif = wif == null ? null : wif.trim();
    }

    public String getWifCompressed() {
        return wifCompressed;
    }

    public void setWifCompressed(String wifCompressed) {
        this.wifCompressed = wifCompressed == null ? null : wifCompressed.trim();
    }

    public String getBase58() {
        return base58;
    }

    public void setBase58(String base58) {
        this.base58 = base58 == null ? null : base58.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getHash160() {
        return hash160;
    }

    public void setHash160(String hash160) {
        this.hash160 = hash160 == null ? null : hash160.trim();
    }
}