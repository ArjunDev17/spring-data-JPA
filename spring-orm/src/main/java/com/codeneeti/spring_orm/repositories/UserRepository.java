package com.codeneeti.spring_orm.repositories;

import com.codeneeti.spring_orm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//we can extends CrudRepository
//JpaRepository<User,Integer>  here we are making it generic it is telling in which we should work
public interface UserRepository extends JpaRepository<User, Integer> {
//no need to create implimentation class
//    whenever we are using @autowierd in that situation springboot automatically create implimentation
    //class for UserRepository
}
