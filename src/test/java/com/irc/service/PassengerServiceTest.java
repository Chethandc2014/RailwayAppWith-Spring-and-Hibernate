package com.irc.service;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.irc.entity.District;
import com.irc.entity.Passenger;
import com.irc.entity.PassengerAddress;
import com.irc.entity.State;
import com.irc.entity.Taluk;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-Context.xml" })
public class PassengerServiceTest {

	@Autowired
	PassengerService passengerService;


	@Test
	@Transactional
	public void testRegister() {
	
		State state=new State();		
		state.setStateId((short) 1);
		//state.setStateName("KARNATAKA");
		
		District district=new District();
		district.setDistrictId((short) 1);
		//district.setDistrictName("DAVANAGERE");
		district.setState(state);
		
		Taluk taluk=new Taluk();
		taluk.setTalukId((short) 1);
		//taluk.setTalukName("HARIHARA");
		taluk.setDistrict(district);
		
		PassengerAddress passengerAddress=new PassengerAddress();
		passengerAddress.setPassengerAddressId((short) 2);
		passengerAddress.setHouseNo("#123");
		passengerAddress.setStreet("Rajkumar RD");
		passengerAddress.setTaluk(taluk);
		
		Passenger passenger=new Passenger();
		passenger.setPassengerId("Swaraj");
		passenger.setPassengerName("Swaraj Sharma");
		passenger.setPassword("shrma");
		passenger.setAge((short)25);
		passenger.setGender("M");
		passenger.setPassengerAddress(passengerAddress);
		JSONObject response = passengerService.register(passenger);
		System.out.println("Response message"+response.getString("message"));
		Assert.assertEquals("Registration sucess", "success", response.getString("status"));
		
		
	}

	@Test
	 public void testGetPassengerDetails() {
		JSONObject response = passengerService.getPassengerDetails("TestUser1");
		Assert.assertNotNull("Response Got successfully..", response);
		Assert.assertEquals("Passenger Detials got successfully", "success", response.getString("status"));
		System.out.println(response.toString());
	}
}
