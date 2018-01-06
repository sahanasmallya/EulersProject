package com.assessment.eulerproject.RomanNumerals;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumeralsServiceImpl implements RomansNumeralsService {

public String toRoman(Integer decimalNumber, TreeMap<Integer, String> decimalToRomans) {
		
		Iterator iterator =  decimalToRomans.descendingKeySet().iterator();
		StringBuffer romanString = new StringBuffer();
		while(iterator.hasNext()){
			Integer romanBase = (Integer)iterator.next();
			while(decimalNumber >= romanBase){
				int quotient =  decimalNumber / romanBase;
				for(int i=0;i<quotient;i++){
					romanString =  romanString.append(decimalToRomans.get(romanBase));
				}
				decimalNumber =  decimalNumber % romanBase;
			}
		}
		return romanString.toString();
	}

	public Integer toDecimal(String input, Map<String, Integer> romansToDec) {
		Integer decimal = 0;
		for (int i = 0; i < input.length(); i++){
			
			if(input.charAt(i)=='I' || input.charAt(i)=='X' || input.charAt(i)=='C'){
				if(i!=input.length()-1 && romansToDec.containsKey(""+input.charAt(i)+ input.charAt(i+1))){
					decimal = decimal + romansToDec.get(""+input.charAt(i)+ input.charAt(i+1));
					i++;
				}else{
					decimal = decimal + romansToDec.get(input.charAt(i) + "");
				}
			}else{
				decimal = decimal + romansToDec.get(input.charAt(i) + "");
			}
			
		}
		return decimal;
	}

	
}
