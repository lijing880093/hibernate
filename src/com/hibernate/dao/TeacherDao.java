package com.hibernate.dao;

import com.hibernate.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;

/**
 * @author: Iman
 * date   : 2019/4/8
 */
public class TeacherDao {
    public static void main(String[] args) throws Exception{
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Teacher teacher=new Teacher();
        teacher.setId(1);
        teacher.setName("梁文道");
        teacher.setAge(43);
        teacher.setSex("男");
        teacher.setBirth(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1976-04-08 20:07:35"));

        session.save(teacher);

        transaction.commit();
        session.close();
        sessionFactory.close();



    }
}
