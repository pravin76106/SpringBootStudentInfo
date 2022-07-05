package com.pravin.requestbean;

import com.pravin.validation.CheckNameIsValid;

@CheckNameIsValid.List({ @CheckNameIsValid(

		fieldName = "stdName", fieldValues = { "Pravin", "Sai" }, message = "name is invalid") })
public class StudentRequestBeanForNameValidation {
  
	private String stdName;

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
}
