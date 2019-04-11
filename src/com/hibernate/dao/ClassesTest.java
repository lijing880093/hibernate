package com.hibernate.dao;

import com.hibernate.entity.Classes;
import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * @author: Iman
 * date   : 2019/4/9
 */
public class ClassesTest {
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
    public void addStudentAndClasses(){
        Classes classes =  new Classes();
        classes.setClassName("高一");
        session.save(classes);
        Student stu1 =  new Student();
        stu1.setName("aa");
        stu1.setClasses(classes);
        Student stu2 =  new Student();
        stu2.setName("bb");
        stu2.setClasses(classes);
        classes.getStudentSet().add(stu1);
        classes.getStudentSet().add(stu2);
        session.save(stu1);
        session.save(stu2);
    }

    @Test
    public void queryStudentByClasses(){

        Classes classes = session.get(Classes.class, 1);
        Set<Student> studentSet = classes.getStudentSet();
        for (Student student:studentSet) {
            System.out.println(student);
        }
    }
    @Test
    public void updateClasses(){
        Classes classes = session.get(Classes.class, 1);
        classes.setClassName("UI");
        Set<Student> studentSet = classes.getStudentSet();
        for (Student student:studentSet) {
            student.setName("cc");

        }
    }
    @Test
    public void delete(){
        Student student = session.get(Student.class, 1);
        student.setClasses(null);
        session.save(student);

    }
    @Test
    public void addClassesToStudent(){
        Classes classes = session.get(Classes.class, 1);
        Student student = session.get(Student.class, 1);
        student.setClasses(classes);
        classes.getStudentSet().add(student);
    }

    @Test
    public void deleteClasses(){
        Classes classes = session.get(Classes.class, 1);
        session.delete(classes);
    }
}
