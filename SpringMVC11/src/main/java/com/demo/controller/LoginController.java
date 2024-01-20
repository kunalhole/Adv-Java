package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUser;
import com.demo.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	 LoginService ls;
	 
	@GetMapping("/")
	public String showLogin() {
		return "login";
	}
   
	@PostMapping("/validate")
	public ModelAndView validate(@RequestParam ("name")String name,@RequestParam ("pass")String pass,HttpSession sess) {
		MyUser u=ls.validate(name, pass);
		if(u!=null) {
		  sess.setAttribute("user", u);
		  return new ModelAndView("redirect:/product/getProducts");
		}
		
		return new ModelAndView("success","msg","unsuccessful login");
	}
	
	@GetMapping("/addproudct")
	
	public String addProudct(HttpSession sess) {
		MyUser u=(MyUser) sess.getAttribute("user");
		if(u!=null) {
			return "addProudct";
		}
		return "login";
	}
}
