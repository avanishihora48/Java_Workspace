package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepo repo;
    
	@Override
	public Product saveProduct(Product pro) {
		// TODO Auto-generated method stub
		return repo.save(pro);
	}

	@Override
	public List<Product> viewAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Product productById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public Product updateProduct(Product pro, Long id) {
		// TODO Auto-generated method stub
		Product existingProduct = repo.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(pro.getName());
            existingProduct.setDescription(pro.getDescription());
            existingProduct.setPrice(pro.getPrice());
            return repo.save(existingProduct);
        }
        return null;
	}

}
