package com.pravin.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

public class MethodsForThrowExceptions {
	public void validateBean(Object studentRequestBeanForNameValidation, Validator validator) {

		Set<ConstraintViolation<Object>> constraintViolation = validator.validate(studentRequestBeanForNameValidation);
		if (!constraintViolation.isEmpty()) {
			throw new ConstraintViolationException(constraintViolation);
		}
	}

}
