package com.hibernate.entity.many_many.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Iman
 * date   : 2019/4/11
 */
@Entity
@Table(name = "menu1")
public class Menu1 {
    private Integer id;
    private String name;
    private Set<Role1> role01Set = new HashSet<>();

    @Id
    @GenericGenerator(name = "_native",strategy = "native")
    @GeneratedValue(generator ="_native" )
    @Column(name = "m_id")
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

    @ManyToMany(mappedBy = "menu1Set")
    public Set<Role1> getRole01Set() {
        return role01Set;
    }

    public void setRole01Set(Set<Role1> role01Set) {
        this.role01Set = role01Set;
    }
}
