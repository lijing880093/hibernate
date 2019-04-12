package com.hibernate.dao;

import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author : Iman
 * date : 2019/4/9
 */
public class JunitTest {

    Session session=null;
    @Before
    public void before(){
        session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    @After
    public void after(){
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void addUser(){

        for (int i = 0; i <10 ; i++) {
            User user =  new User("admin"+i,"admin"+i);
            session.save(user);
        }
    }

    /**
     * 查询全部
     */
    @Test
    public void queryAll(){
        String hql="from User";
//        Query query = session.createQuery(hql);
        Query<User> query = session.createQuery(hql, User.class);
        List<User> list = query.list();
        for (User user :list) {
            System.out.println(user);
        }
    }

    /**
     * 通过id查询
     */
    @Test
    public void queryOne(){
        String hql="from User where id = :sid ";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("sid",1);
        User user = query.list().get(0);
        System.out.println(user);
    }

    /**
     * 模糊查询
     */
    @Test
    public void queryLike(){
       // String hql="from User where username like :username ";
        String hql="from User where id < :sid ";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("sid",5);
        List<User> list = query.list();
        for (User user :list) {
            System.out.println(user);
        }
    }

    /**
     * 分页查询
     */
    @Test
    public void queryPage(){
        // hql语句
        String hql="from User ";
        // 创建查询
        Query<User> query = session.createQuery(hql, User.class);
        // 查询开始索引
        query.setFirstResult(5);
        // 每页显示条数
        query.setMaxResults(5);
        // 获取查询信息
        List<User> list = query.list();
        for (User user :list) {
            System.out.println(user);
        }
    }

    /**
     * 命名查询
     */
    @Test
    public void queryLike2(){
        // xml 映射的hql语句名
        String name="queryUser";
        // 创建名称查询
        Query<User> query = session.getNamedQuery(name);
        query.setParameter("username","a%");
        // 获取查询信息
        List<User> list = query.list();
        for (User user :list) {
            System.out.println(user);
        }
    }

    /**
     * 投影查询
     */
    @Test
    public void queryTouYing(){
        //hql语句
        String hql="select id,username,password from User";
        // 创建名称查询
        Query<Object[]> query = session.createQuery(hql, Object[].class);
        // 获取查询信息
        List<Object[]> list = query.list();
        for (Object[] objects:list) {
            System.out.println(Arrays.toString(objects));
            System.out.println(objects[0]);
        }
    }

    /**
     * 聚合查询
     */
    @Test
    public void queryCount(){
        //hql语句
        String hql="select count(*) from User";
        // 创建名称查询
        Query<Object> query = session.createQuery(hql, Object.class);
        // 获取查询信息
        Object objects = query.uniqueResult();
        Number num = (Number)objects;
        int i = num.intValue();
        System.out.println("i="+i);
    }

    @Test
    public void queryOID(){

        /**
         * session.get()  查询
         * session.load() 删除
         */
        User user2 = session.load(User.class, 2);
        User user1 = session.get(User.class, 1);
        System.out.println(user2);
        System.out.println(user1);
    }


}
