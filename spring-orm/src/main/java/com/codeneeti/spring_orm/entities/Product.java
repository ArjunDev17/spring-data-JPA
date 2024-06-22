package com.codeneeti.spring_orm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Product {
    @Id
    private String pid;
    private String productName;
    @ManyToMany(mappedBy = "productList")
    List<Category>categoryList=new ArrayList<>();
    public Product() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Product(String pid, String productName) {
        this.pid = pid;
        this.productName = productName;
    }

}
