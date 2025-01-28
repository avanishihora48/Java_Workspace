package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users") 
public class MyController {

   @Autowired
   private UserService usr;

   @GetMapping("/")
   public String home() {
       return "Hello, Welcome to the User Management Application!";
   }

   @GetMapping
   public ResponseEntity<List<User>> viewAllUsers() {
       List<User> all = usr.viewAllUsers();
       return new ResponseEntity<>(all, HttpStatus.OK);
   }

   @PostMapping
   public ResponseEntity<User> addUser(@RequestBody User user) {
       User savedUser = usr.saveUser(user);
       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
       usr.deleteUser(id);
       return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
   }

   @GetMapping("/{id}")
   public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
       User user = usr.userById(id);
       if (user != null) {
           return new ResponseEntity<>(user, HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }

   @PutMapping("/{id}")
   public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
       User updatedUser = usr.updateUser(user, id);
       if (updatedUser != null) {
           return new ResponseEntity<>(updatedUser, HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }
}
