package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;

public interface UserService 
{
	public User saveUser(User user);
	public List<User> viewAllUsers();
	public User userById(Long id);
	User updateUser(User s, Long id);
	public void deleteUser(Long id);
	
}
