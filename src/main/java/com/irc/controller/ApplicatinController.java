package com.irc.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irc.dto.BookingDTO;
import com.irc.dto.JsonResponseWrapper;
import com.irc.service.BookingService;

@RestController
@RequestMapping(value="/appController")
public class ApplicatinController {

	@Autowired
	BookingService bookingService;
	
	
	@RequestMapping(value="/booking",method=RequestMethod.POST,consumes="application/json")
	public  JsonResponseWrapper bookTicket(@RequestBody BookingDTO bookingDTO) {
		JSONObject response = bookingService.bookTiket(bookingDTO);
		return JsonResponseWrapper.createResponseWrapper(response.toString());
	}
	
}
