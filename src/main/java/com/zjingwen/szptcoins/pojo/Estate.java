package com.zjingwen.szptcoins.pojo;

public class Estate {
    private Integer id;

    private Long coins;

    private Long power;

    private String indenCode;

    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCoins() {
        return coins;
    }

    public void setCoins(Long coins) {
        this.coins = coins;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public String getIndenCode() {
        return indenCode;
    }

    public void setIndenCode(String indenCode) {
        this.indenCode = indenCode == null ? null : indenCode.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}