package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getProducts() {
		return jdbcTemplate.query("select * from product", (rs,num)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setPrice(rs.getDouble(3));
			p.setQty(rs.getInt(4));
			return p;
		});
	}

	@Override
	public void addProduct(Product p) {
		
		jdbcTemplate.update("insert into product values(?,?,?,?)",new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice()});
	}

	@Override
	public void deleteProduct(int id) {
		jdbcTemplate.update("delete from product where pid=?",new Object[] {id});
		
	}

	@Override
	public Product getById(int id) {
		return jdbcTemplate.queryForObject("select * from product where pid=?",new Object[] {id},BeanPropertyRowMapper.newInstance(Product.class));
	}

	@Override
	public void updateProduct(Product p) {
		
		jdbcTemplate.update("update  product set pid=?,pname=?,qty=?,price=?",new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice()});
		
		
	}
	
	

}
