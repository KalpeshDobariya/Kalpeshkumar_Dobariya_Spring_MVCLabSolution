package com.sde.service;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.sde.entity.Student;

@Repository
public class StudentDetailImple implements StudentDetail{
	
		private SessionFactory sessionFactory;

		private Session session;

		@Autowired
		StudentDetailImple(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
			try {
				session = sessionFactory.getCurrentSession();
			}
			catch (HibernateException e){
				session = sessionFactory.openSession();
			}
		}
		
		
		
		//Print All Record
		 @Transactional
		 public List<Student> findAll() {
			Transaction tx = session.beginTransaction();
			List<Student> students = session.createQuery("from Student").list();
			tx.commit();
			return students; }
		
		 
	    //Find by ID
		 @Transactional
		 public Student findById(int id) {
		    Student student = new Student();
			Transaction tx = session.beginTransaction();
			student = session.get(Student.class, id);
			tx.commit();
			return student;}
		 
		
		//Search Record
		 @Transactional
		 public List<Student> search(String department, String country) {
			return null;}
		
		
		
		//Save or Insert Record
		 @Transactional
		 public void save(Student theStudent) {
			 Transaction tx = session.beginTransaction(); 
			 session.saveOrUpdate (theStudent);
			 tx.commit();}

		
		//Delete Record 
		 @Transactional
		 public void deleteById(int id) {
		    Transaction tx = session.beginTransaction(); 
		    Student student = session.get(Student.class, id); 
		    if (student != null) 
		        session.delete(student);
		    tx.commit();}
		

	}
