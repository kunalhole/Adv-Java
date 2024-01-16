package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
     
	@Autowired
	private JdbcTemplate template;
	public void insertStudent(Student s) {
		
		String query="insert into stud values(?,?,?)";
		template.update(query,s.getSid(),s.getSname(),s.getAge());
		System.out.println("Student inserted successfully");
	}
	@Override
	public void removeStudent(int id) {
		
		String query="delete from stud where sid=?";
		template.update(query,id);
		System.out.println("Student deleted successfully");
		
		
	}
	@Override
	public void updateStudent(Student s) {
		String query="update stud set sid=?,name=?,age=? where sid=? ";
		
		template.update(query,s.getSid(),s.getSname(),s.getAge(),s.getSid());
		
		System.out.println("Student Updated successfully");
		
	}
	@Override
	public List<Student> displayStudent() {
		List<Student> lst=template.query("select * from stud",(rs,num)->{
			Student s=new Student();
			s.setSid(rs.getInt(1));
			s.setSname(rs.getString(2));
			s.setAge(rs.getInt(3));
			
			return s;
		});
		return lst;
	}
	@Override
	public void getStudent(int id) {
		String query="select * from stud where sid=?";
		
		
		Student s= template.queryForObject("select * from stud where sid=?",new Object[] {id},BeanPropertyRowMapper.newInstance(Student.class));		
			
		System.out.println(s);
		
		
	}

}
