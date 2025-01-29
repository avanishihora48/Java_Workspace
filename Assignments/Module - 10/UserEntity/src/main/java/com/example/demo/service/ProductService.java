package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService 
{
	Product saveProduct(Product pro);
    List<Product> viewAllProducts();
    void deleteProduct(Long id);
    Product productById(Long id);
    Product updateProduct(Product pro, Long id);
}
