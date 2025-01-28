package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService 
{
	public User addStudent(User s);
	public List<User> viewAllStudent();
	public User studentById(int id);
	User updateStudent(User s, int id);
	void deleteStudent(int id);
}
