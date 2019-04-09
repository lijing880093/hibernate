package com.hibernate.dao;

import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * @author: Iman
 * date   : 2019/4/9
 */
public class StudentJunit {

    @Test
    public void query(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Student s1=session.get(Student.class,1);
        Student s2=session.get(Student.class,2);
        Student s3=session.get(Student.class,1);

        transaction.commit();
        session.close();
    }
}
