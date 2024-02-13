package com.jony.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jony.spring_boot.model.Customer;
import java.util.List;


public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	
	@Query("SELECT e FROM Customer e WHERE e.name = :name and e.pass= :pass ")
	Customer findByName(String name, String pass);


}
