package com.dataenrichment.eulerproject;

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

public class RomanNumeralsOptimization {

	public static void main(String[] s) {
		Integer count = -1;
		RomanNumeralsOptimization romanNumerals = new RomanNumeralsOptimization();
		Map<String, Integer> denominations = romanNumerals.getDenominations();
		TreeMap<Integer, String> minimalDenominations = romanNumerals.getMinimalDenominations();
		List<String> inputRomanNumerals = romanNumerals.getInputFromFile(new File("Roman.txt"));
		Integer savedCharsCount = 0;
		for (String input : inputRomanNumerals) {
			Integer decimalNumber = romanNumerals.convertToDecimal(input, denominations);
			System.out.println(decimalNumber);
			String decimalToRoman = romanNumerals.getMinimalRomanNumber(decimalNumber, minimalDenominations);
			
			savedCharsCount = savedCharsCount +(input.length() - decimalToRoman.length()  );
		}
		
		System.out.println("The number of characters that were saved is "+savedCharsCount);

	}

	public TreeMap<Integer, String> getMinimalDenominations() {

		TreeMap<Integer, String> denominations = new TreeMap<Integer, String>();
		denominations.put(1, "I");
		denominations.put(4, "IV");
		denominations.put(5, "V");
		denominations.put(9, "IX");
		denominations.put(10, "X");
		denominations.put(40, "XL");
		denominations.put(50, "L");
		denominations.put(90, "XC");
		denominations.put(100, "C");
		denominations.put(400, "CD");
		denominations.put(500, "D");
		denominations.put(900, "CM");
		denominations.put(1000, "M");
		return denominations;
	}


	public String getMinimalRomanNumber(Integer decimalNumber, TreeMap<Integer, String> minimalDenominations) {
		
		Iterator iterator =  minimalDenominations.descendingKeySet().iterator();
		StringBuffer romanString = new StringBuffer();
		while(iterator.hasNext()){
			Integer romanBase = (Integer)iterator.next();
			while(decimalNumber >= romanBase){
				int quotient =  decimalNumber / romanBase;
				for(int i=0;i<quotient;i++){
					romanString =  romanString.append(minimalDenominations.get(romanBase));
				}
				decimalNumber =  decimalNumber % romanBase;
			}
		}
		return romanString.toString();
	}

	public Integer convertToDecimal(String input, Map<String, Integer> denominations) {
		Integer decimal = 0;
		for (int i = 0; i < input.length(); i++){
			
			if(input.charAt(i)=='I' || input.charAt(i)=='X' || input.charAt(i)=='C'){
				if(i!=input.length()-1 && denominations.containsKey(""+input.charAt(i)+ input.charAt(i+1))){
					decimal = decimal + denominations.get(""+input.charAt(i)+ input.charAt(i+1));
					i++;
				}else{
					decimal = decimal + denominations.get(input.charAt(i) + "");
				}
			}else{
				decimal = decimal + denominations.get(input.charAt(i) + "");
			}
			
		}
		return decimal;
	}

	public List<String> getInputFromFile(File file) {

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

	public Map<String, Integer> getDenominations() {
		Map<String, Integer> denominations = new HashMap<String, Integer>();
		fillDenominationsMap(denominations);
		return denominations;
	}

	private void fillDenominationsMap(Map<String, Integer> denominations) {
		if (denominations.isEmpty()) {
			denominations.put( "I",1);
			denominations.put( "IV",4);
			denominations.put("V",5);
			denominations.put( "IX",9);
			denominations.put( "X",10);
			denominations.put( "XL",40);
			denominations.put( "L",50);
			denominations.put( "XC",90);
			denominations.put( "C",100);
			denominations.put( "CD",400);
			denominations.put( "D",500);
			denominations.put("CM",900);
			denominations.put("M",1000);
		}
	}

}
