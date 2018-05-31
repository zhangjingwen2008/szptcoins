package com.zjingwen.szptcoins.pojo;

public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer status;

    private String activeCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode == null ? null : activeCode.trim();
    }
}