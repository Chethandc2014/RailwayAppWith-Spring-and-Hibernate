package com.irc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.irc.dto.BookingDto;
import com.irc.dto.JsonResponseWrapper;
import com.irc.service.ApplicationService;
import com.irc.service.BookingService;

@RestController
@RequestMapping(value="/appController")
public class ApplicatinController {

	@Autowired
	BookingService bookingService;
	
	@Autowired
	ApplicationService applicationService;
	

	@RequestMapping(value="/registration/dropdowns/states",method=RequestMethod.GET)
	public  ObjectNode getStates() {//States

		ObjectNode response = applicationService.getStates();
		return response;
		
	}
	
	@RequestMapping(value="/registration/dropdowns/states/{stateId}",method=RequestMethod.GET)
	public  ObjectNode getDistrictsByStateId(@PathVariable String stateId) {//Disricts 

		ObjectNode response = applicationService.getDistrictsByStateId(stateId);
		return response;
		
	}
	
	@RequestMapping(value="/registration/dropdowns/states/districts/{districtId}",method=RequestMethod.GET)
	public  ObjectNode getTaluksByDistrictId(@PathVariable String districtId) {//Taluks

		ObjectNode response = applicationService.getTaluksByDistrictId(districtId);
		return response;
		
	}
	
}
