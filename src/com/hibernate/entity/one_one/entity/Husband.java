package com.hibernate.entity.one_one.entity;

/**
 * @author: Iman
 * date   : 2019/4/10
 */
public class Husband {
    private int hid;
    private String name;
    private Wife wife;

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

}
