package com.irc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
	
	
	@RequestMapping(value="/booking",method=RequestMethod.POST,consumes="application/json",produces="")
	public  JSONObject bookTicket(@RequestBody BookingDTO bookingDTO,HttpServletResponse httpResponse) {
		JSONObject response = bookingService.bookTiket(bookingDTO);
		// httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8090");
		//httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		//httpResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		return response;
	}
	
}
