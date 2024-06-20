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

@SpringBootApplication
public class SpringOrmApplication implements CommandLineRunner {
	Logger logger=LoggerFactory.getLogger(SpringOrmApplication.class);

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

//		User user = new User();
//		user.setId(1);
//		user.setName("kabbu Babu");
//		user.setCity("Bangalore");
//		user.setAge(3);
//		User savedUser = userService.saveUser(user);
//		System.out.println(savedUser);
//		User updateUser = userService.updateUser(user, 2);

//		User user = userService.getUser(102);
//		System.out.println("user is :"+user);
//		logger.info("update use details are :{}",updateUser);
//		userService.deleteUser(102);
		Student student=new Student();
		student.setStudentName("Kabeer Singh");
		student.setStudentId(211);
		student.setAbout("i am SB");


		Laptop laptop = new Laptop();
		laptop.setModelNumber("del01");
		laptop.setLaptopId(211);
		laptop.setBrand("Dell");
//		laptop.setStudent(student);
		student.setLaptop(laptop);
		Student saved = studentRepository.save(student);
		System.out.println("saved :"+saved);
	}
}
