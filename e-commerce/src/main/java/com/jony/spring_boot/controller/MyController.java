package com.jony.spring_boot.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jony.spring_boot.model.Customer;
import com.jony.spring_boot.model.Item;
import com.jony.spring_boot.service.Dao;

@Controller
public class MyController {
	
	@Autowired 
	private Dao dao;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/reg")		//===============Registration=========
	public String reg() {	
		return "resp1";
	}
	
	@GetMapping("/regForm")		//===============Registration Form=========
	public String regForm(@ModelAttribute Customer cs) {
		dao.save(cs);
		
		return "resp2";
	}
	
	@GetMapping("/items")	//===============Item=========
	public String items() {	
		return "resp3";
	}
	
	@GetMapping("/itemForm")		//===============Item Form=========
	public String itemForm(@ModelAttribute Item itm) {
		dao.saveItm(itm);
		
		return "resp2";
	}
	
	@GetMapping("login")		//===============Login=========
	public String login() {
		return "resp4";
	}
	
	@GetMapping("loginForm")		//===============Login Form=========
	public String loginForm(@RequestParam String name, @RequestParam String pass, HttpServletRequest request , Model model ) {
		
		Customer list = dao.login(name,pass);
		System.out.println(list);
		
		
		 
		  
		  if(list!=null) {
		  
				/*
				 * Cookie cookie= new Cookie("name", list.getName());
				 * 
				 * System.out.println("Coooo "+cookie);
				 */		  
			 
			//  session.setAttribute("name", list.getName());
			  
		  HttpSession session = request.getSession(true);
		  session.setAttribute("name", list);
		  
		  
		  
		 List<Item> fetchItem = dao.fetchItem();
		 
		 model.addAttribute("item" , fetchItem);
		 model.addAttribute("msg" , list);
		  
		  
		  System.out.println("Login Success");
		  System.out.println(list.getName());
		  return "resp5";
		  
		  }else {
			  System.out.println("Login Failed"); 
		  return "resp7";
		  
				  }
		  
		
	}
	
	@GetMapping("/addCard/{id}")	// ====================Add to Card======================
	public String addCard(@PathVariable int id, HttpServletRequest request) {
		
		  HttpSession session = request.getSession(false);
		  Customer customer = (Customer) session.getAttribute("name");
		  System.out.println("Customer   ==="+customer);
		
		dao.addItem(id,customer);
		
		
		
		return "resp6";
	}
	
	@GetMapping("/card")		//=====================My Card=====================
	public ModelAndView card(HttpServletRequest request, Model model) {
		
		 HttpSession session = request.getSession(false);
		  Customer customer = (Customer) session.getAttribute("name");
		
		System.out.println("cus ===================== "+customer);
		model.addAttribute("user", customer);
		
		Customer fetchall = dao.fetchall(customer);
		List<Item> list = fetchall.getItem();
		
		
		System.out.println("list========== "+list);
		
		return new ModelAndView("resp8", "list" , list) ;
	}
	
	@GetMapping("/order")
	public String order(HttpServletRequest request, Model model ) {
		HttpSession session = request.getSession(false);
		Customer customer = (Customer) session.getAttribute("name");
		model.addAttribute("user", customer);
		Customer fetchall = dao.fetchall(customer);
		List<Item> list = fetchall.getItem();
		
		int price=0;
		for (Item item : list) {
			price +=item.getPrice();
		}
		System.out.println("Total Price==== "+price);
		model.addAttribute("price", price);
		
	
		model.addAttribute("list", list);
		
		return "resp9";
	}
	
	@GetMapping("/confirm")
	public String confirm(HttpServletRequest request ) {
		HttpSession session = request.getSession(false);
		
	
		
		return "resp10";
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request ) {
		HttpSession session = request.getSession(false);
		
	//	session.setMaxInactiveInterval(5);
		session.invalidate();
		
		return "redirect:/login";
	}
	
	
	

}
