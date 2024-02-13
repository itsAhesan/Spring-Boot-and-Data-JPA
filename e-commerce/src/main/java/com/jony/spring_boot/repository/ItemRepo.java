package com.jony.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jony.spring_boot.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer>{

}
