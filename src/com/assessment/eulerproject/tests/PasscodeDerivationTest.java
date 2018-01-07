package com.assessment.eulerproject.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.assessment.eulerproject.exceptions.EulerException;
import com.assessment.eulerproject.passcodeDerivation.PasscodeDerivation;

class PasscodeDerivationTest {
	
	List<String> keyLogs = new ArrayList<String>();
	List<Character> list = new ArrayList<Character>();
	@Before
	 void  setUp() {
		
		keyLogs.add((String)"725");
		keyLogs.add((String)"459");
		keyLogs.add((String)"849");
		keyLogs.add((String)"785");
		keyLogs.add((String)"245");
		keyLogs.add((String)"789");
		keyLogs.add((String)"829");
	}
	void setUpPassCodeChars () {
		list.add('7');
		list.add('8');
		
	}
	

	@Test // This test verifies that we have all the characters(integers) that are the part of the key code
	void testPasscodeDerivation() {
		setUp();
		PasscodeDerivation passcodeDerivation = new PasscodeDerivation();
		List<Character> passcodeChars = new ArrayList<Character>();
		try {
			passcodeDerivation.derivePasscodeChars(passcodeDerivation, keyLogs, passcodeChars);
			assertEquals(6, passcodeChars.size());
		} catch (EulerException e) {
			assertFalse(true);
		}
		
	}
	@Test // This test verifies that we have all the characters(integers) that are the part of the key code
	void testInvalidPasscodeDerivation() {
		setUp();
		PasscodeDerivation passcodeDerivation = new PasscodeDerivation();
		List<Character> passcodeChars = new ArrayList<Character>();
		try {
			passcodeDerivation.derivePasscodeChars(passcodeDerivation, null, passcodeChars);
			fail("Expected Euler Exception");
		} catch (EulerException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	void testSwapPositionsOfChars() {
		PasscodeDerivation passcodeDerivation = new PasscodeDerivation();
		try {
			setUpPassCodeChars();
			passcodeDerivation.swapPositionsOfChars(list, 0, 1);
			assertTrue('8'== list.get(0));
			assertTrue('7'== list.get(1));
		} catch (EulerException e) {
			assertFalse(true);
		}
	}
	
	
}