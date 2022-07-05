package com.pravin.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pravin.model.ErrorBean;
import com.pravin.model.ErrorCode;
import com.pravin.studentresponsebean.ErrorResponseBean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionAdvisor {
	private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> methodArgumentNotValidException(@RequestBody MethodArgumentNotValidException ex) {
		List<ObjectError> fieldErrors = ex.getBindingResult().getAllErrors();
		return new ResponseEntity<>(gson.toJson(processFieldErrors(fieldErrors)), HttpStatus.BAD_REQUEST);
	}

	private ErrorResponseBean processFieldErrors(List<ObjectError> fieldErrors) {
		List<ErrorBean> errorList = new ArrayList<>();
		for (ObjectError fieldError : fieldErrors) {
			Object[] arguments = fieldError.getArguments();
			if (arguments != null) {
				boolean found =false; 
				for (Object arg : arguments) {
					if (arg instanceof ErrorCode) {
						System.out.println("My name is Error Code");
						ErrorCode errCode = (ErrorCode) arg;
						errorList.add(new ErrorBean(errCode.getErrorMessage()));
						found = true;
						break;
					}
				}
				if (!found) {
					errorList.add(new ErrorBean(fieldError.getDefaultMessage()));
				}
			}
		}
		return new ErrorResponseBean("error", errorList);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> constraintViolationException(@RequestBody ConstraintViolationException ex) {
		Set<ConstraintViolation<?>> fieldVioletions = ex.getConstraintViolations();
		return new ResponseEntity<>(gson.toJson(processVioletions(fieldVioletions)), HttpStatus.BAD_REQUEST);
	}
	
	private ErrorResponseBean processVioletions(Set<ConstraintViolation<?>> fieldVioletions) {
		List<ErrorBean> errorList = new ArrayList<>();
		for (ConstraintViolation<?> fieldVioletion : fieldVioletions) {
			String message = fieldVioletion.getMessage();
			if (message != null) {
				errorList.add(new ErrorBean(message));
			}
		}
		return new ErrorResponseBean("error", errorList);
	}

}
