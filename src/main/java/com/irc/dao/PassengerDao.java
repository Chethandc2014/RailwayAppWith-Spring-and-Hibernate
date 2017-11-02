package com.irc.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.irc.entity.Booking;
import com.irc.entity.Passenger;

@Repository
@Transactional
public class PassengerDao extends BaseDaoImpl{

	public void register(Passenger passenger) throws Exception {
	
		try {
			create(passenger);
		} catch (Exception e) {
			 e.printStackTrace();
		    throw e;
		}
	}
	
	public <T> Passenger getPassengerDetails(Class<T> passengerClass,String passengerId) throws Exception {
		Passenger passenger=null;
		try {
			 passenger = (Passenger) getEntityById(passengerClass, passengerId);
		} catch (Exception e) {
			throw e;
		}
		return passenger;
	}
	
	public Booking getBookingDetails(Class<Booking> bookingClass, String pnrNo) throws Exception {
		Booking bookingDetials=null;
		try {
			    bookingDetials=(Booking)getEntityById(bookingClass, pnrNo);
		} catch (Exception e) {
			throw e;
		}
		return bookingDetials;
	}
	
	public void getBookingHistory() {

	}
	
	public void passwordChange() {

	
	}
	
}
