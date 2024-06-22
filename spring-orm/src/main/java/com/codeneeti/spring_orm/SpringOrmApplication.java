package com.codeneeti.spring_orm;

import com.codeneeti.spring_orm.entities.*;
import com.codeneeti.spring_orm.repositories.CategoryRepo;
import com.codeneeti.spring_orm.repositories.ProductRepo;
import com.codeneeti.spring_orm.repositories.StudentRepository;
import com.codeneeti.spring_orm.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringOrmApplication implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(SpringOrmApplication.class);

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringOrmApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // One-to-One mapping
//        oneToOne();

        // One-to-Many mapping
//        oneToMany();
        manyToMany();
        Optional<Category> cid1 = categoryRepo.findById("cid1");
        logger.info("cid1 data is :{}",cid1);
    }

    public void oneToOne() {
        Student student = new Student();
        student.setStudentName("Rupa Singh");
        student.setAbout("i sister big");

        Laptop laptop = new Laptop();
        laptop.setModelNumber("del0111");
        laptop.setBrand("Dell-21");
        laptop.setStudent(student);
        student.setLaptop(laptop);

        Student saved = studentRepository.save(student);
        logger.info("Saved student: {}", saved);
    }

    public void oneToMany() {
        Student student = new Student();
        student.setStudentId(12);
        student.setStudentName("Shiv");
        student.setAbout("father big");

        Address address1 = new Address();
        address1.setCity("UP");
        address1.setStreet("AECS layout-1");
        address1.setCountry("Bharat");
        address1.setStudent(student);

        Address address2 = new Address();
        address2.setCity("BLR");
        address2.setStreet("AECS layout");
        address2.setCountry("Bharat");
        address2.setStudent(student);

        ArrayList<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);

        student.setAddressList(addressList);

        Student saved = studentRepository.save(student);
        logger.info("Saved student with addresses: {}", saved);
    }
    public void  manyToMany(){
        Product product=new Product();
        product.setPid("pid1");
        product.setProductName("I phone");

        Product product2=new Product();
        product2.setPid("pid2");
        product2.setProductName("I phone 2");

        Product product3=new Product();
        product3.setPid("pid3");
        product3.setProductName("I phone 3");

        Category category=new Category();
        category.setCid("cid1");
        category.setTitle("Electronics");

        Category category2=new Category();
        category2.setCid("cid2");
        category2.setTitle("Electronics :2");

        List<Product> categoryProductList = category.getProductList();
        categoryProductList.add(product);
        categoryProductList.add(product2);
        categoryProductList.add(product3);

        List<Product> category2ProductList = category2.getProductList();
        category2ProductList.add(product);
        category2ProductList.add(product2);

        categoryRepo.save(category);
        categoryRepo.save(category2);


    }
}


//package com.codeneeti.spring_orm;
//
//import com.codeneeti.spring_orm.entities.Address;
//import com.codeneeti.spring_orm.entities.Laptop;
//import com.codeneeti.spring_orm.entities.Student;
//import com.codeneeti.spring_orm.entities.User;
//import com.codeneeti.spring_orm.repositories.StudentRepository;
//import com.codeneeti.spring_orm.services.UserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@SpringBootApplication
//public class SpringOrmApplication implements CommandLineRunner {
//    Logger logger = LoggerFactory.getLogger(SpringOrmApplication.class);
//
//    @Autowired
//    private StudentRepository studentRepository;
//    @Autowired
//    private UserService userService;
//
//    public static void main(String[] args) {
//        System.out.println("Running MyRunner...");
//        SpringApplication.run(SpringOrmApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
////		ONE TO ONE MAPPING
////        oneToOne();
////        One toMany
//        oneToMany();
//    }
//    public  void oneToOne() {
////        Student student = new Student();
////        student.setStudentName("rupa Singh");
////        student.setAbout("i sister big");
////        student.setStudentId(101);
////
////        Laptop laptop = new Laptop();
////        laptop.setModelNumber("del0111");
////        laptop.setLaptopId(21111);
////        laptop.setBrand("Dell-21");
////
////        //important underline
////        laptop.setStudent(student);
////        student.setLaptop(laptop);
////        Student saved = studentRepository.save(student);
////        System.out.println("saved :" + saved);
////        logger.info("saved user id is:{}", saved.getStudentId());
//        Optional<Student> student = studentRepository.findById(101);
//        if (student.isPresent()) {
//            logger.info("Student info: {}", student.get().getStudentName());
//        } else {
//            logger.info("Student with ID {} not found", 101);
//        }
//        logger.info("Student info :{}", student);
//    }
//    public void oneToMany(){
//        Student student = new Student();
//        student.setStudentName("Dev");
//        student.setAbout("i father big");
////        student.setStudentId(103);
//
//        Address address=new Address();
//        address.setAddressId(1);
//        address.setCity("BLR");
//        address.setStreet("AECS layout");
//        address.setCountry("Bharat");
////        student.setStudentId(103);
//        address.setStudent(student);
//
//
//        Address address1=new Address();
//        address1.setAddressId(1);
//        address1.setCity("BLR1");
//        address1.setStreet("AECS layout-1");
//        address1.setCountry("Bharat");
//        address1.setStudent(student);
//
//        ArrayList<Address> addressList = new ArrayList<>();
//        addressList.add(address1);
//        addressList.add(address);
//
//        student.setAddressList(addressList);
//
//        Student saved = studentRepository.save(student);
//        logger.info("saved data is :{}",saved);
//
//
//    }
//}
