package com.irc.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.irc.dto.BookingDTO;
import com.irc.service.BookingService;

@RestController
@RequestMapping(value="/appController")
public class ApplicatinController {

	@Autowired
	BookingService bookingService;
	
	@RequestMapping(value="/booking",method=RequestMethod.POST,consumes="application/json")
	@JsonRawValue  @ResponseBody
	public String bookTicket(@RequestBody BookingDTO bookingDTO) {
		System.out.println(bookingDTO);
		JSONObject response = bookingService.bookTiket(bookingDTO);
		return response.toString();
		
	}
	
}
