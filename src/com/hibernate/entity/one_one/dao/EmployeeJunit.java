package com.hibernate.entity.one_one.dao;

import com.hibernate.entity.one_one.entity.Employee;
import com.hibernate.entity.one_one.entity.Joinpart;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: Iman
 * date   : 2019/4/10
 */
public class EmployeeJunit {
    private Session session=null;

    @Before
    public void setUp(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
    }
    @After
    public void tearDown(){
        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void addWifeAndHusband(){
        Joinpart joinpart=new Joinpart();
        joinpart.setName("党员");
        Employee employee=new Employee();
        employee.setName("aa");
        employee.setJoinpart(joinpart);
        joinpart.setEmployee(employee);
        session.save(employee);
        session.save(joinpart);


    }
}
