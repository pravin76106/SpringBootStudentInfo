package com.pravin.requestbean;

import javax.validation.constraints.NotEmpty;

public class StudentRequestBeanForName {
	
	@NotEmpty(message="student name can not be null")
	private String stdName;

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	
	public StudentRequestBeanForName(String stdName)
	{
		this.stdName=stdName;
	}

}
