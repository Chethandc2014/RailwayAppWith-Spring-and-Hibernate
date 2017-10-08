package com.irc.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.irc.entity.Passenger;
import com.irc.service.LoginService;

@RestController
@RequestMapping("/loginController")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String login(@RequestParam("name") String userName,@RequestParam("password") String password ) {
		JSONObject response;
		Passenger passenger=new Passenger();
		passenger.setPassword(password);
		passenger.setPassengerId(userName);
		response =loginService.login(passenger);
		 
		 return response.toString();
	}
	
}
