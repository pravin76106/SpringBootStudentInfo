package com.pravin.requestbean;

import javax.validation.constraints.NotNull;

public class StudentRequestBeanForId {
	
	@NotNull(message = "Student Id can not be empty")
	private Integer stdId;

	
	public Integer getStdId() {
		return stdId;
	}
   
	
	public StudentRequestBeanForId(Integer stdId) {
		super();
		this.stdId = stdId;
	}


	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}

	public StudentRequestBeanForId() {
		super();
	}

	

}
