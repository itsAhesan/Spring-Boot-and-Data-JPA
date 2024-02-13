package com.jony.spring_boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jony.spring_boot.model.Student;
import com.jony.spring_boot.repository.StudentRepo;

@Component
public class Dao {
	
	@Autowired
	private StudentRepo repo;

	public void save(Student st) {    //======SAVE=======
		repo.save(st);
		
	}

	public List<Student> view() {  //========READ========
		
		List<Student> findAll = repo.findAll();
		
		return findAll;
		
	}

	public Student edit(int id) {	//==========EDIT========
		Student st = repo.findById(id).orElse(null);
		
		return st;
		
		
	}

	public void update(Student st) {	//========Update=====
		Student update = repo.findById(st.getId()).orElse(null);
		
		update.setName(st.getName());
		update.setPass(st.getPass());
		update.setAge(st.getAge());
		update.setAddress(st.getAddress());
		
		repo.save(update);
		
		
	}

	public void delete(int id) {	//======DELETE======
		repo.deleteById(id);
		
		
	}
	
	
	

}
