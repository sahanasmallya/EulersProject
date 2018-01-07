package com.assessment.eulerproject.services;

import java.util.List;

import com.assessment.eulerproject.exceptions.PasscodeException;

public interface InputReaderService {

	// This method reads the input. The parameter must be the path. In this project,
	// the path is a filename.
	// This interface can be implemented to read from Console Input by using the
	// path parameter as an instruction. For eg, we can iomplement a class that will
	// read from Console by sending the value of path as "ReadFromConsole"
	List<String> readInput(String path) throws PasscodeException;
}
