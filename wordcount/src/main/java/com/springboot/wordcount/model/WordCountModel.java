package com.springboot.wordcount.model;

public class WordCountModel {
	private int count;
	private String topWords;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTopWords() {
		return topWords;
	}
	public void setTopWords(String topWords) {
		this.topWords = topWords;
	}
}
