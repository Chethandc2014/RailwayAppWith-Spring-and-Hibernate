package com.irc.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irc.dto.BookingDTO;

@Service
public class BookingService {

	@Transactional
	public JSONObject bookTiket(BookingDTO bookingDTO) {
		JSONObject response = new JSONObject();
		try {
			
			response.put("isBokingSuccess", true);
			response.put("bookingInfo", "");
			
		} catch (Exception e) {
			response.put("isBokingSuccess", false);
			response.put("message", "Ticket Booking failed due to "+e.getMessage());
		}
		return response;
	}

}
