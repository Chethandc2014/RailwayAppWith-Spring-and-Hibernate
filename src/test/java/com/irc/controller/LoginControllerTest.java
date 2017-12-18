package com.irc.controller;

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
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.json.JSONObject;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.irc.dao.BookingDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-Context.xml"})
@WebAppConfiguration
public class LoginControllerTest {

	private MockMvc mockMvc;

	@Autowired
	LoginController loginController;
	
	@Autowired 
	WebApplicationContext wac;
	
	@Autowired
	BookingDao bookingDao;
	
	 @Before
	    public void setup() {
	       // this.mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();   >>> Can be used for Single Controller Testing
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();		
	  }

	 
	@Test
	public void test1() throws Exception {
		//bookingDao.bookTicket();
	}
	
	@Test
	@Ignore
	public void test() throws Exception {
    	//MockMvcRequestBuilders
		//MockMvcResultMatchers
		MockHttpServletResponse response = mockMvc.perform(post("/loginController/login")
				.param("name", "TestUser")
				.param("password", "TestPass")).andReturn().getResponse();
		System.out.println(response.getStatus());
	
	       //Gson gson=new Gson();
	     //  String jsonStrResponse = gson.toJson();
	     //  Class<JSONObject> classOfJSON = null;   //gson.fromJson(response.getContentAsString(), JSONObject.class);
	      // JSONObject jsonResponse = new JSONObject(jsonStrResponse); //We can use JSON-Simple jar also..
	       JsonParser parser=new JsonParser();
	       JsonObject  gsonJsonResponse= parser.parse(response.getContentAsString()).getAsJsonObject();
	       
	       JSONObject jsonResponse=new JSONObject(gsonJsonResponse.toString());
	       System.out.println(gsonJsonResponse);
	       Assert.assertTrue("Login sucessfull through Rest Controlller...", jsonResponse.getBoolean("isLoginSuccess"));
	}

}
