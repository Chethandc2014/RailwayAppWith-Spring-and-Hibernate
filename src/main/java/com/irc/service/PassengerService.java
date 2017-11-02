package com.irc.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irc.dao.PassengerDao;
import com.irc.entity.Booking;
import com.irc.entity.Passenger;

@Service
public class PassengerService {

	@Autowired
	PassengerDao passengerDao;
	
	public JSONObject register(Passenger passenger) {
		JSONObject response=new JSONObject();
		try {
			
			passengerDao.register(passenger);
			response.put("status", "success");
			response.put("message", "Registration done successfully.");
		} catch (Exception e) {
			response.put("status", "fail");
			response.put("message", e.getMessage());
		}
		return response;
	}
	
	public JSONObject getPassengerDetails(String passengerId) {

		JSONObject response=new JSONObject();
		try {
			Passenger passengerDetails = passengerDao.getPassengerDetails(Passenger.class,passengerId);
			response.put("status", "success");
			response.put("passengerInfo", passengerDetails);
		} catch (Exception e) {
			response.put("status", "fail");
			response.put("message", e.getMessage());
		}
		return response;
	}
	
	public JSONObject getBookingDetails(String pnrNo) {
		JSONObject response=new JSONObject();
		try {
			
			Booking bookingDetails = passengerDao.getBookingDetails(Booking.class,pnrNo);
			response.put("status", "success");
			response.put("bookingDetails", bookingDetails);
		} catch (Exception e) {
			response.put("status", "fail");
			response.put("message", e.getMessage());
		}
		return response;
	}
	
	public void getBookingHistory() {

	}
	
	public void passwordChange() {

	}
	
}

