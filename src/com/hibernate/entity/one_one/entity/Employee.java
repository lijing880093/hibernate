package com.hibernate.entity.one_one.entity;

/**
 * @author: Iman
 * date   : 2019/4/10
 */
public class Employee {
    private int id;
    private String name;
    private  Joinpart joinpart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Joinpart getJoinpart() {
        return joinpart;
    }

    public void setJoinpart(Joinpart joinpart) {
        this.joinpart = joinpart;
    }
}
