package com.assessment.eulerproject.services;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.assessment.eulerproject.exceptions.EulerException;

public interface RomanNumeralService {

	Integer toDecimal(String input, Map<String, Integer> romansToDec) throws EulerException;
	String toRoman(Integer decimalNumber, TreeMap<Integer, String> decimalToRomans) throws EulerException;
	List<Character> getSubtractives();
}
