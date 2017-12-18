package com.irc.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.irc.dto.BookingDTO;
import com.irc.exception.TrainNotExistException;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-Context.xml"})  
public class BookingServiceTest {

	@Autowired
	BookingService bookingService;

	@Test
	public void testBookTiketFor1ACoach() {
		
		BookingDTO bookingDTO=new BookingDTO();
		bookingDTO.setRouteId("1");
		bookingDTO.setTrainNo("1236");
		bookingDTO.setSeatType("2A");
		bookingDTO.setDateOfJourney("09/11/2017");
		bookingDTO.setBoardingStn("BNG");
		bookingDTO.setDeBoardingStn("DVH");
		bookingService.bookTiket(bookingDTO);
	}

	@Test
	public void testBookTiketForBookingFull() {
		
		BookingDTO bookingDTO=new BookingDTO();
		bookingDTO.setRouteId("1");
		bookingDTO.setTrainNo("1235");
		bookingDTO.setSeatType("1A");
		bookingDTO.setDateOfJourney("03/11/2017");
		bookingDTO.setBoardingStn("BNG");
		bookingDTO.setDeBoardingStn("DVH");
		bookingService.bookTiket(bookingDTO);
	}
	
	@Test(expected=TrainNotExistException.class)
	public void testBookTiketForTrainNotAvilableExce() {
		
		BookingDTO bookingDTO=new BookingDTO();
		bookingDTO.setRouteId("1");
		bookingDTO.setTrainNo("1230");
		bookingDTO.setSeatType("1A");
		bookingDTO.setDateOfJourney("03/11/2017");
		bookingDTO.setBoardingStn("BNG");
		bookingDTO.setDeBoardingStn("DVH");
		bookingService.bookTiket(bookingDTO);
	}
}
