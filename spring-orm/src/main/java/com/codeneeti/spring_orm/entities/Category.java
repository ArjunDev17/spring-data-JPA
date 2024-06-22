package com.codeneeti.spring_orm.entities;

import jakarta.persistence.*;
import org.springframework.data.repository.cdi.Eager;

import java.util.ArrayList;
import java.util.List;

//@Table(name = "category")
@Entity
public class Category {
    @Id
    String cid;
    String title;

//    @ManyToMany(cascade = CascadeType.ALL)
//    List<Product>productList=new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Product>productList=new ArrayList<>();

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid='" + cid + '\'' +
                ", title='" + title + '\'' +
                ", productList=" + productList +
                '}';
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category() {
    }

    public Category(String cid, String title) {
        this.cid = cid;
        this.title = title;
    }
}
