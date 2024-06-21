package com.codeneeti.spring_orm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private String city;
    private String street;
    private String country;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Address() {}

    public Address(int addressId, String city, String street, String country, Student student) {
        this.addressId = addressId;
        this.city = city;
        this.street = street;
        this.country = country;
        this.student = student;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", country='" + country + '\'' +
                ", studentId=" + (student != null ? student.getStudentId() : "null") +
                '}';
    }
}



//package com.codeneeti.spring_orm.entities;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "address")
//public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int addressId;
//
//    private String city, street, country;
//
////    @ManyToOne
////    @JoinColumn(name = "student_id")
////    private Student student;
//@ManyToOne
//@JoinColumn(name = "student_id")
//private Student student;
//
////    @ManyToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "student_id")
////    private Student student;
//
//
//    public Address() {
//
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    public Address(int addressId, String city, String street, String country) {
//        this.addressId = addressId;
//        this.city = city;
//        this.street = street;
//        this.country = country;
//    }
//
//    public int getAddressId() {
//        return addressId;
//    }
//
//    public void setAddressId(int addressId) {
//        this.addressId = addressId;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//
//}
