package com.irc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.irc.dao.LoginDao;
import com.irc.model.Passenger;

@Component
public class LoginService {

	@Autowired
	LoginDao loginDao;
	
	public boolean login(Passenger passenger) {
		try {
		
		}catch(Exception e) {
			
		}
		return false;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	
}
