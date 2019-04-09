package com.hibernate.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author : Iman
 * date : 2019/4/9
 */
public class HibernateUtil {
    private static SessionFactory SESSION_FACTORY=null;
    private static Session SESSION = null;

    static {
        Configuration configuration =  new Configuration().configure();
        SESSION_FACTORY = configuration.buildSessionFactory();
    }

    public static  SessionFactory getSessionFactory(){

        return SESSION_FACTORY;
    }

    public static Session getSession(){
        SESSION = getSessionFactory().openSession();
        return SESSION;
    }

}