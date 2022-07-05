package com.pravin.studentresponsebean;

public class StudentResponseBean {

	@Override
	public String toString() {
		return "StudentResponseBean [name=" + name + ", course=" + course + "]\n";
	}

	private String name;
	private String course;

	public String getName() {
		return name;
	}

	public StudentResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
