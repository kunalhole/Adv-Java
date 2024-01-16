package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class MyLogin {
	
	@GetMapping("/")
	public String showLoginForm() {
		return "login";
	}
	
	

}
