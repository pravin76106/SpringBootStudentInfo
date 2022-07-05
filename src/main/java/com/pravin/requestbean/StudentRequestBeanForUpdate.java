package com.pravin.requestbean;

import com.pravin.validation.NotNullIfAnotherFieldHasValue;

import javax.validation.constraints.NotNull;

import com.pravin.validation.CheckNameIsValid;

@NotNullIfAnotherFieldHasValue.List({
		@NotNullIfAnotherFieldHasValue(fieldName = "stdId", dependFieldName = "stdName", message = "name can not be empty "),
		@NotNullIfAnotherFieldHasValue(fieldName = "stdName", dependFieldName = "stdCourse", message = "course can not be empty ")

})

@CheckNameIsValid.List({ @CheckNameIsValid(

		fieldName = "stdName", fieldValues = { "Pravin", "Sai" }, message = "name is invalid") })
public class StudentRequestBeanForUpdate {

	@NotNull(message = "Id can not be empty")
	private Integer stdId;

	private String stdName;
	private String stdCourse;

	public Integer getStdId() {
		return stdId;
	}

	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public StudentRequestBeanForUpdate() {
		super();

	}

	public String getStdCourse() {
		return stdCourse;
	}

	public void setStdCourse(String stdCourse) {
		this.stdCourse = stdCourse;
	}

}
