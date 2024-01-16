package com.demo.model;

public class Student {
  
	private int sid;
	private String sname;
	private int age;
	
	
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Student() {
		super();
	}


	public Student(int sid, String sname,int age) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age=age;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}
	
	
	
}
