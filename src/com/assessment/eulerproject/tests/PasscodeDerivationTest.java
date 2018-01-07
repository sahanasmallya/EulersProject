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

class PasscodeDerivationTest {
	

	@Test // This test verifies that  repository holds the roman to decimal conversions information correctly
	void testRomansToDecSize() {
		RomanNumerals romanNumerals = new RomanNumerals();
		Map<String, Integer> decToRomanMap = romanNumerals.getRomanToDec();
		assertEquals(13, decToRomanMap.size());
	}
	
}