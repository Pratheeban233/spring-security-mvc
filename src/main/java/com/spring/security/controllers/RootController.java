package com.spring.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.security.dao.SignUpDao;
import com.spring.security.dto.SignUpDTO;

@Controller
public class RootController {
	
	
	@Autowired
	private SignUpDao signUpDao;
	
	@GetMapping("/signup")
	public String signup(@ModelAttribute("signUpDTO") SignUpDTO signUpDTO) {
		
		return "signup";
	}

	@PostMapping("/process-signup")
	public String processsignup(SignUpDTO signUpDTO){
		
		signUpDTO.setPassword(new BCryptPasswordEncoder().encode(signUpDTO.getPassword()));
		signUpDao.saveUsers(signUpDTO);
		
		return "redirect:/login";
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "custom-login-page";
	}
}
