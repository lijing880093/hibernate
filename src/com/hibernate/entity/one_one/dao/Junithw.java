package com.hibernate.entity.one_one.dao;

import com.hibernate.entity.one_one.entity.Husband;
import com.hibernate.entity.one_one.entity.Wife;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: Iman
 * date   : 2019/4/10
 */
public class Junithw {
    private Session session=null;

    @Before
    public void setUp(){

        session = HibernateUtil.getSession();
        session.beginTransaction();
    }
    @After
    public void tearDown(){
        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void addWifeAndHusband(){
        Wife wife=new Wife();
        Husband husband=new Husband();
        wife.setName("小龙女");

        husband.setName("杨过");
        husband.setWife(wife);
        wife.setHusband(husband);
        session.save(husband);


    }
}
