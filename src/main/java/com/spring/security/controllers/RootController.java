package com.spring.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
	
	@GetMapping("/welcome")
	public String getWelcomePage() {
		return "welcome";
	}

}
