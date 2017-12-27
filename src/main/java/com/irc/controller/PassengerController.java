package com.irc.controller;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.irc.dto.BookingDto;
import com.irc.dto.JsonResponseWrapper;
import com.irc.dto.PassengerDto;
import com.irc.dto.TrainSearchDto;
import com.irc.service.BookingService;
import com.irc.service.PassengerService;



@RestController
@RequestMapping(value="passangerCtrl")
public class PassengerController {

	@Autowired
	PassengerService passengerService;
	
	@Autowired
	BookingService bookingService;
	 
	@RequestMapping(value="/register",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public JsonResponseWrapper register(@RequestBody PassengerDto passengerDto) {
		JSONObject response = passengerService.register(passengerDto);
		return JsonResponseWrapper.createResponseWrapper(response.toString());

	}
	
	
	@RequestMapping(value="/search",method=RequestMethod.GET,produces="application/json")
	public JsonResponseWrapper search(@RequestParam("sourceStn") String source,@RequestParam("destinationStn") String destination,
			@RequestParam("dateOfJourney") String dateOfJourney) {
		
		TrainSearchDto trainSearchDto=new TrainSearchDto();
		trainSearchDto.setSource(source);
		trainSearchDto.setDestination(destination);
		trainSearchDto.setDateOfJourney(dateOfJourney);
		JSONObject response = passengerService.searchTrain(trainSearchDto);
		return JsonResponseWrapper.createResponseWrapper(response.toString());

	}
	
	@RequestMapping(value="/booking",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public  JsonResponseWrapper bookTicket(@RequestBody BookingDto bookingDTO,HttpServletResponse httpResponse) {
		JSONObject response = bookingService.bookTiket(bookingDTO);
		// httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8090");
		//httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		//httpResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		JsonResponseWrapper.createResponseWrapper(response.toString());
		return JsonResponseWrapper.createResponseWrapper(response.toString());
	}
	
}
