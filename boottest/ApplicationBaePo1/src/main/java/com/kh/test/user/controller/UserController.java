package com.kh.test.user.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.user.model.service.UserService;
import com.kh.test.user.model.vo.User;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/searchId")
	public String searchId(String userId, Model model) {
		
		User user = service.searchId(userId);
		
		if(user != null) {
			model.addAttribute("user", user);
			// prefix : templates/
			// suffix : .html
			return "searchSuccess";
		}
		
		return "searchFail";
	}
	
	
	
	
	
	
	
	
	
}