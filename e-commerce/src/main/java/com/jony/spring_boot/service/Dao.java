package com.jony.spring_boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jony.spring_boot.model.Customer;
import com.jony.spring_boot.model.Item;
import com.jony.spring_boot.repository.CustomerRepo;
import com.jony.spring_boot.repository.ItemRepo;

@Component
public class Dao {

	@Autowired
	private CustomerRepo cRepo;
	
	@Autowired
	private ItemRepo iRepo;
	
	public void save(Customer cs) {	//	=========Customer Save=======
		cRepo.save(cs);
		
	}

	public void saveItm(Item itm) {	//	=========Item Save=======
		iRepo.save(itm);
		
	}

		
	
	public Customer login(String name, String pass) {
		Customer findByName = cRepo.findByName(name,pass);
		System.out.println(findByName);
		
		
		
		return findByName;
		
		
		
	}

	public List<Item> fetchItem() {
		List<Item> findAll = iRepo.findAll();
		
		return findAll;
			
		
	}

	public void addItem(int id, Customer customer) {
		
		Item item = iRepo.findById(id).orElse(null);
		Customer customer2 = cRepo.findById(customer.getId()).orElse(null);
		
		
		
	//	customer2.setItem(customer2.getItem());
		
		
	/*
	 * List<Item> list = customer2.getItem(); list.add(item);
	 */
		
		customer2.getItem().add(item);
		
		
		cRepo.save(customer2);
		
		
		
		
	}

	public Customer fetchall(Customer customer) {
		Customer findById = cRepo.findById(customer.getId()).orElse(null);
		
		
		return findById;
		
	}
	
	
	
	

}
