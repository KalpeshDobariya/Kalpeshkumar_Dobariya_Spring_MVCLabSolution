package com.sde.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(path="/",method=RequestMethod.GET)
	public String showMainPage() {
		return "demo";
	}	
	
	/*
	 * @RequestMapping(path="/student/save",method=RequestMethod.POST) public String
	 * savePage() { return "list-Students";
	 * 
	 * }
	 */
}
