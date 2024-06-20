package com.codeneeti.spring_orm;

import com.codeneeti.spring_orm.entities.User;
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
	private UserService userService;
	public static void main(String[] args) {
		System.out.println("Running MyRunner...");
		SpringApplication.run(SpringOrmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user = new User();
////		user.setId(1);
//		user.setName("aaru");
//		user.setCity("LKO");
//		user.setAge(12);
//		User savedUser = userService.saveUser(user);
//		System.out.println(savedUser);

		User user = userService.getUser(102);
		System.out.println("user is :"+user);
	}
}
