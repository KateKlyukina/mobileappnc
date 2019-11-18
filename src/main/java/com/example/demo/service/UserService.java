package com.example.demo.service;

import com.example.demo.models.User;

import java.util.List;

public interface UserService {
    User findUserById(Integer id);
    void save(User user);
    void deleteUserById(Integer id);
    List<User> allUsers();
}
