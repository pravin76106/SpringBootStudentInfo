package com.pravin.validation.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.pravin.validation.CheckNameIsValid;

public class CheckNameIsValidValidator implements ConstraintValidator<CheckNameIsValid, Object> {

	private String fieldName;
	private String[] fieldValues;

	@Override
	public void initialize(CheckNameIsValid annotation) {
		fieldName = annotation.fieldName();
		fieldValues = annotation.fieldValues();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext ctx) {

		if (value == null) {
			return true;
		}
		try {
			String fieldValue = BeanUtils.getProperty(value, fieldName);

			if (Arrays.asList(fieldValues).contains(fieldValue)) {
				return true;
			}
			return false;
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
	}

}
