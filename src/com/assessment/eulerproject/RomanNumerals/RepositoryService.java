package com.assessment.eulerproject.RomanNumerals;

import java.util.Map;
import java.util.TreeMap;

public interface RepositoryService {

	Map<String, Integer> getRomanToDec();
	TreeMap<Integer, String>  getDecToRoman();
}
