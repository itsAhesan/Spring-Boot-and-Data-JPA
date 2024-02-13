package com.jony.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jony.spring_boot.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
