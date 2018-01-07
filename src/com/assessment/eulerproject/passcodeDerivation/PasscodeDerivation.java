package com.assessment.eulerproject.passcodeDerivation;

import java.util.ArrayList;
import java.util.List;

import com.assessment.eulerproject.constants.Message;
import com.assessment.eulerproject.exceptions.EulerException;
import com.assessment.eulerproject.exceptions.PasscodeException;
import com.assessment.eulerproject.services.InputReaderService;
import com.assessment.eulerproject.services.PasscodeDerivationService;
import com.assessment.eulerproject.services.impl.InputReaderServiceImpl;
import com.assessment.eulerproject.services.impl.PasscodeDerivationServiceImpl;

public class PasscodeDerivation implements InputReaderService, PasscodeDerivationService {

	static InputReaderService inputReader = new InputReaderServiceImpl();
	static PasscodeDerivationService passcodeDerivationService = new PasscodeDerivationServiceImpl();

	public static void main(String[] args) throws PasscodeException {
		PasscodeDerivation passcodeDerivation = new PasscodeDerivation();
		List<String> keyLogs;
		try {
			keyLogs = passcodeDerivation.readInput("keyLog.txt");
			String passcode = "";
			List<Character> passcodeChars = new ArrayList<Character>();

			passcodeDerivation.derivePasscodeChars(passcodeDerivation, keyLogs, passcodeChars);

			for (Character c : passcodeChars) {
				passcode = passcode + c;
			}
			System.out.println(passcode);
		} catch (EulerException e) {
			System.out.println(e.getErrorMessage());// Do something with the exception
		}

	}

	@Override
	public List<String> readInput(String path) throws PasscodeException {
		if (null == path || path.length() == 0)
			throw new PasscodeException(Message.INVALIDPATH);
		return inputReader.readInput(path);
	}

	@Override
	public void derivePasscodeChars(PasscodeDerivation passcodeDerivation, List<String> keyLogs,
			List<Character> passcodeChars) throws EulerException {
		passcodeDerivationService.derivePasscodeChars(passcodeDerivation, keyLogs, passcodeChars);
	}

	public void swapPositionsOfChars(List<Character> passcodeChars, Integer previousIndex, Integer currentIndex) throws EulerException {
		passcodeDerivationService.swapPositionsOfChars(passcodeChars, previousIndex, currentIndex);

	}

	public void addPasscodeChars(List<Character> passcodeChars, Character passcodeChar) throws EulerException {
		passcodeDerivationService.addPasscodeChars(passcodeChars, passcodeChar);

	}

}
