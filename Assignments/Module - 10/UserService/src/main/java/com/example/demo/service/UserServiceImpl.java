package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    @Override
    public User addStudent(User s) {
        return repo.save(s);
    }

    @Override
    public List<User> viewAllStudent() {
        return repo.findAll();
    }

    @Override
    public User studentById(int id) {
        return repo.findById(id).orElseThrow(() -> 
            new RuntimeException("User not found with ID: " + id));
    }

    @Override
    public User updateStudent(User s, int id) {
        User existingUser = repo.findById(id).orElseThrow(() -> 
            new RuntimeException("User not found with ID: " + id));
        s.setId(existingUser.getId()); 
        return repo.save(s);
    }

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
}
