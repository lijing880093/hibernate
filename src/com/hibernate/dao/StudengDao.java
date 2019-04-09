package com.hibernate.dao;

import com.hibernate.entity.Student;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author: Iman
 * date   : 2019/4/8
 */
public class StudengDao {
    public static void main(String[] args) throws HandlerException {

//        注册服务
        StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
//        创建session工厂
        SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
//        获取session
        Session session = sessionFactory.openSession();
//        开始事务
        session.beginTransaction();
//        执行事务
        Student student=new Student();
        student.setName("贝燚");
        student.setAge(22);
        session.save(student);
//        提交，关闭事务
        session.getTransaction().commit();
        session.close();
    }
}
