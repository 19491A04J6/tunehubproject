package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersServices {

	@Autowired
	UsersRepository userrepo;

	@Override
	public boolean addUser(Users user) {
		if(userrepo.findByEmail(user.getEmail()) == null)
		{
			userrepo.save(user);
			return false;
		}
		return true;
	}


	@Override
	public boolean validateUser(String email, String password) {
		
		Users user=userrepo.findByEmail(email);//return null if the email id is not exsist in database
		String db_password=user.getPassword();
		if(db_password.equals(password))
		{
			return true;
		}
		else
		{
		return false;
		}
	}


	@Override
	public String getRole(String email) {
		Users user=userrepo.findByEmail(email);
		return (user.getRole());
	}

}
