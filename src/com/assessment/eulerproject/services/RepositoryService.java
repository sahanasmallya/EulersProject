package com.assessment.eulerproject.services;

import java.util.Map;
import java.util.TreeMap;

public interface RepositoryService {

	Map<String, Integer> getRomanToDec();
	TreeMap<Integer, String>  getDecToRoman();
}
