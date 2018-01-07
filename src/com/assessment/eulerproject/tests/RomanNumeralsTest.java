package com.assessment.eulerproject.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import com.assessment.eulerproject.RomanNumerals.RomanNumerals;
import com.assessment.eulerproject.constants.Message;
import com.assessment.eulerproject.exceptions.EulerException;

class RomanNumeralsTest {
	

	@Test // This test verifies that  repository holds the roman to decimal conversions information correctly
	void testRomansToDecSize() {
		RomanNumerals romanNumerals = new RomanNumerals();
		Map<String, Integer> decToRomanMap = romanNumerals.getRomanToDec();
		assertEquals(13, decToRomanMap.size());
	}
	
	@Test // This test verifies that  repository holds the decimal to roman conversions information correctly
	void testDecToRomansSize() {
		RomanNumerals romanNumerals = new RomanNumerals();
		TreeMap<Integer, String> decToRomanMap = romanNumerals.getDecToRoman();
		assertEquals(13, decToRomanMap.size());
	}
	

	//Uncomment the following to test the error scenario.
/*	@Test // This test verifies that a EulerException is thrown if the input file is not found
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
	
	
	@Test  // This test verifies that a EulerException is thrown if the repository is null. Repository holds the conversion from Roman to Decimal information.
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
	
	@Test  // This test verifies success scenario for conversion to decimal . Here the roman string is in its minified form
	void testEmptyList() throws EulerException {
		RomanNumerals romanNumerals = new RomanNumerals();
		try {
			assertTrue(15 ==romanNumerals.toDecimal("XV", romanNumerals.getRomanToDec()));
		} catch (EulerException e) {
			assertFalse(  true);
		}
	}
	
	
	@Test // This test verifies success scenario for conversion to decimal . Here the roman string is in its longer form
	void testRomanToDec() throws EulerException {
		RomanNumerals romanNumerals = new RomanNumerals();
		try {
			assertTrue(15 ==romanNumerals.toDecimal("XIIIII", romanNumerals.getRomanToDec()));
		} catch (EulerException e) {
			assertTrue(  e.getErrorMessage().equals(Message.ERROR));
		}
	}
	
	@Test // This test verifies success scenario for conversion to roman . 
	void testDecToRoman() throws EulerException {
		RomanNumerals romanNumerals = new RomanNumerals();
		try {
			assertEquals("XVI",romanNumerals.toRoman(16, romanNumerals.getDecToRoman()));
		} catch (EulerException e) {
			assertTrue(  e.getErrorMessage().equals(Message.ERROR));
		}
	}
	
	@Test // This test verifies success scenario for conversion to roman for a negative decimal  . 
	void testNegativeDecToRoman() throws EulerException {
		RomanNumerals romanNumerals = new RomanNumerals();
		try {
			assertEquals("-MMMMM",romanNumerals.toRoman(-5000, romanNumerals.getDecToRoman()));
		} catch (EulerException e) {
			assertTrue(  e.getErrorMessage().equals(Message.ERROR));
		}
	}
	
	@Test // This test verifies success scenario for conversion to roman for a decimal with  decimal point  . 
	void testSpecialDecToRoman() throws EulerException {
		RomanNumerals romanNumerals = new RomanNumerals();
		try {
			assertEquals("I",romanNumerals.toRoman((int) 1.234, romanNumerals.getDecToRoman()));
		} catch (EulerException e) {
			assertTrue(  e.getErrorMessage().equals(Message.ERROR));
		}
	}
	
	@Test // This test verifies  scenario for conversion to decimal for a invalid string  . 
	void testInvalidRomantoDec() throws EulerException {
		RomanNumerals romanNumerals = new RomanNumerals();
		try {
			romanNumerals.toDecimal("InvalidRomanNumber", romanNumerals.getRomanToDec());
			fail("Expected a EulerException");
		} catch (EulerException e) {
			assertTrue(  e.getErrorMessage().equals(Message.NOT_FOUND));
		}
	}
	
	
	@Test // This test verifies that the subtractives are available correctly . 
	void testSubtractives() throws EulerException {
		RomanNumerals romanNumerals = new RomanNumerals();
		assertEquals(3, romanNumerals.getSubtractives().size());
	}
	

}
