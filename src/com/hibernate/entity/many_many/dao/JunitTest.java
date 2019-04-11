package com.hibernate.entity.many_many.dao;

import com.hibernate.entity.many_many.entity.*;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: Iman
 * date   : 2019/4/11
 */
public class JunitTest {
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
    public void addUserAndRole(){
        User user1=new User();
        user1.setName("aa");
        User user2=new User();
        user2.setName("bb");
        User user3=new User();
        user3.setName("cc");
        User user4=new User();
        user4.setName("dd");
        User user5=new User();
        user5.setName("ee");
        User user6=new User();
        user6.setName("ff");

        Role role1=new Role();
        role1.setName("人事经理");
        Role role2=new Role();
        role2.setName("产品经理");
        Role role3=new Role();
        role3.setName("总经理");

        user1.getRoleSet().add(role1);
        user2.getRoleSet().add(role1);
        user3.getRoleSet().add(role1);
        user4.getRoleSet().add(role2);
        user5.getRoleSet().add(role2);
        user6.getRoleSet().add(role3);


        Menu menu1=new Menu();
        menu1.setName("职员信息管理");
        Menu menu2=new Menu();
        menu2.setName("职员任职信息");
        Menu menu3=new Menu();
        menu3.setName("产品销售报告");
        Menu menu4=new Menu();
        menu4.setName("产品列表");
        Menu menu5=new Menu();
        menu5.setName("部门经理述职报告");
        Menu menu6=new Menu();
        menu6.setName("公司财务报告");
        Menu menu7=new Menu();
        menu7.setName("企业责任专栏");
        role1.getMenuSet().add(menu1);
        role1.getMenuSet().add(menu2);
        role2.getMenuSet().add(menu3);
        role2.getMenuSet().add(menu4);
        role3.getMenuSet().add(menu5);
        role3.getMenuSet().add(menu6);
        role3.getMenuSet().add(menu7);

        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.save(user5);
        session.save(user6);
        session.save(role1);
        session.save(role2);
        session.save(role3);
    }
    @Test
    public void addRoleAndMenu(){

        Menu1 menu1 = new Menu1();
        menu1.setName("管理员url");
        Menu1 menu2 = new Menu1();
        menu2.setName("安保url");

        Role1 role1 =  new Role1();
        role1.setName("管理员");
        role1.getMenu1Set().add(menu1);
        role1.getMenu1Set().add(menu2);

        Role1 role2 =  new Role1();
        role2.setName("保安");
        role2.getMenu1Set().add(menu2);

        session.save(role1);
        session.save(role2);

    }
}
