package com.codeneeti.spring_orm.services.impl;

import com.codeneeti.spring_orm.entities.User;
import com.codeneeti.spring_orm.repositories.UserRepository;
import com.codeneeti.spring_orm.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        User saved = userRepository.save(user);
        logger.info("User save id :{}",saved.getId());
        return saved;
    }

    @Override
    public User updateUser(User user, int userId) {
        User user1=getUser(userId);
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        user1.setCity(user.getCity());
        return saveUser(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        logger.info("User deleted id {}",user.getId());
        userRepository.delete(user);

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);
//        User user = userOptional.orElseThrow(() -> new RuntimeException("User not find for this ID"));
//        return user;
        return userOptional.orElseThrow(() -> new RuntimeException("User not find for this ID"));
    }
}
