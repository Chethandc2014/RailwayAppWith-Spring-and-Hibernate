package com.irc.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		//restTemplate.put(url, request, urlVariables);   //-->for PUT
		//String id="123";
		//HttpEntity<Object> entity=new HttpEntity<Object>(dto,null);//containes Request body and header 
		
		//ResponseEntity<ObjectNode> exchange = restTemplate.exchange("/getEmployee/{id}", HttpMethod.GET,null,ObjectNode.class,id);//Entitiy can be nullable
		//ResponseEntity<ObjectNode> exchange2 = restTemplate.exchange("/getEmployee/{id}", HttpMethod.GET,entity,ObjectNode.class,id);//ds is URI parameters such as /{id}
		//ResponseEntity<ObjectNode> exchange1 = restTemplate.exchange("/getEmployee/{id}", HttpMethod.GET,entity,ObjectNode.class);//Overloaded method without URI params...
		
		//Other use cases RequestEntity request = RequestEntity
		/*try {
			RequestEntity<PassengerDto> reuestEnityBody = RequestEntity.post(new URI("http://example.com/foo"))
			 .accept(MediaType.APPLICATION_JSON)
			 .body(dto);
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
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
