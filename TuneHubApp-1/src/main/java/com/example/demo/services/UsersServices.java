package com.example.demo.services;

import com.example.demo.entities.Users;

public interface UsersServices {
	
	public boolean addUser(Users user);
	
	public boolean validateUser(String email,String password);
	
	public String getRole(String email);

}
