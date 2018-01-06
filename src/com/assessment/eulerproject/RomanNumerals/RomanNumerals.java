package com.assessment.eulerproject.RomanNumerals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumerals implements RepositoryService,InputReaderService, RomansNumeralsService {

	
	static RepositoryServiceImpl repository = new RepositoryServiceImpl();
	static InputReaderServiceImpl inputReader = new InputReaderServiceImpl();
	static RomanNumeralsServiceImpl romanImpl = new RomanNumeralsServiceImpl();
	 
	
	public static void main(String[] s) {
		
		RomanNumerals romanNumerals = new RomanNumerals();
		
		//Get a repository of conversions. The two maps below store the conversions from roman to decimal and vice versa.
		Map<String, Integer> romanToDecMap = romanNumerals.getRomanToDec();
		TreeMap<Integer, String> decToRomanMap = romanNumerals.getDecToRoman();
		
		List<String> inputRomans = romanNumerals.readInput("Roman.txt");
		Integer charsSaved = 0;
		
		
		for (String input : inputRomans) {
			
			Integer decimalNumber = romanNumerals.toDecimal(input, romanToDecMap);
			String roman = romanNumerals.toRoman(decimalNumber, decToRomanMap);
			
			charsSaved = charsSaved +(input.length() - roman.length()  );
		}
		
		System.out.println("The number of characters that were saved is "+charsSaved);

	}

	@Override
	public Integer toDecimal(String input, Map<String, Integer> romansToDec) {
		return romanImpl.toDecimal(input, romansToDec);
	}

	@Override
	public String toRoman(Integer decimalNumber, TreeMap<Integer, String> decimalToRomans) {
		return romanImpl.toRoman(decimalNumber, decimalToRomans);
	}

	@Override
	public List<String> readInput(String path) {
		return inputReader.readFromFile(new File(path));
	}

	@Override
	public Map<String, Integer> getRomanToDec() {
		return repository.getRomanToDec();
	}

	@Override
	public TreeMap<Integer, String> getDecToRoman() {
		return repository.getDecToRoman();
	}



	


}
