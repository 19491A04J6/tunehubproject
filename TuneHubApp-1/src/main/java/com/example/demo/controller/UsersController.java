package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersServices;


@Controller
public class UsersController {
	
	@Autowired
	UsersServices userv;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user)
	{
		boolean userstatus=userv.addUser(user);
		if(userstatus==false)
		{
		return "registerSuccess";
		}
		
		return "registerFail";
	}
	
	@PostMapping("/login")
	public String ValidateUser(@RequestParam String email,@RequestParam String password)
	{
		boolean loginstatus=userv.validateUser(email,password);
		if(loginstatus==true)
		{
		if(userv.getRole(email).equals("admin"))
	    {
	     return "adminHome";
	    }
		else
		{
			return "customerHome";
		}
		}
		return "loginFail";
	}
}
