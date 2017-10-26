package com.irc.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.irc.entity.TrainCoachSeatBooking;

@Repository
@Transactional
public class BookingDao extends BaseDaoImpl{

	
	public Object bookTicket() throws Exception {
		TrainCoachSeatBooking  book=new TrainCoachSeatBooking();
	//	book.setPnrNo((short) 123);
		Object create = create(book);
		return create;
		
	}
	
	
	
}
