package com.assessment.eulerproject.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.assessment.eulerproject.constants.Message;
import com.assessment.eulerproject.exceptions.EulerException;
import com.assessment.eulerproject.services.RomanNumeralService;

public class RomanNumeralsServiceImpl implements RomanNumeralService {

	public String toRoman(Integer decimalNumber, TreeMap<Integer, String> decimalToRomans) throws EulerException {

		if(null == decimalToRomans || decimalToRomans.size()==0) throw new EulerException(Message.ERROR);
		
		
		// Iterating the map in descending order to get the maximum as the roman base.
		// For eg, 4390 will first have M as base which is the highest value
		
		Iterator<Integer> iterator = decimalToRomans.descendingKeySet().iterator();
		StringBuffer romanString = new StringBuffer();
		if(decimalNumber<0) {
			romanString.append("-");
			decimalNumber = Math.abs(decimalNumber);
		}
		while (iterator.hasNext()) {
			Integer romanBase = (Integer) iterator.next();
			while (decimalNumber >= romanBase) {
				int quotient = decimalNumber / romanBase;
				for (int i = 0; i < quotient; i++) {
					romanString = romanString.append(decimalToRomans.get(romanBase));
				}
				decimalNumber = decimalNumber % romanBase;
			}
		}
		return romanString.toString();
	}

	public Integer toDecimal(String input, Map<String, Integer> romansToDec) throws EulerException {
		Integer decimal = 0;
		if(null == romansToDec || romansToDec.size()==0) throw new EulerException(Message.ERROR);
		List<Character> subtractives = getSubtractives(); //  I, X, and C : REference https://projecteuler.net/about=roman_numerals
			

		for (int i = 0; i < input.length(); i++) {
			Character character = input.charAt(i);
			
			
			//Converting to string to search in the romansToDec Map.
			String strCharacter = character+"";
			
			Boolean isLastCharacter = (i==input.length()-1);
			
			
			if (subtractives.contains(character) && !isLastCharacter) {
				Character nextCharacter = input.charAt(i + 1);
				String keyToSearch = strCharacter + nextCharacter;
				
				if (romansToDec.containsKey(keyToSearch)) {
					decimal = decimal + romansToDec.get(keyToSearch);
					i++;
				}
				else {
					if(null == romansToDec.get(strCharacter))throw new EulerException(Message.NOT_FOUND);
					decimal = decimal + romansToDec.get(strCharacter);
				}
			} else {
				if(null == romansToDec.get(strCharacter))throw new EulerException(Message.NOT_FOUND);
				decimal = decimal + romansToDec.get(strCharacter);
			}
			
		}

		return decimal;
	}

	@Override
	public List<Character> getSubtractives() {
		List<Character> subtractives = new ArrayList<Character>();
		subtractives.add('I');
		subtractives.add('X');
		subtractives.add('C');
		return subtractives;
	}



}
