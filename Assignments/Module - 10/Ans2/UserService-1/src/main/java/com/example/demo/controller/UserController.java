package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController 
{
    @Autowired
    private UserService service;
    
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
    	User savedUser = service.saveUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
    {
    	User user = service.getUserById(id);
    	if(user != null)
    	{
    		return new ResponseEntity<>(user,HttpStatus.CREATED);
    	} 
    	else
    	{
    		return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
    	}
    }
    
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
    	List<User> usr = service.getAllUsers();
    	return new ResponseEntity<>(usr, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        service.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        User updatedUser = service.updateUser(user, id);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
