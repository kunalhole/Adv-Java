package com.demo.dao;

import java.util.List;

import com.demo.model.Student;


public interface StudentDao {

	public void insertStudent(Student s);
	public void removeStudent(int id);
	public void updateStudent(Student s);
	
	public List<Student> displayStudent();
	public void getStudent(int id);
}
