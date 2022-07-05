package com.pravin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.requestbean.StudentRequestBeanForUpdate;
import com.pravin.utility.Constants;

@RestController
@RequestMapping(value = Constants.STUDENT_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class GetPropertyByValueAnnotation {
	
	@Value("${spring.datasource.url}")
	private String url;
	@PostMapping(value = Constants.GET_PROPERTY_BY_VALUE)
	public ResponseEntity<String> isValidName(@RequestBody StudentRequestBeanForUpdate studentRequestBeanForUpdate) {
	
		return new ResponseEntity<>(url, HttpStatus.OK);
	}

}
