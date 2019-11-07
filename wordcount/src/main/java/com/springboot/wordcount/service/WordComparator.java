package com.springboot.wordcount.service;

import java.util.Comparator;
import java.util.Map.Entry;

public class WordComparator implements Comparator<Entry<String,Integer>> {

	@Override
	public int compare(Entry<String, Integer> value1, Entry<String, Integer> value2) {
		if(value1.getValue()>value2.getValue())
			return -1;
		else if(value1.getValue()<value2.getValue())
			return 1;
		return 0;
	}
}
