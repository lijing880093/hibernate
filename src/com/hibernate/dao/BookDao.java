package com.hibernate.dao;

import com.hibernate.entity.Book;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * @author: Iman
 * date   : 2019/4/8
 */
public class BookDao {
    public static void main(String[] args) throws Exception{
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Book book=new Book();
        book.setId(1);
        book.setName("教父");
        book.setPrice(15.6f);
        book.setPulishDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-04-08 18:07:35"));

        LobHelper lobHelper=session.getLobHelper();
        InputStream in=new FileInputStream("D:\\files\\image\\25d35c7cde41414fbee04b13549de08a_1.jpg");
        book.setBookimage(lobHelper.createBlob(in,in.available()));
        session.save(book);

        transaction.commit();
        session.close();
        sessionFactory.close();



    }
}
