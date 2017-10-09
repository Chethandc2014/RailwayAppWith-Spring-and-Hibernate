package com.irc.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.irc.dto.BookingDTO;
import com.irc.service.BookingService;

@RestController
@RequestMapping(value="/appController")
public class ApplicatinController {

	@Autowired
	BookingService bookingService;
	
	@RequestMapping(value="/booking",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String bookTicket(@RequestParam BookingDTO bookingDTO) {
		JSONObject response = bookingService.bookTiket(bookingDTO);
		return response.toString();
		
	}
	
}
