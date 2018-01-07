package com.assessment.eulerproject.exceptions;

public class EulerException extends Exception {

	String errorMessage;
	public EulerException(String error) {
		super();
		this.errorMessage = error;
	}
	public String getErrorMessage() {
		return this.errorMessage;
	}

}
