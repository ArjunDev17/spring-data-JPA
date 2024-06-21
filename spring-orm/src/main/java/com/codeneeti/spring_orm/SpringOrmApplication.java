package com.codeneeti.spring_orm;

import com.codeneeti.spring_orm.entities.Laptop;
import com.codeneeti.spring_orm.entities.Student;
import com.codeneeti.spring_orm.entities.User;
import com.codeneeti.spring_orm.repositories.StudentRepository;
import com.codeneeti.spring_orm.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class SpringOrmApplication implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(SpringOrmApplication.class);

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        System.out.println("Running MyRunner...");
        SpringApplication.run(SpringOrmApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//			ONE TO ONE MAPPING

//        Student student = new Student();
//        student.setStudentName("rupa Singh");
//        student.setAbout("i sister big");
//        student.setStudentId(101);
//
//        Laptop laptop = new Laptop();
//        laptop.setModelNumber("del0111");
//        laptop.setLaptopId(21111);
//        laptop.setBrand("Dell-21");
//
//        //important underline
//        laptop.setStudent(student);
//        student.setLaptop(laptop);
//        Student saved = studentRepository.save(student);
//        System.out.println("saved :" + saved);
//        logger.info("saved user id is:{}", saved.getStudentId());
        Optional<Student> student = studentRepository.findById(101);
        if (student.isPresent()) {
            logger.info("Student info: {}", student.get().getStudentName());
        } else {
            logger.info("Student with ID {} not found", 101);
        }
        logger.info("Student info :{}",student);
    }
}
