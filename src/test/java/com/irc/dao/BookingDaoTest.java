package com.irc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-Context.xml"})  
public class BookingDaoTest {

	@Autowired
	BookingDao bookingDao;
	
	@Test
	public void testGetBookingInfoByDateAndTrainID() throws Exception {
		bookingDao.getBookingInfoByDateAndTrainID(1235, "1A");
	}
	
}
