package com.irc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.irc.model.Passenger;
import com.irc.service.LoginService;

@Component
public class LoginController {

	@Autowired
	LoginService loginService;
	
	public boolean login() {
		boolean isLoginSuccess;
		Passenger passenger=new Passenger();
		passenger.setPassword("");
		passenger.setPassengerId((short) 0);
		isLoginSuccess=loginService.login(passenger);
		 
		 return isLoginSuccess;
	}
	
}
