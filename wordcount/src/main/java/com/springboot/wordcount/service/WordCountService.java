package com.springboot.wordcount.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.springboot.wordcount.model.WordCountModel;

@Service
public class WordCountService {
	
	public WordCountModel getTotalWordCount(String text) {
		WordCountModel wordCountModel = new WordCountModel();
		String[] words = null;
		int count = 0;
		if(!text.equals("")) {
			words = lineSplitter(text);
			count = words.length;	
		}
		wordCountModel.setCount(count);
		String topWords = getTopWords(text, 10);
		wordCountModel.setTopWords(topWords);
		return wordCountModel;
	}
	
	//get top 10 sorted words
	public String getTopWords(String line, int num) {
		List<Entry<String, Integer>> list= null;
		if(!line.equals("")) {
			String[] words = lineSplitter(line);
			Map<String, Integer> map = new HashMap<>();
			int count=1;
			for(int i=0; i<words.length; i++) {
				if(map.containsKey(words[i].toLowerCase())) {
					map.put(words[i].toLowerCase(), (map.get(words[i].toLowerCase()))+1);
				}
				else {
					map.put(words[i].toLowerCase(), count);
				}
			}
			list = new ArrayList<>(map.entrySet());
			Collections.sort(list, new WordComparator());
		}
			return getSortedWords(list, num);
	}
		
	public String getSortedWords(List<Entry<String, Integer>> list, int num) {

	  StringBuilder sb = new StringBuilder(); 
	  if(list!=null && num<list.size()) {
		  for(Map.Entry<String, Integer> result: list.subList(0, num)) { 
			  sb.append(result.getKey()); 
			  sb.append(",");				  } 
//	  TreeMap<String, Integer> treeMap = new TreeMap<>(); 
//	  for(Map.Entry<String, Integer> result: list.subList(0, num)) { 
//		  treeMap.put(result.getKey(), result.getValue()); 
//		  } 
//	  for(Map.Entry<String, Integer> resultMap:  treeMap.entrySet()) { 
//		  sb.append(resultMap.getKey()); sb.append(",");
//		  }
  
	    return sb.substring(0, (sb.length()-1)); 
	    } 
	  
	  return sb.toString(); 
	  }
	
	public String[] lineSplitter(String line) {
		return line.replaceAll("(\\B'\\b)|(\\b'\\B)","").replaceAll("[^A-Za-z0-9'-]", " ").split("\\s+");
	}

}
