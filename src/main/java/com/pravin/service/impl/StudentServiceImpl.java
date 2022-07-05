package com.pravin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pravin.dao.StudentDao;
import com.pravin.model.Student;
import com.pravin.requestbean.StudentRequestBean;
import com.pravin.requestbean.StudentRequestBeanForId;
import com.pravin.requestbean.StudentRequestBeanForName;
import com.pravin.requestbean.StudentRequestBeanForUpdate;
import com.pravin.service.StudentService;
import com.pravin.studentresponsebean.StudentResponseBean;
import com.pravin.studentresponsebean.AddStudentResponse;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public AddStudentResponse addStudent(StudentRequestBean studentRequestBean) {

		// ObjectMapper mapper=new ObjectMapper();
		Student student = new Student();

		student.setStdName(studentRequestBean.getStdName());
		student.setStdCourse(studentRequestBean.getStdCourse());
		try {
			this.studentDao.save(student);
			return this.populateAddStudentResponse(student.getStdId(), "Success");

		} catch (Exception e) {

			return this.populateAddStudentResponse(null, "Faild To Add Record");
		}

	}

	private AddStudentResponse populateAddStudentResponse(Integer stdId, String string) {

		AddStudentResponse addStudentResponse = new AddStudentResponse();
		addStudentResponse.setMessage(string);
		addStudentResponse.setStatus(stdId);
		return addStudentResponse;
	}

	@Override
	public Object getStudent(StudentRequestBeanForId studentRequestBeanForId) {

		Student student;

		Optional<Student> student1 = this.studentDao.findById(studentRequestBeanForId.getStdId());
		if (student1.isPresent()) {
			student = student1.get();
			StudentResponseBean bean = new StudentResponseBean();
			this.populateStudentResponseBean(student, bean);
			return bean;
		} 
		else {
			AddStudentResponse addStudentResponse;
			addStudentResponse = this.populateAddStudentResponse(null, "Record Not Found");
			return addStudentResponse;
		}
	}

	public Object getAllStudents() {

		ArrayList<StudentResponseBean> studentList = new ArrayList<>();
		try {
			List<Student> students = this.studentDao.findAll();
			for (Student student : students) {
				StudentResponseBean bean = new StudentResponseBean();
				this.populateStudentResponseBean(student, bean);
				studentList.add(bean);
			}
			return studentList;
		} catch (Exception e) {

			AddStudentResponse addStudentResponse;
			addStudentResponse = this.populateAddStudentResponse(null, "Record Not Found");
			return addStudentResponse;
		}
	}

	private void populateStudentResponseBean(Student stud, StudentResponseBean bean) {
		bean.setCourse(stud.getStdCourse());
		bean.setName(stud.getStdName());
	}

	@Override
	public AddStudentResponse updateStudent(StudentRequestBeanForUpdate studentRequestBeanForUpdate) {

		Student student;

		Optional<Student> student1 = this.studentDao.findById(studentRequestBeanForUpdate.getStdId());
		if (student1.isPresent()) {
			student = student1.get();

			student.setStdName(studentRequestBeanForUpdate.getStdName());
			student.setStdCourse(studentRequestBeanForUpdate.getStdCourse());

			this.studentDao.save(student);

			return this.populateAddStudentResponse(student.getStdId(), "Update Success");
		} else
			return this.populateAddStudentResponse(null, "Record Not Found");
	}

	@Override
	public AddStudentResponse deleteStudent(StudentRequestBeanForId studentRequestBeanForId) {

		try {

			this.studentDao.deleteById(studentRequestBeanForId.getStdId());
			return this.populateAddStudentResponse(studentRequestBeanForId.getStdId(), "Delete Success");
		} catch (Exception e) {
			return this.populateAddStudentResponse(null, "Record Not Found");

		}
	}

	@Override
	public  ArrayList<StudentResponseBean> getStudentByName(StudentRequestBeanForName studentRequestBeanForName) {

		ArrayList<StudentResponseBean> studentList = new ArrayList<>();

		 List<Student> students = this.studentDao.findByStdName(studentRequestBeanForName.getStdName());
		for (Student student : students) {
			StudentResponseBean bean = new StudentResponseBean();
			this.populateStudentResponseBean(student, bean);
			studentList.add(bean);
		}
		return studentList;
	}

}
