package com.hibernate.entity.many_many.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Iman
 * date   : 2019/4/11
 */
public class User {
    private Integer id;
    private String name;
    private Set<Role> roleSet=new HashSet<>();

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public User(String name, Set<Role> roleSet) {
        this.name = name;
        this.roleSet = roleSet;
    }
}
