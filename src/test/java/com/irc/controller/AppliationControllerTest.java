package com.irc.controller;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import static org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonGenerator;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-Context.xml"})
@WebAppConfiguration
public class AppliationControllerTest {

	@Autowired
	ApplicatinController applicatinController;
	
	@Autowired
	WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
		System.out.println("All Configurations are Ok....");
	}

	@Test
	public void test() throws Exception {
		//MockHttpServletRequestBuilder
		/*MockHttpServletResponse response = mockMvc.perform(post("/appController/booking").contentType(MediaType.APPLICATION_FORM_URLENCODED)
											.param("trainNo", "124").param("coachId", "23423")
											.param("coachType", "1A").param("seatType", "sLEEPER")
											.param("dateOfJourney", "12/12/2017").param("dateOfBooking", "11/11/2017"))
											.andReturn()
											.getResponse();*/
	
		JSONArray array=new JSONArray();
		
		JSONObject objReq= 	new JSONObject().put("trainNo", "123").put("coachId", "123123").put("coachType", "345").put("seatType", "1A").put("dateOfJourney", "07/07/2017").put("dateOfBooking", "08/07/2017");
		/*array.put(new JSONObject().put("trainNo", "123"));
		array.put(new JSONObject().put("coachId", "123123"));
		array.put(new JSONObject().put("coachType", "345"));
		array.put(new JSONObject().put("seatType", "1A"));
		array.put(new JSONObject().put("dateOfJourney", "07/07/2017"));
		array.put(new JSONObject().put("dateOfBooking", "08/07/2017"));*/
		
		objReq.put("bookingDTO", array);
		MockHttpServletResponse response = mockMvc.perform(post("/appController/booking").contentType(MediaType.APPLICATION_JSON)
				.content(objReq.toString())).andReturn().getResponse();
				
		//System.out.println(response.getContent);
		String responseStr=response.getContentAsString();
		System.out.println(responseStr);
	//	org.json.JSONObject jsonResponse=new JSONObject(responseStr);
		//JsonGenerator generator=new JsonGenerator();
		/*JsonParser parser=new JsonParser();
		JsonElement parse = parser.parse(responseStr);
		
		if(parse.isJsonObject()){
			JsonObject jobj=parse.getAsJsonObject();
		}
		org.json.JSONObject jsonObject=new JSONObject(parse.toString());*/
		//JsonObject jsonObject=new JsonObject();
		//parse.get
		org.json.JSONObject jsonResponse=new JSONObject(responseStr);
		
		//jsonResponse.getBoolean(key);
		//System.out.println(jsonResponse);
	//	System.out.println();
		 //JSONObject jsonResponse=new JSONObject().
		//JsonParser jsonParser=new JsonParser();
		//JsonElement gsonParsedJSON = jsonParser.parse(response.getContentAsString());
		//System.out.println("Status Code Of Request:"+response.getStatus());
		//JSONObject jsonObject=new JSONObject(gsonParsedJSON.toString());
		//System.out.println("Booking Done Successfully.."+jsonObject.toString());
		//Assert.assertTrue("Booking Done Successfully...", jsonObject.getBoolean("isBokingSuccess"));
		
	}	

}
