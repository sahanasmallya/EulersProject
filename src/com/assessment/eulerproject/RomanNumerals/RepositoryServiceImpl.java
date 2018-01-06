package com.assessment.eulerproject.RomanNumerals;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RepositoryServiceImpl implements RepositoryService {

	public Map<String, Integer> getRomanToDec() {
		Map<String, Integer> denominations = new HashMap<String, Integer>();
		fillDenominationsMap(denominations);
		return denominations;
	}

	private void fillDenominationsMap(Map<String, Integer> denominations) {
		if (denominations.isEmpty()) {
			denominations.put("I", 1);
			denominations.put("IV", 4);
			denominations.put("V", 5);
			denominations.put("IX", 9);
			denominations.put("X", 10);
			denominations.put("XL", 40);
			denominations.put("L", 50);
			denominations.put("XC", 90);
			denominations.put("C", 100);
			denominations.put("CD", 400);
			denominations.put("D", 500);
			denominations.put("CM", 900);
			denominations.put("M", 1000);
		}
	}

	public TreeMap<Integer, String> getDecToRoman() {

		TreeMap<Integer, String> denominations = new TreeMap<Integer, String>();
		if (denominations.isEmpty()) {
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
			
		}
		return denominations;
	}

}
