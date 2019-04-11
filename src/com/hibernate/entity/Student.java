package com.hibernate.entity;

/**
 * @author : Iman
 * date : 2019/4/9
 */
public class Student {

    private int id;
    private String name;
    private Classes classes;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }



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



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classes=" + classes.getClassName()+
                '}';
    }
}
