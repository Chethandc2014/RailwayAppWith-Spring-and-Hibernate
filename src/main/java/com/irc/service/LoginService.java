package com.irc.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irc.dao.LoginDao;
import com.irc.entity.Passenger;

@Service
public class LoginService {

	@Autowired
	LoginDao loginDao;

	//@Transactional
	public JSONObject login(Passenger passenger) {
		JSONObject response = new JSONObject();
		try {

			Passenger passsengerInfo = loginDao.login(passenger);
			if (passsengerInfo != null) {
				if (passsengerInfo.getPassengerId().equals(passenger.getPassengerId()) && passsengerInfo.getPassword().equals(passenger.getPassword())) {
					response.put("isLoginSuccess", true);
					response.put("message", "User loged in succesfully.");
				} else {
					response.put("isLoginSuccess", false);
					response.put("message", "UserID or Password is incorrect...Please try again.");
				}

			} else {
				response.put("isLoginSuccess", false);
				response.put("message", "User ID doesn't exist.");
			}

		} catch (Exception e) {
			// throw new Exception("sd",e); Don't throw from Service
			response.put("isLoginSuccess", false);
			response.put("message", "Login failure due to...." + e.getMessage());
		}
		return response;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

}
