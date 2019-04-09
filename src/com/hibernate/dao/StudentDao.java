package com.hibernate.dao;

import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author : Iman
 * date : 2019/4/9
 */
public class StudentDao {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Student student= new Student();
        student.setName("zhangfei");
        student.setSex("男");
        try {
            student.setBirthday(new SimpleDateFormat("yyyy-MM-ss").parse("1984-01-13"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        session.save(student);


        Student s=session.get(Student.class,1);
        System.out.println(s);


        session.getTransaction().commit();
        session.close();

    }


}
