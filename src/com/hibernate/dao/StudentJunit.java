package com.hibernate.dao;

import com.hibernate.entity.Classes;
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


    @Test
    public void addStudentAndClasses(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Classes classes=new Classes();
        classes.setName("艺术班");
        session.save(classes);

        Student s1=new Student();
        s1.setName("aa");
        s1.setClasses(classes);
        Student s2=new Student();
        s2.setName("bb");
        s2.setClasses(classes);

        session.save(s1);
        session.save(s2);



        transaction.commit();
        session.close();
    }

    @Test
    public void queryClasses(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Student student=session.get(Student.class,1);
        System.out.println(student.getClasses().getName());


        transaction.commit();
        session.close();
    }
}
