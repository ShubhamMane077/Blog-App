package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.dto.LoginDto;
import com.nt.service.LoginService;

@Controller
@RequestMapping("/logins")
public class LoginContriller {
	
	@Autowired
	private LoginService service;
	
	@RequestMapping("/form")
	public String loginForm() {
		return "login";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam String username , @RequestParam String password ,Model model) {
		LoginDto dto = service.login(username, password);
		
		if(dto == null) {
			model.addAttribute("errorMsg","Please enter Correct credentials to login.");
			return "login";
		}
		
		return "common/home";
	}
}
