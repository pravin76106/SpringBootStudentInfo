package com.pravin.service;

import com.pravin.requestbean.StudentRequestBean;
import com.pravin.requestbean.StudentRequestBeanForId;
import com.pravin.requestbean.StudentRequestBeanForName;
import com.pravin.requestbean.StudentRequestBeanForUpdate;
import com.pravin.studentresponsebean.AddStudentResponse;

public interface StudentService {

	public abstract AddStudentResponse addStudent(StudentRequestBean studentRequestBean);

	public abstract Object getStudent(StudentRequestBeanForId studentRequestBeanForId);

	public abstract AddStudentResponse updateStudent(StudentRequestBeanForUpdate studentRequestBeanForUpdate);

	public abstract AddStudentResponse deleteStudent(StudentRequestBeanForId studentRequestBeanForId);

	public abstract Object getAllStudents();

	public abstract Object getStudentByName(StudentRequestBeanForName studentRequestBeanForName); 

}
