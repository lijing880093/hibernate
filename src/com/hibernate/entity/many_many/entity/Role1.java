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
@Table(name = "role1")
public class Role1 {
    private Integer id;
    private String name;
    private Set<Menu1> menu1Set=new HashSet<>();


    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native",strategy = "native")
    @Column(name="r_id")
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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_menu",
            joinColumns ={@JoinColumn(name="r_id")},
            inverseJoinColumns = {@JoinColumn(name="m_id")}
    )
    public Set<Menu1> getMenu1Set() {
        return menu1Set;
    }

    public void setMenu1Set(Set<Menu1> menu1Set) {
        this.menu1Set = menu1Set;
    }
}
