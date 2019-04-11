package com.hibernate.entity.one_one.entity;

/**
 * @author: Iman
 * date   : 2019/4/10
 */
public class Wife {
    private int wid;
    private String name;
    private Husband husband;

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.hibernate.entity.one_one.entity.Husband getHusband() {
        return husband;
    }

    public void setHusband(com.hibernate.entity.one_one.entity.Husband husband) {
        husband = husband;
    }
}
