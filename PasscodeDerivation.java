package com.dataenrichment.eulerproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PasscodeDerivation {

	public static void main(String[] args) {
		PasscodeDerivation passcodeDerivation = new PasscodeDerivation();
		List<String> keyLogs = passcodeDerivation.getInputFromFile(new File("keylog.txt"));

		String result = "";
		List<Character> passcodeChars = new ArrayList<Character>();
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
						//passcodeChars.remove(current);
						passcodeDerivation.updatePositionOfCurrent(passcodeChars, previousIndex, currentIndex);
					}
				} else {
					passcodeDerivation.addPasscodeChars(passcodeChars, keyLog.charAt(i));
				}
			}

		}

		for (Character c : passcodeChars) {
			result = result + c;
		}
		System.out.println(result);

	}

	public void updatePositionOfCurrent(List<Character> passcodeChars, Integer previousIndex, Integer currentIndex) {
		Character previous = passcodeChars.get(previousIndex);
		Character current = passcodeChars.get(currentIndex);
		passcodeChars.set(previousIndex,current);
		passcodeChars.set(currentIndex,previous);
		
	}

	public void addPasscodeChars(List<Character> passcodeChars, Character passcodeChar) {
		try {
			if (passcodeChars.contains(passcodeChar))
				throw new PasscodeException("Attempt to add duplicate value");
			passcodeChars.add(passcodeChar);
		} catch (PasscodeException e) {
			System.out.println(e.getMessage());
		}

	}

	public List<String> getInputFromFile(File file) {

		File inputFile = file;
		List<String> keylogs = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));

			String input = "";
			while ((input = br.readLine()) != null) {
				keylogs.add(input);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return keylogs;
	}

}
