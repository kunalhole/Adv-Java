package com.demo.dao;

import java.util.List;

import com.demo.model.Product;

public interface ProductDao {

	public List<Product> getProducts();
	public void addProduct(Product p);
	public void deleteProduct(int id);
	public Product getById(int id);
	public void updateProduct(Product p);
}
