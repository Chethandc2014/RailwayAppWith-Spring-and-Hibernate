package com.irc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.irc.dto.AddressDto;
import com.irc.dto.PassengerDto;
import com.irc.entity.Booking;
import com.irc.entity.Train;

@RestController
@RequestMapping(value="/restservice")
public class MyRestTest {

	
	
	@RequestMapping(value="/apiTest")
	private ResponseEntity<ObjectNode> doRestRequest(String uri,Object request,HashMap<String, String> params,HashMap<String, String> reqHeaders) {
		RestTemplate restTemplate=new RestTemplate();
		
		ResponseEntity<ObjectNode> resonse = restTemplate.getForEntity("http://localhost:8000/IndianRailways/app/appController/registration/dropdowns/states", ObjectNode.class);
		System.out.println(resonse);
		ObjectNode body = resonse.getBody();
		ObjectMapper mapper = new ObjectMapper();
		try {
			/*String writeValueAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);*/
			String writeValueAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(resonse);
			System.out.println(writeValueAsString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Booking booking=null;
		
		ResponseEntity<ObjectNode> response = restTemplate.postForEntity("url", booking, ObjectNode.class);
		
		ObjectNode body2 = response.getBody();*/
		postRequestTest();
		
		return resonse;
		

	}
	
	
	private void getRequesTest() {
		

	}
	int i=0;
	
	private void postRequestTest() {
		
		RestTemplate restTemplate=new RestTemplate();
		
		PassengerDto dto=new PassengerDto();
		dto.setId("dcChethandc"+i);
		dto.setName("test T");
		dto.setPassword("testt");
		dto.setAge("25");
		dto.setGender("M");
		AddressDto address=new AddressDto();
		address.setStreet("First street");
		address.setHouseNo("23");
		dto.setAddress(address);
	  //HashMap<String, String> map=new HashMap<String, String>();
	
		ResponseEntity<ObjectNode> response = restTemplate.postForEntity("http://localhost:8000/IndianRailways/app/passangerCtrl/register", dto,ObjectNode.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String writeValueAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
			System.out.println(writeValueAsString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		i++;
		
		
	}
	
	
	
	
	
	
	
}
