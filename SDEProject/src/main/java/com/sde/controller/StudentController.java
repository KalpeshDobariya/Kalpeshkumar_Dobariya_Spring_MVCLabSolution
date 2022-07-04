package com.sde.controller;

import java.util.List;

import com.sde.entity.Student;
import com.sde.service.StudentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/student")
public class StudentController {
	
	@Autowired
	private StudentDetail studentDetail;
	
	// to see the list of "student"; 
	@RequestMapping ("/list")
	public String listStudents(Model theModel) {
		System.out.println("request received");
		List<Student> theStudents = studentDetail.findAll();
		theModel.addAttribute("Students",theStudents);
		return "list-Students";	}
	
	@RequestMapping ("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student theStudent= new Student();
		theModel.addAttribute("Students",theStudent);
		return "Students-form"; }
		
	
	@RequestMapping("/showFormForUpdate") 
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) { 	
	    Student theStudent = studentDetail.findById(theId); 
	    theModel.addAttribute("Student", theStudent); 
	    return "Students-form"; }
	
	    
	// send over to our form return "Student-form"; 
	@PostMapping("/save") 
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name, 
		@RequestParam("department") String department, 
		@RequestParam("country") String country) {
				
		System. out.println(id); 
		Student theStudent;
		if (id != 0) {
			theStudent = studentDetail.findById(id); 
			theStudent.setName(name);  
			theStudent.setDepartment(department); 
			theStudent.setCountry(country); }
		else 
			theStudent = new Student(name,department,country); 
		    // save the student 
		    studentDetail.save(theStudent); 
		    // use a redirect to prevent duplicate submissions 
		    return  "redirect:/student/list"; }
		

		
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
			//delete the student
			studentDetail.deleteById(theId);
			//redirect to student/list
			return  "redirect:/student/list";}
		

}
