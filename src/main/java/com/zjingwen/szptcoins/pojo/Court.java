package com.zjingwen.szptcoins.pojo;

public class Court {
    private Integer id;

    private Integer level;

    private String cName;

    private Integer mId;

    private Long rPower;

    private String teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Long getrPower() {
        return rPower;
    }

    public void setrPower(Long rPower) {
        this.rPower = rPower;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }
}