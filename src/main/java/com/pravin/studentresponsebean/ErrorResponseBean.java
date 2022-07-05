package com.pravin.studentresponsebean;

import java.util.List;

import com.pravin.model.ErrorBean;

public class ErrorResponseBean {
	private String status;
	private List<ErrorBean> errors;

	public ErrorResponseBean(String status, List<ErrorBean> errors) {
		super();
		this.status = status;
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ErrorBean> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorBean> errors) {
		this.errors = errors;
	}

}
