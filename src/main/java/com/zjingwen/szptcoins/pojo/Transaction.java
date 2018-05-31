package com.zjingwen.szptcoins.pojo;

public class Transaction {
    private Integer id;

    private String sender;

    private String recipient;

    private Long value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient == null ? null : recipient.trim();
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}