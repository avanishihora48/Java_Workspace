package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepo repo;
	@Override
	public User saveUser(User s) {
		// TODO Auto-generated method stub
		return repo.save(s);
	}

	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public User userById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(() -> 
        new RuntimeException("User not found with ID: " + id));
	}

	@Override
	public User updateUser(User s, Long id) {
		// TODO Auto-generated method stub
		User existingUser = repo.findById(id).orElseThrow(() -> 
        new RuntimeException("User not found with ID: " + id));
	    s.setId(existingUser.getId()); 
	    return repo.save(s);
	}
}
