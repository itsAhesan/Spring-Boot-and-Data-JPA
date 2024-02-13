package com.jony.spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.servlet.ModelAndView;

import com.jony.spring_boot.model.Student;
import com.jony.spring_boot.service.Dao;

@Controller
public class MyController {
	
	@Autowired
	Dao dao;
	
	@GetMapping("/")
	public String m1() {
		
		return "index";
	}
	
	@GetMapping("/reg")
	public String reg(@ModelAttribute Student st) {
		System.out.println(st);
		dao.save(st);
		return "resp1";
	}
	
	
	@GetMapping("/view")
	public ModelAndView view() {
		List<Student> list = dao.view();
		
		return new ModelAndView("resp2","msg", list);
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Student edit = dao.edit(id);
		
		return new ModelAndView("resp3","edit1", edit);
	}
	@GetMapping(value = "/update")
	public String update(@ModelAttribute Student st) {
		System.out.println("UPDATE: "+st);
		
		dao.update(st);
		
		return "resp4";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		dao.delete(id);
		
		return "resp5";
	}
	
	public String delee(Model model) {
		
		model.addAttribute(null);
		
		return "resp5";
	}
	
	
	
	
	
}
