package com.assessment.eulerproject.exceptions;

public class PasscodeException extends Exception {

	String errorMessage;
	public PasscodeException(String error) {
		super();
		this.errorMessage = error;
	}
	public String getErrorMessage() {
		return this.errorMessage;
	}

}
