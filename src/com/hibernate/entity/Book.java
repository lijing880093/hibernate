package com.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

/**
 * @author: Iman
 * date   : 2019/4/8
 */
@Entity
@Table(name = "book")
public class Book {
    private int id;
    private String name;
    private Date pulishDate;
    private float price;
    private Blob bookimage;
    @Id
    @GenericGenerator(name = "_native",strategy ="native" )
    @GeneratedValue(generator = "native")
    @Column(name = "b_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "pulish_date")
    public Date getPulishDate() {
        return pulishDate;
    }

    public void setPulishDate(Date pulishDate) {
        this.pulishDate = pulishDate;
    }
    @Column
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    @Column(name = "book_image")
    public Blob getBookimage() {
        return bookimage;
    }

    public void setBookimage(Blob bookimage) {
        this.bookimage = bookimage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pulishDate=" + pulishDate +
                ", price=" + price +
                ", bookimage=" + bookimage +
                '}';
    }
}
