package com.zjingwen.szptcoins.pojo;

import java.util.Date;

public class Message {
    private Integer id;

    private Date receiveTime;

    private Integer uid;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}