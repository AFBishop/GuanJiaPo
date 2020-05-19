package com.bishop.domain;

public class ZhangWu {
    // id
    private int zwid;
    //分类名称
    private String flname;
    // 账户名称
    private String zhangHu;
    // 金额
    private double money;
    // 创建时间
    private String createtime;
    // 说明
    private String description;
    public ZhangWu(){}

    public ZhangWu(int zwid, String flname, double money, String zhangHu, String createtime, String description){
        this.zwid = zwid;
        this.flname = flname;
        this.money = money;
        this.zhangHu = zhangHu;
        this.createtime = createtime;
        this.description = description;
    }

    public int getZwid() {
        return zwid;
    }

    public void setZwid(int zwid) {
        this.zwid = zwid;
    }

    public String getFlname() {
        return flname;
    }

    public void setFlname(String flname) {
        this.flname = flname;
    }

    public String getZhangHu() {
        return zhangHu;
    }

    public void setZhangHu(String zhangHu) {
        this.zhangHu = zhangHu;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
