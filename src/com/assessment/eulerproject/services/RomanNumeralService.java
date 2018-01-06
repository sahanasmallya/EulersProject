package com.assessment.eulerproject.services;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface RomanNumeralService {

	Integer toDecimal(String input, Map<String, Integer> romansToDec);
	String toRoman(Integer decimalNumber, TreeMap<Integer, String> decimalToRomans);
	List<Character> getSubtractives();
}
