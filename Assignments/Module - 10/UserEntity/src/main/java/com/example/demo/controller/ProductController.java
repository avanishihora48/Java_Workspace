package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController 
{
    @Autowired
    private ProductService prodSer;
    
    @GetMapping
    public ResponseEntity<List<Product>>viewAllProducts()
    {
    	List<Product> all = prodSer.viewAllProducts();
    	return new ResponseEntity<>(all, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Product>addProduct(@RequestBody Product prod)
    {
    	Product saveProduct = prodSer.saveProduct(prod);
		return new ResponseEntity<>(saveProduct,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteProduct(@PathVariable("id") Long id)
    {
    	prodSer.deleteProduct(id);
		return new ResponseEntity<>("Product deleted successfully!",HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product>productById(@PathVariable("id") Long id)
    {
    	Product product = prodSer.productById(id);
    	if(product != null)
    	{
    		return new ResponseEntity<>(product,HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<>(product,HttpStatus.NOT_FOUND);
    	}
    }
    
    public ResponseEntity<Product> updateProduct(@RequestBody Product prod,@PathVariable("id") Long id)
	{
    	Product updateProduct = prodSer.updateProduct(prod, id);
    	if (updateProduct != null) 
    	{
    		return new ResponseEntity<>(updateProduct, HttpStatus.OK);
        } 
    	else 
    	{
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
}
