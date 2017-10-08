package com.irc.service;

import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.irc.entity.Passenger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-Context.xml" })
public class LoginServiceTest {

	@Autowired
	LoginService loginService;

	@Test
	public void test() {

		Passenger passenger = new Passenger();
		passenger.setPassengerId("TestUser");
		passenger.setPassword("TestPass");
		JSONObject response = loginService.login(passenger);
		System.out.println("Service Object is created successfully-->Referece"+loginService);
		assertTrue("Login successul..", response.getBoolean("isLoginSuccess"));

	}

}
