package com.pravin.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pravin.requestbean.StudentRequestBeanForName;
import com.pravin.service.StudentService;

@Component
public class Sheduler {
	
	@Autowired
	private StudentService studentService;
	 @Scheduled(cron ="12,21 38 16 * * *")
	 public void getData()
	 {
		 System.out.println(studentService.getStudentByName(new StudentRequestBeanForName("Pravin")));
	 }
}
