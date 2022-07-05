package com.pravin.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{
	/*
	 * @Query("SELECT s FROM Student s ") public ArrayList<Student>
	 * findAllStudent();
	 */
	
	public List<Student> findByStdName(String stdName); 
   
}
