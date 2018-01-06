package com.assessment.eulerproject.services;

import java.util.List;

import com.assessment.eulerproject.passcodeDerivation.PasscodeDerivation;

public interface PasscodeDerivationService {

	void addPasscodeChars(List<Character> passcodeChars, Character passcodeChar);
	void swapPositionsOfChars(List<Character> passcodeChars, Integer previousIndex, Integer currentIndex);
	void derivePasscodeChars(PasscodeDerivation passcodeDerivation, List<String> keyLogs,
			List<Character> passcodeChars);
}
