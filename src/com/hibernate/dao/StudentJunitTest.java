package com.hibernate.dao;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author: Iman
 * date   : 2019/4/8
 */
public class StudentJunitTest {
    SessionFactory sessionFactory=null;
    Session session=null;
    @Before
    public void dobefore(){
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
    }
    @After
    public void doafter(){
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
    /**
     * 1.该类不能私有化构造方法
     * 2.方法必须是公有的
     * 3.方法是没有返回值
     * 4.方法没有参数
     */
    @Test
    public void add(){

        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(10);
        session.save(student);

    }

    @Test
    public void update(){

        Student student = session.get(Student.class, 1);
        student.setName("张三");
        student.setAge(12);
        session.save(student);
    }

    @Test
    public void delete(){

        Student student = session.get(Student.class, 1);
        if(student!=null) {
            session.delete(student);
        }
    }

    @Test
    public void query(){
        // 查询的是对象（类名）
        String hql="from Student";

        Query query = session.createQuery(hql);
        List<Student> list = query.list();
        for (Student s:list) {
            System.out.println(s);
        }
    }
}
