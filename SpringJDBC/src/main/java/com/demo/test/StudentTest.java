package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demo.model.Student;
import com.demo.service.StudentService;
import com.demo.service.StudentServiceImpl;

public class StudentTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		
		StudentService ss=ctx.getBean(StudentServiceImpl.class,"studentservice");
		
		Scanner sc=new Scanner(System.in);
		int choice=0;
		
		do {
			System.out.println("1. add new student\n 2. delete student\n 3. modify student");
			System.out.println("4. display all\n5.display by id\n6.exit");
			
			
			System.out.println("Enter a choice");
			choice=sc.nextInt();
			
			switch(choice) {
			   
			case 1:
				ss.insertStudent();
				break;
			case 2:
				ss.remove();
				break;
			case 3:
				ss.modifyStudent();
				break;
			case 4:
				List<Student> ls=ss.allStudent();
				ls.forEach(System.out::println);
				break;
			case 5:
				ss.getStudent();
				break;
			case 6:
				System.exit(0);
				break;
			
				
			}
			
		}while(choice!=6);
		
		
		
			
		
		
		
	}

}
