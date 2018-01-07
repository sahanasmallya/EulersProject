package com.assessment.eulerproject.tests;

import static org.junit.Assert.assertFalse;
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
	

	//Uncomment the following to test the error scenario.
/*	@Test
	void testUnavailableFile() {
		RomanNumerals romanNumerals = new RomanNumerals();
		String fileName = "NotAvailable.txt";
		try {
			List<String> list = romanNumerals.readInput(fileName);
			assertNull(list);
		} catch (EulerException e) {
			assertTrue(  e.getErrorMessage().equals(Message.INVALIDPATH));
		}
		
	}*/
	
	
	@Test 
	void testNullRepository() throws EulerException {
		RomanNumerals romanNumerals = new RomanNumerals();
		try {
			//Map is null here.
			romanNumerals.toDecimal("XV", null);
			assertFalse(true);
		} catch (EulerException e) {
			assertTrue(  e.getErrorMessage().equals(Message.ERROR));
		}
	}
	
	@Test 
	void testEmptyList() throws EulerException {
		RomanNumerals romanNumerals = new RomanNumerals();
		try {
			assertTrue(15 ==romanNumerals.toDecimal("XV", romanNumerals.getRomanToDec()));
		} catch (EulerException e) {
			assertTrue(  e.getErrorMessage().equals(Message.ERROR));
		}
	}
	
	
	@Test 
	void testRomanToDec() throws EulerException {
		RomanNumerals romanNumerals = new RomanNumerals();
		try {
			assertTrue(15 ==romanNumerals.toDecimal("XIIIII", romanNumerals.getRomanToDec()));
		} catch (EulerException e) {
			assertTrue(  e.getErrorMessage().equals(Message.ERROR));
		}
	}
	
	@Test 
	void testDecToRoman() throws EulerException {
		RomanNumerals romanNumerals = new RomanNumerals();
		try {
			assertEquals("XV",romanNumerals.toRoman(15, romanNumerals.getDecToRoman()));
		} catch (EulerException e) {
			assertTrue(  e.getErrorMessage().equals(Message.ERROR));
		}
	}
	@Test 
	void testSubtractives() throws EulerException {
		RomanNumerals romanNumerals = new RomanNumerals();
		assertEquals(3, romanNumerals.getSubtractives().size());
	}
	

}
