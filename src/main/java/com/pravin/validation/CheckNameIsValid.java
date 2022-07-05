package com.pravin.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.pravin.validation.impl.CheckNameIsValidValidator;

@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(CheckNameIsValid.List.class)
@Constraint(validatedBy = CheckNameIsValidValidator.class)
public @interface CheckNameIsValid {
	
	String fieldName();
    String[] fieldValues();

    String message() default "{Name is invalid.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
    	CheckNameIsValid[] value();
    }	
	

}
