package com.pravin.controller;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.exception.MethodsForThrowExceptions;
import com.pravin.requestbean.StudentRequestBeanForNameValidation;
import com.pravin.utility.Constants;

@RestController
@RequestMapping(value = Constants.VALIDATION, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class NameValidation {
   
	@Autowired
	private Validator validator;
	
	@PostMapping(value = Constants.NAME_VALIDATION)
	public ResponseEntity<String> isValidName(@RequestBody StudentRequestBeanForNameValidation studentRequestBeanForNameValidation) {
		MethodsForThrowExceptions methodsForThrowExceptions = new MethodsForThrowExceptions();

		methodsForThrowExceptions.validateBean(studentRequestBeanForNameValidation,validator);
		return new ResponseEntity<>("Valid", HttpStatus.OK);
	}

}
