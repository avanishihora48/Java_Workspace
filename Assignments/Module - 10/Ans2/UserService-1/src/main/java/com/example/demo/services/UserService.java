package com.example.demo.services;

import java.util.List;

import com.example.demo.model.User;

public interface UserService 
{
    User saveUser(User usr);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User updateUser(User s, Long id);
}
