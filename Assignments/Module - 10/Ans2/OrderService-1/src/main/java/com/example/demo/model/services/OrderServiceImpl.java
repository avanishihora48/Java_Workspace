package com.example.demo.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.example.demo.model.repositories.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepo repo;
    
	@Override
	public Order saveOrder(Order order) {
		// TODO Auto-generated method stub
		return repo.save(order);
	}

	@Override
	public Order getOrderById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Order> getOrdersByUserId(Long userId) {
        return repo.findByUserId(userId);
    }

	@Override
	public void deleteOrder(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Order updateOrder(Order odr, Long id) {
		// TODO Auto-generated method stub
		Order existingOrder = repo.findById(id).orElseThrow(() -> 
	    new RuntimeException("Order not found with ID: " + id));
		odr.setOrderId(existingOrder.getOrderId()); 
		return repo.save(odr);
	}

}
