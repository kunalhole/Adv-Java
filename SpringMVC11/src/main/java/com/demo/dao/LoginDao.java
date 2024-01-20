package com.demo.dao;

import org.springframework.stereotype.Repository;

import com.demo.model.MyUser;


public interface LoginDao {

	public MyUser validate(String name,String pass);
}
