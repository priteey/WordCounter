package com.springboot.wordcount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.wordcount.model.WordCountModel;
import com.springboot.wordcount.service.WordCountService;

@Controller
public class WordCountController {
	
	@Autowired
	private  WordCountService wordCountService;
	
	@RequestMapping("/")
	public String addFile() {
		return "addFile";
	}
	
	//get total word count
	@RequestMapping("/count")
	public String getTotalWordCount(@RequestParam("text") String text, Model model) {
		WordCountModel wordCount = wordCountService.getTotalWordCount(text);
		model.addAttribute("count", wordCount.getCount());
		model.addAttribute("topWords", wordCount.getTopWords());
		return "addFile";
	}
}
