package com.mot.wappmot.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Products {

    private long millis = System.currentTimeMillis();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date = new Date(millis);
    private Time time = new Time(millis);
    private String category;
    private String item;
    private int minPrice;
    private int maxPrice;

    public Products() {
    }

    public Products(int id, String category, String item, int minPrice, int maxPrice) {

        this.id = id;
        this.category = category;
        this.item = item;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public String toString(){
        return "ID: "+id+", Date: "+date+", Time: "+time+", Category: "+category+", Item: "+item+", MinPrice: "+minPrice+", MaxPrice: "+maxPrice+"";
    }
}
