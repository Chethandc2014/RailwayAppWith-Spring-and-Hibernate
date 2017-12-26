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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-Context.xml"})
@WebAppConfiguration
public class PassengerControllerTest {

	@Autowired
	PassengerController passengerController;
	
	@Autowired
	WebApplicationContext wac;
	
	private MockMvc mockMvc;
	@Before
	public void setUp() throws Exception {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
		System.out.println("All Configurations are Ok....");
	}
	
	@Test
	public void testSearch() throws Exception {
		MvcResult result = mockMvc.perform(get("/passangerCtrl/search").contentType(MediaType.APPLICATION_JSON).
										   param("sourceStn", "BENGALURU").param("destinationStn", "HUBLI").param("dateOfJourney", "08/11/2017")).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		System.out.println(response.getStatus());
		
		JSONObject reqResponse=new JSONObject(response.getContentAsString());
		Assert.assertNotNull(reqResponse);
		//System.out.println(reqResponse.getJSONObject("response").getJSONArray("trainList"));
		Assert.assertEquals(response.getStatus(), 200);
		//passengerController.search(source, destination, dateOfJourney);
		
	}
	

}
