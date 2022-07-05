package com.pravin.studentresponsebean;

public class AddStudentResponse {
	
	private Integer status;
	private String message;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public AddStudentResponse(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public AddStudentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
