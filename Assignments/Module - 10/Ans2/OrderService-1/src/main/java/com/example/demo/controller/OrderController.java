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

import com.example.demo.model.Order;
import com.example.demo.model.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController 
{
   @Autowired
   private OrderService service;
   
   @PostMapping
   public ResponseEntity<Order> addOrder(@RequestBody Order order)
   {
	  Order odr = service.saveOrder(order);
	  return new ResponseEntity<>(odr,HttpStatus.OK);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Order> getOrderById(@PathVariable Long id)
   {
	   Order odr = service.getOrderById(id);
	   	if(odr != null)
	   	{
	   		return new ResponseEntity<>(odr,HttpStatus.CREATED);
	   	} 
	   	else
	   	{
	   		return new ResponseEntity<>(odr,HttpStatus.NOT_FOUND);
	   	}
   }
   
   @GetMapping
   public ResponseEntity<List<Order>> getAllOrders()
   {
	   List<Order> odr = service.getAllOrders();
	   return new ResponseEntity<>(odr,HttpStatus.OK);
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id) {
       service.deleteOrder(id);
       return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<Order> updateOrder(@RequestBody Order odr, @PathVariable("id") Long id) {
       Order updatedUser = service.updateOrder(odr, id);
       if (updatedUser != null) {
           return new ResponseEntity<>(updatedUser, HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }
}
