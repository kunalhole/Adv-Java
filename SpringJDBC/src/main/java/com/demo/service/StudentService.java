package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.model.Student;

public interface StudentService {
	
	

	public void insertStudent();
	public void remove();
	public void modifyStudent();
	
	public List<Student> allStudent();
	public void getStudent();
}
