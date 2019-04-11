package com.hibernate.entity.one_one.entity;

/**
 * @author: Iman
 * date   : 2019/4/10
 */
public class Joinpart {
    private int id;
    private String name;
    private  Employee employee;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
