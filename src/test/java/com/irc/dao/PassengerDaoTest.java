package com.irc.dao;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.irc.entity.Passenger;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-Context.xml"}) 
public class PassengerDaoTest {

	@Autowired
	PassengerDao passengerDao;
	
	//@Test
	public void testRegister() throws Exception {
		
		Passenger passenger=new Passenger();
		
		passenger.setAge((short) 12);
		passenger.setGender("M");
		passenger.setPassengerName("TestUser");
		passenger.setPassword("TestPass");
		passenger.setPassengerId("1239");/// Keep always new data
		Object create = passengerDao.create(passenger);
		Assert.assertNotNull(create);
	}
	
	
	//@Test(expected=DataIntegrityViolationException.class)
	public void testRegisterForDuplicateId() throws Exception {
		
		Passenger passenger=new Passenger();
		
		passenger.setAge((short) 12);
		passenger.setGender("M");
		passenger.setPassengerName("TestUser");
		passenger.setPassword("TestPass");
		passenger.setPassengerId("1238");// Keep duplicate data for Test case
		//passenger.setPassengerAddress(passengerAddress);
		Object create = passengerDao.create(passenger);
		System.out.println("Serizable Object..."+create);
	}

	//@Test
	public  void testGetPassengerDetails() {
		//passengerDao.getBookingDetails(bookingClass, pnrNo);
	}
	
	
	
	
}
