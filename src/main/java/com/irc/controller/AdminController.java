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
	
	@RequestMapping(value="/addTrain/{trainId}",method=RequestMethod.PUT)
	public JsonResponseWrapper updateTrain(@PathVariable("trainId") String tainId,@RequestBody TrainDto trainDto) {
		
		JSONObject addTrain = adminService.updateTrain(trainDto);
		JsonResponseWrapper responseWrapper = JsonResponseWrapper.createResponseWrapper(addTrain.toString());
		return responseWrapper;
	}
	
	@RequestMapping(value="/deleteTrain",method=RequestMethod.DELETE)
	public JsonResponseWrapper deleteTrain(@RequestParam("tainId") String tainId) {
		adminService.deleteTrain(tainId);
		return null;
	}
	
	
	
}
