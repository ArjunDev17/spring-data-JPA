package com.codeneeti.spring_orm.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String about;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addressList = new ArrayList<>();

    public Student() {}

    public Student(int studentId, String studentName, String about, Laptop laptop) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.about = about;
        this.laptop = laptop;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", about='" + about + '\'' +
                ", laptopId=" + (laptop != null ? laptop.getLaptopId() : "null") +
                '}';
    }
}



//package com.codeneeti.spring_orm.entities;
//
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "student")
//public class Student {
////    @Id
////    private int studentId;
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//private int studentId;
//    private String studentName;
//    private String about;
//
////    @Override
////    public String toString() {
////        return "Student{" +
////                "studentId=" + studentId +
////                ", studentName='" + studentName + '\'' +
////                ", about='" + about + '\'' +
////                ", laptop=" + laptop +
////                '}';
////    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "studentId=" + studentId +
//                ", studentName='" + studentName + '\'' +
//                ", about='" + about + '\'' +
//                // Avoid recursive call to Laptop.toString()
//                ", laptopId=" + (laptop != null ? laptop.getLaptopId() : "null") +
//                '}';
//    }
//
//    public int getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }
//
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
//    }
//
//    public String getAbout() {
//        return about;
//    }
//
//    public void setAbout(String about) {
//        this.about = about;
//    }
//
//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }
//
//    public Student() {
//
//    }
//
//    public Student(int studentId, String studentName, String about, Laptop laptop) {
//        this.studentId = studentId;
//        this.studentName = studentName;
//        this.about = about;
//        this.laptop = laptop;
//    }
//
//    //    @OneToOne
////    private Laptop laptop;
//
////    @OneToOne(mappedBy = "student")
////    private Laptop laptop;
//
////    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
////    private Laptop laptop;
//////    oneToMany relationship
////    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
////    private List<Address> addressList=new ArrayList<>();
//@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
//private Laptop laptop;
//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Address> addressList = new ArrayList<>();
//
//
//    public List<Address> getAddressList() {
//        return addressList;
//    }
//
//    public void setAddressList(List<Address> addressList) {
//        this.addressList = addressList;
//    }
//}
