package com.demo.controller;
//kunal
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUser;
import com.demo.model.Product;
import com.demo.service.ProductService;
import com.demo.service.ProudctServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService ps;
	
	@GetMapping("/getProducts")
	public ModelAndView getProducts(HttpSession sess){
		MyUser u=(MyUser)sess.getAttribute("user");
		if(u!=null) {
			
			List<Product> plist=ps.getProducts();
			System.out.println(plist);
			return new ModelAndView("displayProudcts","plist",plist);
		}
		
		return new ModelAndView("redirect:/login/");
		
	}
	

	@GetMapping("/addproduct")
	public String displayaddform(HttpSession session) {
		MyUser u=(MyUser) session.getAttribute("user");
		if(u!=null) 
		   return "addProduct";
		return "redirect:/login/"; 
	}
	
	@PostMapping("/insertProduct")
	public ModelAndView insertProudct(@RequestParam ("id") int id,@RequestParam ("name") String name,@RequestParam("qty")int qty,@RequestParam("price")double price) {
		
		Product p=new Product(id,name,qty,price);
		ps.addProudct(p);
		
		return new ModelAndView("redirect:/product/getProducts");
		
		
		
		
		
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteProudct(@PathVariable int id) {
		
		
		ps.deleteProduct(id);
		
		return new ModelAndView("redirect:/product/getProducts");
		
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable int id) {
		Product p=ps.getById(id);
		return new ModelAndView("editProduct","p",p);
		
	}
	
	@PostMapping("/updateProduct")
	
	public ModelAndView updateProduct(@RequestParam ("id") int id,@RequestParam ("name") String name,@RequestParam("qty")int qty,@RequestParam("price")double price) {
		
		Product p=new Product(id,name,qty,price);
		ps.updateProduct(p);
		
		return new ModelAndView("redirect:/product/getProducts");
		
	}
	
	

}
