package com.codeneeti.spring_orm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private int studentId;
    private String studentName;
    private String about;

//    @Override
//    public String toString() {
//        return "Student{" +
//                "studentId=" + studentId +
//                ", studentName='" + studentName + '\'' +
//                ", about='" + about + '\'' +
//                ", laptop=" + laptop +
//                '}';
//    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", about='" + about + '\'' +
                // Avoid recursive call to Laptop.toString()
                ", laptopId=" + (laptop != null ? laptop.getLaptopId() : "null") +
                '}';
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

    public Student() {

    }

    public Student(int studentId, String studentName, String about, Laptop laptop) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.about = about;
        this.laptop = laptop;
    }

    //    @OneToOne
//    private Laptop laptop;

//    @OneToOne(mappedBy = "student")
//    private Laptop laptop;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;
}
