package com.irc.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import javax.servlet.ServletOutputStream;

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
	//@Ignore
	public void setUp() throws Exception {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
		System.out.println("All Configurations are Ok....");
	}

	@Test
	//@Ignore
	public void testBookTicket() throws Exception {
		
		JSONObject objReq= 	new JSONObject().put("trainNo", "123").put("coachId", "123123").put("coachType", "345").put("seatType", "1A").put("dateOfJourney", "07/07/2017").put("dateOfBooking", "08/07/2017");
		
		mockMvc.perform(post("/appController/booking").contentType(MediaType.APPLICATION_JSON)
				.content(objReq.toString()))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.response",containsString("\"isBokingSuccess\":true")));
	}	

}
