package com.demo.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.StudentDao;
import com.demo.model.Student;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao sd;
   
	Scanner sc=new Scanner(System.in);
	@Override
	public void insertStudent() {
		
		System.out.println("enter sid");
		int sid=sc.nextInt();
		System.out.println("enter sname");
		String sname=sc.next();
		System.out.println("enter age");
		int age=sc.nextInt();
		
		
		Student s=new Student(sid,sname,age);
		sd.insertStudent(s);
		
	
		
	}

	
	public void remove() {
		
		System.out.println("Enter a id");
		int id=sc.nextInt();
		
		sd.removeStudent(id);
		
	}


	@Override
	public void modifyStudent() {
		
		System.out.println("enter sid");
		int sid=sc.nextInt();
		System.out.println("enter sname");
		String sname=sc.next();
		System.out.println("enter age");
		int age=sc.nextInt();
		
		Student s=new Student(sid,sname,age);
		
		
		sd.updateStudent(s);
		
	}


	@Override
	public List<Student> allStudent() {
		return sd.displayStudent();
		
	}


	@Override
	public void getStudent() {
	    
		System.out.println("Enter a id");
		int id=sc.nextInt();
		
		sd.getStudent(id);
	}

}
