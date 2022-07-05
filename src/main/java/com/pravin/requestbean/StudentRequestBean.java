package com.pravin.requestbean;

import javax.validation.constraints.NotEmpty;

public class StudentRequestBean {
	
	
	@NotEmpty(message = "Name can not be empty")
	private String stdName;
	
	
	@NotEmpty(message = "Course can not be empty")
    private String stdCourse;

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdCourse() {
		return stdCourse;
	}

	public void setStdCourse(String stdCourse) {
		this.stdCourse = stdCourse;
	}

	public StudentRequestBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
