package com.irc.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.irc.dto.PassengerDTO;
import com.irc.service.PassengerService;



@RestController
@RequestMapping(value="passangerCtrl")
public class PassengerController {

	@Autowired
	PassengerService passengerService;
	 
	@RequestMapping(value="/register",method=RequestMethod.POST,consumes="application/json")
	public JSONObject register(@RequestBody PassengerDTO passengerDto) {
		JSONObject response = passengerService.register(passengerDto);
		return response;

	}
	
}
