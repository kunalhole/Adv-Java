package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;
@Service
public class ProudctServiceImpl implements ProductService {

	@Autowired
	private ProductDao pd;
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return pd.getProducts();
	}
	@Override
	public void addProudct(Product p) {
		pd.addProduct(p);
		
	}
	@Override
	public void deleteProduct(int id) {
		pd.deleteProduct(id);
		
	}
	@Override
	public Product getById(int id) {
		return pd.getById(id);
	}
	@Override
	public void updateProduct(Product p) {
	   pd.updateProduct(p);
	}

}
