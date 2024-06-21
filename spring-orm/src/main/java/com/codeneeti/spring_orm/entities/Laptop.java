package com.codeneeti.spring_orm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Laptop {
    @Id
    private int laptopId;
    private String modelNumber;
    private String brand;

    public Laptop() {

    }

//    @Override
//    public String toString() {
//        return "Laptop{" +
//                "laptopId=" + laptopId +
//                ", modelNumber='" + modelNumber + '\'' +
//                ", brand='" + brand + '\'' +
//                ", student=" + student +
//                '}';
//    }

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopId=" + laptopId +
                ", modelNumber='" + modelNumber + '\'' +
                ", brand='" + brand + '\'' +
                // Avoid recursive call to Student.toString()
                ", studentId=" + (student != null ? student.getStudentId() : "null") +
                '}';
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Laptop(int laptopId, String modelNumber, String brand, Student student) {
        this.laptopId = laptopId;
        this.modelNumber = modelNumber;
        this.brand = brand;
        this.student = student;
    }

    //    @OneToOne
//    private Student student;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
