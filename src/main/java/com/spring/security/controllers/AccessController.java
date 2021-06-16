package com.spring.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccessController {
	
	@GetMapping("/welcome")
	public String getWelcomePage() {
		return "welcome";
	}
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "Hello user. how you are ?";
	}
	
	@ResponseBody
	@GetMapping("/bye")
	public String bye() {
		return "bye bye ..!";
	}

}
