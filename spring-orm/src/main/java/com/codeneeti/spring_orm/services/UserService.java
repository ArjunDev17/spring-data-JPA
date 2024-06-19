package com.codeneeti.spring_orm.services;

import com.codeneeti.spring_orm.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User updateUser(User user,int userId);
    void deleteUser(int id);
    List<User> getAllUser();
    User getUser(int userId);
}
