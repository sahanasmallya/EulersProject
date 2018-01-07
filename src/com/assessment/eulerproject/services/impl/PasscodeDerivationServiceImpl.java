package com.assessment.eulerproject.services.impl;

import java.util.List;

import com.assessment.eulerproject.constants.Message;
import com.assessment.eulerproject.exceptions.EulerException;
import com.assessment.eulerproject.exceptions.PasscodeException;
import com.assessment.eulerproject.passcodeDerivation.PasscodeDerivation;
import com.assessment.eulerproject.services.PasscodeDerivationService;

public class PasscodeDerivationServiceImpl implements PasscodeDerivationService {
	
	

	public void swapPositionsOfChars(List<Character> passcodeChars, Integer previousIndex, Integer currentIndex)  {
		
		
		
		Character previous = passcodeChars.get(previousIndex);
		Character current = passcodeChars.get(currentIndex);
		
		passcodeChars.set(previousIndex, current);
		passcodeChars.set(currentIndex, previous);

	}

	public void addPasscodeChars(List<Character> passcodeChars, Character passcodeChar) throws EulerException {
		try {
			if (passcodeChars.contains(passcodeChar))
				throw new EulerException("Attempt to add duplicate value");
			passcodeChars.add(passcodeChar);
		} catch (EulerException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public  void derivePasscodeChars(PasscodeDerivation passcodeDerivation, List<String> keyLogs,
			List<Character> passcodeChars) throws EulerException {
		for (String keyLog : keyLogs) {
			if (!passcodeChars.contains(keyLog.charAt(0)))
				passcodeDerivation.addPasscodeChars(passcodeChars, keyLog.charAt(0));
			
			for (int i = 1; i < keyLog.length(); i++) {
				Character current = keyLog.charAt(i);
				Character previous = keyLog.charAt(i - 1);
				
				if (passcodeChars.contains(current)) {
					// get the index of the previous character
					int previousIndex = passcodeChars.indexOf(previous);
					// get the index of the current character
					int currentIndex = passcodeChars.indexOf(current);

					if (currentIndex < previousIndex) {
						passcodeDerivation.swapPositionsOfChars(passcodeChars, previousIndex, currentIndex);
					}
				} else {
					passcodeDerivation.addPasscodeChars(passcodeChars, keyLog.charAt(i));
				}
			}

		}
	}

}
