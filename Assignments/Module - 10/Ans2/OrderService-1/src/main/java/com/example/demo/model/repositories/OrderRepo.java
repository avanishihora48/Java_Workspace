package com.example.demo.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long>
{

	List<Order> findByUserId(Long userId);

}
