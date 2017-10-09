package com.irc.controller;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import static org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.json.JSONObject;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.JsonElement;
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
		MockHttpServletResponse response = mockMvc.perform(post("/appController/booking")
											.param("trainNo", "124").param("coachId", "23423")
											.param("coachType", "1A").param("seatType", "sLEEPER")
											.param("dateOfJourney", "12/12/2017").param("dateOfBooking", "11/11/2017"))
											.andReturn()
											.getResponse();
		JsonParser jsonParser=new JsonParser();
		JsonElement gsonParsedJSON = jsonParser.parse(response.getContentAsString());
		System.out.println("Status Code Of Request:"+response.getStatus());
		JSONObject jsonObject=new JSONObject(gsonParsedJSON.toString());
		System.out.println("Booking Done Successfully.."+jsonObject.toString());
		Assert.assertTrue("Booking Done Successfully...", jsonObject.getBoolean("isBokingSuccess"));
		
	}	

}
