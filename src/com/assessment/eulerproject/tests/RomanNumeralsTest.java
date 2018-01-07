package com.assessment.eulerproject.tests;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import com.assessment.eulerproject.RomanNumerals.RomanNumerals;
import com.assessment.eulerproject.constants.Message;
import com.assessment.eulerproject.exceptions.EulerException;

class RomanNumeralsTest {
	
	@Test
	void testRomansToDecSize() {
		RomanNumerals romanNumerals = new RomanNumerals();
		Map<String, Integer> decToRomanMap = romanNumerals.getRomanToDec();
		assertEquals(13, decToRomanMap.size());
	}
	
	@Test
	void testDecToRomansSize() {
		RomanNumerals romanNumerals = new RomanNumerals();
		TreeMap<Integer, String> decToRomanMap = romanNumerals.getDecToRoman();
		assertEquals(13, decToRomanMap.size());
	}
	
	
	@Test
	void testUnavailableFile() {
		RomanNumerals romanNumerals = new RomanNumerals();
		String fileName = "NotAvailable.txt";
		try {
			List<String> list = romanNumerals.readInput(fileName);
			assertNull(list);
		} catch (EulerException e) {
			assertTrue(  e.getErrorMessage().equals(Message.INVALIDPATH));
		}
		
	}
	

}
