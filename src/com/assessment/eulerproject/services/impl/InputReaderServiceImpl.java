package com.assessment.eulerproject.services.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.assessment.eulerproject.constants.Message;
import com.assessment.eulerproject.exceptions.EulerException;
import com.assessment.eulerproject.services.InputReaderService;

public class InputReaderServiceImpl implements InputReaderService {

	public List<String> readInput(String path) {
		try {
			return readFromFile(new File(path));
		} catch (EulerException e) {
			System.out.println(e.getErrorMessage());
		}
		return null;
	}

	public List<String> readFromFile(File file) throws EulerException {

		File inputFile = file;
		BufferedReader br = null;
		List<String> inputRomanNumerals = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(inputFile));

			String input = "";
			while ((input = br.readLine()) != null) {
				inputRomanNumerals.add(input);
			}
			return inputRomanNumerals;
		} catch (FileNotFoundException e) {
			throw new EulerException(Message.INVALIDPATH);
		} catch (IOException e) {
			throw new EulerException(Message.ERROR);
		} finally {

			try {
				if (null != br)
					br.close();

			} catch (IOException e) {
				throw new EulerException(Message.ERROR);
			}

		}
	}

}
