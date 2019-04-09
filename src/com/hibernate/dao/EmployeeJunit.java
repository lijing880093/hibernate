package com.hibernate.dao;

import com.hibernate.entity.Department;
import com.hibernate.entity.Employee;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * @author: Iman
 * date   : 2019/4/9
 */
public class EmployeeJunit {




    @Test
    public void addEmployeeAndDepartment(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Department department =new Department();
        department.setName("技术部");
        session.save(department);

        Employee employee1=new Employee();
        employee1.setName("张三");
        employee1.setDepartment(department);
        Employee employee2=new Employee();
        employee2.setName("李四");
        employee2.setDepartment(department);
        Employee employee3=new Employee();
        employee3.setName("王五");
        employee3.setDepartment(department);
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);

        transaction.commit();
        session.close();
    }

    @Test
    public void queryDepartment(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Employee employee=session.get(Employee.class,1);
        System.out.println(employee.getDepartment().getName());

        transaction.commit();
        session.close();
    }
}
