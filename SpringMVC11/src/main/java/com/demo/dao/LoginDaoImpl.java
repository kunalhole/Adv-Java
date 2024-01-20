package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.MyUser;
@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public MyUser validate(String name, String pass) {
		
		String query="select * from stud where user_name=? and password=?";
		return jdbcTemplate.queryForObject(query, new Object[] {name,pass}, BeanPropertyRowMapper.newInstance(MyUser.class));
		
		
		
	}

}
