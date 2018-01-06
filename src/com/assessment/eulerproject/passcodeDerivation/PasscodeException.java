package com.assessment.eulerproject.passcodeDerivation;

public class PasscodeException extends Exception {

	String errorMessage;
	public PasscodeException(String error) {
		super();
		this.errorMessage = error;
	}

}
