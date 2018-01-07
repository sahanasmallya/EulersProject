package com.assessment.eulerproject.RomanNumerals;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.assessment.eulerproject.exceptions.EulerException;
import com.assessment.eulerproject.exceptions.PasscodeException;
import com.assessment.eulerproject.services.InputReaderService;
import com.assessment.eulerproject.services.RepositoryService;
import com.assessment.eulerproject.services.RomanNumeralService;
import com.assessment.eulerproject.services.impl.InputReaderServiceImpl;
import com.assessment.eulerproject.services.impl.RepositoryServiceImpl;
import com.assessment.eulerproject.services.impl.RomanNumeralsServiceImpl;

public class RomanNumerals implements RepositoryService,InputReaderService, RomanNumeralService {

	
	//Set of services to distribute load. This ensures loose coupling which is good.
	
	static RepositoryService repository = new RepositoryServiceImpl();
	static InputReaderService inputReader = new InputReaderServiceImpl();
	static RomanNumeralService romanImpl = new RomanNumeralsServiceImpl();
	 
	
	public static void main(String[] s) throws EulerException {
		
		RomanNumerals romanNumerals = new RomanNumerals();
		
		//Get a repository of conversions. The two maps below store the conversions from roman to decimal and vice versa.
		Map<String, Integer> romanToDecMap = romanNumerals.getRomanToDec();
		TreeMap<Integer, String> decToRomanMap = romanNumerals.getDecToRoman();
		
		// Read the input file. The interface can be implemented to read from any other source later.
		List<String> inputRomans;
		try {
			inputRomans = romanNumerals.readInput("Roman.txt");
			Integer charsSaved = 0;
			
			
			charsSaved = processTask(romanNumerals, romanToDecMap, decToRomanMap, inputRomans, charsSaved);
			
			System.out.println("The number of characters that were saved is "+charsSaved);
		} catch (EulerException e) {
			// Do something with the exception
			System.out.println(e.getMessage());
		}
		

	}

	private static Integer processTask(RomanNumerals romanNumerals, Map<String, Integer> romanToDecMap,
			TreeMap<Integer, String> decToRomanMap, List<String> inputRomans, Integer charsSaved)
			throws EulerException {
		for (String input : inputRomans) {
			
			Integer decimalNumber = romanNumerals.toDecimal(input, romanToDecMap);
			String roman = romanNumerals.toRoman(decimalNumber, decToRomanMap);
			
			charsSaved = charsSaved +(input.length() - roman.length()  );
		}
		return charsSaved;
	}

	@Override
	public Integer toDecimal(String input, Map<String, Integer> romansToDec) throws EulerException {
		return romanImpl.toDecimal(input, romansToDec);
	}

	@Override
	public String toRoman(Integer decimalNumber, TreeMap<Integer, String> decimalToRomans) throws EulerException {
		return romanImpl.toRoman(decimalNumber, decimalToRomans);
	}

	@Override
	public List<String> readInput(String path) throws EulerException {
		return inputReader.readInput(path);
	}

	@Override
	public Map<String, Integer> getRomanToDec() {
		return repository.getRomanToDec();
	}

	@Override
	public TreeMap<Integer, String> getDecToRoman() {
		return repository.getDecToRoman();
	}

	@Override
	public List<Character> getSubtractives() {
		return romanImpl.getSubtractives();
	}



	


}
