package com.example.demo.model.services;

import java.util.List;

import com.example.demo.model.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface OrderService 
{
	Order saveOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    List<Order> getOrdersByUserId(Long userId);
    void deleteOrder(Long id);
	Order updateOrder(Order odr, Long id);
}
