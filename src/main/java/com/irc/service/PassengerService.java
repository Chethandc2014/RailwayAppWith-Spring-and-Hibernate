package com.irc.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.irc.constants.AppConstants.*;
import com.irc.dao.PassengerDao;
import com.irc.dto.PassengerDTO;
import com.irc.entity.Booking;
import com.irc.entity.Passenger;
@Service
public class PassengerService {

	@Autowired
	PassengerDao passengerDao;
	
	public JSONObject register(PassengerDTO passengerDto) {
		JSONObject response=new JSONObject();
		try {
			
			Passenger passenger = convertDtoToEntity(passengerDto);
			
			if(passengerDao.isPassengerExist(passenger.getPassengerId())) {//Check User already exist or not..
				response.put(STATUS, FAIL);
				response.put(MESSAGE, "This ID is already registered..Please try with different ID..");
			}else {
				passengerDao.register(passenger);
				response.put(STATUS, SUCCESS);
				response.put(MESSAGE, "Registration done successfully.");
			}
			
		} catch (Exception e) {
			response.put(STATUS, FAIL);
			response.put(MESSAGE, e.getMessage());
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
	
	public Passenger convertDtoToEntity(PassengerDTO dto) {
		
		Passenger passenger=new Passenger();
		passenger.setPassengerId(dto.getId());
		passenger.setPassengerName(dto.getName());
		passenger.setGender(dto.getGender());
		passenger.setPassword(dto.getPassword());
		passenger.setAge(Short.parseShort(dto.getAge()));
		return passenger;
	}
	
	
	
}

