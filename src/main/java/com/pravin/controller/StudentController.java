package com.pravin.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pravin.requestbean.StudentRequestBean;
import com.pravin.requestbean.StudentRequestBeanForId;
import com.pravin.requestbean.StudentRequestBeanForName;
import com.pravin.requestbean.StudentRequestBeanForUpdate;
import com.pravin.service.StudentService;
import com.pravin.studentresponsebean.AddStudentResponse;
import com.pravin.utility.Constants;

@RestController
@Validated
@RequestMapping(value = Constants.STUDENT_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

	@Autowired
	private StudentService studentService;

	private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();

	@PostMapping(value = Constants.ADD_ENDPOINT)
	public ResponseEntity<String> addStudent(@Valid @RequestBody StudentRequestBean studentRequestBean) {

		AddStudentResponse addStudentResponse = this.studentService.addStudent(studentRequestBean);
		ResponseEntity<String> response;
		if (addStudentResponse.getMessage().equals("Success")) {
			response = new ResponseEntity<>(gson.toJson(addStudentResponse), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(gson.toJson(addStudentResponse), HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}

	@PostMapping(value = Constants.GET_ENDPOINT)
	public ResponseEntity<String> getStudent(@Valid @RequestBody StudentRequestBeanForId studentRequestBeanForId) {

		Object object = this.studentService.getStudent(studentRequestBeanForId);
		return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
	}

	@PostMapping(value = Constants.GETALL_ENDPOINT)
	public ResponseEntity<String> getStudents() {

		Object object = this.studentService.getAllStudents();
		return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);

	}

	@PostMapping(value = Constants.UPDATE_ENDPOINT)
	public ResponseEntity<String> updateStudent(
			@Valid @RequestBody StudentRequestBeanForUpdate studentRequestBeanForUpdate) {

		AddStudentResponse addStudentResponse = this.studentService.updateStudent(studentRequestBeanForUpdate);

		ResponseEntity<String> response;

		if (addStudentResponse.getMessage().equals("Update Success")) {
			response = new ResponseEntity<>(gson.toJson(addStudentResponse), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(gson.toJson(addStudentResponse), HttpStatus.NOT_MODIFIED);
		}
		return response;
	}

	@PostMapping(value = Constants.DELETE_ENDPOINT)
	public ResponseEntity<String> deleteStudent(@Valid @RequestBody StudentRequestBeanForId studentRequestBeanForId) {

		AddStudentResponse addStudentResponse = this.studentService.deleteStudent(studentRequestBeanForId);

		ResponseEntity<String> response;

		if (addStudentResponse.getMessage().equals("Delete Success")) {
			response = new ResponseEntity<>(gson.toJson(addStudentResponse), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(gson.toJson(addStudentResponse), HttpStatus.NOT_FOUND);
		}
		return response;

	}

	@PostMapping(value = Constants.GETBYNAME_ENDPOINT)
	public ResponseEntity<String> getStudentByName(
			@Valid @RequestBody StudentRequestBeanForName studentRequestBeanForName) {

		Object object = this.studentService.getStudentByName(studentRequestBeanForName);

		return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
	}

}
