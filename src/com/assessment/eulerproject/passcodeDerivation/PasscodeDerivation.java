package com.assessment.eulerproject.passcodeDerivation;

import java.util.ArrayList;
import java.util.List;

import com.assessment.eulerproject.services.InputReaderService;
import com.assessment.eulerproject.services.PasscodeDerivationService;
import com.assessment.eulerproject.services.impl.InputReaderServiceImpl;
import com.assessment.eulerproject.services.impl.PasscodeDerivationServiceImpl;

public class PasscodeDerivation implements InputReaderService, PasscodeDerivationService {

	
	
	static InputReaderService inputReader = new InputReaderServiceImpl();
	static PasscodeDerivationService passcodeDerivationService = new PasscodeDerivationServiceImpl();
	
	

	public static void main(String[] args) {
		PasscodeDerivation passcodeDerivation = new PasscodeDerivation();
		List<String> keyLogs = passcodeDerivation.readInput("keylog.txt");

		String passcode = "";
		List<Character> passcodeChars = new ArrayList<Character>();

		passcodeDerivation.derivePasscodeChars(passcodeDerivation, keyLogs, passcodeChars);

		for (Character c : passcodeChars) {
			passcode = passcode + c;
		}
		System.out.println(passcode);

	}

	@Override
	public List<String> readInput(String path) {
		return inputReader.readInput(path);
	}

	@Override
	public void derivePasscodeChars(PasscodeDerivation passcodeDerivation, List<String> keyLogs,
			List<Character> passcodeChars) {
		passcodeDerivationService.derivePasscodeChars(passcodeDerivation, keyLogs, passcodeChars);
	}

	public void swapPositionsOfChars(List<Character> passcodeChars, Integer previousIndex, Integer currentIndex) {
		passcodeDerivationService.swapPositionsOfChars(passcodeChars, previousIndex, currentIndex);

	}

	public void addPasscodeChars(List<Character> passcodeChars, Character passcodeChar) {
		passcodeDerivationService.addPasscodeChars(passcodeChars, passcodeChar);

	}

}
