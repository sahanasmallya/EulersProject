package com.assessment.eulerproject.services.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.assessment.eulerproject.services.InputReaderService;

public class InputReaderServiceImpl implements InputReaderService {

	public List<String> readInput(String path) {
		return readFromFile(new File (path));
	}
	
	
	
	public List<String> readFromFile(File file) {

		File inputFile = file;
		List<String> inputRomanNumerals = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));

			String input = "";
			while ((input = br.readLine()) != null) {
				inputRomanNumerals.add(input);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return inputRomanNumerals;
	}

}
