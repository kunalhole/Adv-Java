package com.demo.service;

import java.util.List;

import com.demo.model.Product;

public interface ProductService {

	public List<Product> getProducts();
	public void addProudct(Product p);
	public void deleteProduct(int id);
	public Product getById(int id);
	public void updateProduct(Product p);
}
