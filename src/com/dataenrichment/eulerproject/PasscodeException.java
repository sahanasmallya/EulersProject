package com.dataenrichment.eulerproject;

public class PasscodeException extends Exception {

	String errorMessage;
	public PasscodeException(String error) {
		super();
		this.errorMessage = error;
	}

}
