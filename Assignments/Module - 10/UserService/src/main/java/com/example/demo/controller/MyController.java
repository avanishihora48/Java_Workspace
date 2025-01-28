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
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class MyController 
{
	@Autowired
	   UserService studentService;
	   
	   @RequestMapping("/")
	   public String home()
	   {
		 return "hello";
	   }
	   
	   @GetMapping("/students")
	   public ResponseEntity<List<User>> viewAllStudent() 
		{
			// TODO Auto-generated method stub
			List<User> all = studentService.viewAllStudent();
			return new ResponseEntity<List<User>> (all,HttpStatus.OK);
		}
	   
	   @PostMapping("/students")
	   public ResponseEntity<User> addStudent(@RequestBody User std) 
		{
			// TODO Auto-generated method stub
			User st = studentService.addStudent(std);
			return new ResponseEntity<User> (st,HttpStatus.CREATED);
		}
	   
	   @DeleteMapping("/students/{id}")
	   public String deleteStudent(@PathVariable("id")int id)
	   {
		   studentService.deleteStudent(id);
		   return "Student deleted";
	   }
	   
	   @GetMapping("students/{id}")
	   public ResponseEntity<User> studentById(@PathVariable("id")int id)
	   {
		   User std = studentService.studentById(id);
		   return new ResponseEntity<User>(std,HttpStatus.OK);
	   }
	   
	   @PutMapping("/students/{id}")
		public ResponseEntity<User> updateStudent(@RequestBody User s,@PathVariable("id") int id)
		{
			User st = studentService.updateStudent(s, id);
			return new ResponseEntity<User>(st,HttpStatus.OK);
		}
}
