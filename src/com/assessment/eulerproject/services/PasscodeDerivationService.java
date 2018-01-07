package com.assessment.eulerproject.services;

import java.util.List;

import com.assessment.eulerproject.exceptions.EulerException;
import com.assessment.eulerproject.passcodeDerivation.PasscodeDerivation;

public interface PasscodeDerivationService {

	void addPasscodeChars(List<Character> passcodeChars, Character passcodeChar) throws EulerException;
	void swapPositionsOfChars(List<Character> passcodeChars, Integer previousIndex, Integer currentIndex) throws EulerException;
	void derivePasscodeChars(PasscodeDerivation passcodeDerivation, List<String> keyLogs,
			List<Character> passcodeChars) throws EulerException;
}
