package com.irc.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.irc.dto.JsonResponseWrapper;
import com.irc.dto.TrainDto;
import com.irc.service.AdminService;

@RestController
@RequestMapping(value="/adminCtrl")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping(value="/addTrain",method=RequestMethod.POST)
	public ObjectNode addTrain(@RequestBody TrainDto trainDto) {
		
		ObjectNode response = adminService.addTrain(trainDto);
		
		return response;
	}
	
	@RequestMapping(value="/updateTrain",method=RequestMethod.PUT)
	public ObjectNode updateTrain(@RequestBody TrainDto trainDto) {
		
		ObjectNode response = adminService.updateTrain(trainDto);
		return response;
	}
	
	@RequestMapping(value="/deleteTrain/{trainId}",method=RequestMethod.DELETE)
	public ObjectNode deleteTrain(@PathVariable("trainId") String trainId) {
		ObjectNode response = adminService.deleteTrain(trainId);
		return response;
	}
	
	
	
}
