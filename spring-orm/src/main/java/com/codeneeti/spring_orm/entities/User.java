package com.codeneeti.spring_orm.entities;

import jakarta.persistence.*;

//@Entity will makethis class or map it to database
//@Table by using this annotation we can give our own table name otherwise class name only become table name
@Entity
@Table(name = "user")
public class User {
//    @Id by using this we can make any field as primary key
//    @Column we can define extra feature using this like colum name and more
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name",length = 20)
    private String name;
    @Column(name = "user_city")
    private String city;
    @Column(name = "user_age")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
