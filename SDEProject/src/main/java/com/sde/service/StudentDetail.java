package com.sde.service;

import java.util.List;

import com.sde.entity.Student;

public interface StudentDetail {
	    
	    public List<Student> search(String department, String country);

	    public Student findById(int theId);
		
	    public void save(Student thestudent);
		
		public void deleteById(int theId);
		
		public List<Student> findAll();
}
