package com.irc.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.irc.constants.AppConstants.*;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.irc.dao.PassengerDao;
import com.irc.dao.SearchDao;
import com.irc.dto.PassengerDto;
import com.irc.dto.TrainSearchDto;
import com.irc.entity.Booking;
import com.irc.entity.Passenger;
import com.irc.entity.Train;
import com.irc.util.AppUtil;

import static com.irc.constants.AppConstants.*;
@Service
public class PassengerService {

	@Autowired
	PassengerDao passengerDao;
	
	@Autowired
	SearchDao searchDao;
	
	@Autowired
	SearchService searchService;
	
	public JSONObject register(PassengerDto passengerDto) {
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
	
	
	public void passwordChange() {

	}
	
	public Passenger convertDtoToEntity(PassengerDto dto) {
		
		Passenger passenger=new Passenger();
		passenger.setPassengerId(dto.getId());
		passenger.setPassengerName(dto.getName());
		passenger.setGender(dto.getGender());
		passenger.setPassword(dto.getPassword());
		passenger.setAge(Short.parseShort(dto.getAge()));
		return passenger;
	}
	
	@Transactional
	public ObjectNode searchTrain(TrainSearchDto dto) {
		
		ObjectNode response = AppUtil.getObjectNodeInstance();//Similar use case like //JSONObject response=new JSONObject(); 
		
		Date dateOfJourney=null;
		
		try {
				try {
					dateOfJourney =new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDateOfJourney());
				} catch (ParseException e) {
					e.printStackTrace();
				return	response.put(FAIL, "Invalided Date formate..");
				}
			
		    	List<Train> trains=searchService.getTrainForSourceAndDestinationStn(dto.getSource(), dto.getDestination(), dateOfJourney);
			
				try {
					//response.put("trainList", trains);//Getting error--changing using  jackson API comversion
					response.put("trainList", AppUtil.parseEntityListToString(trains));
					response.put(STATUS, SUCCESS);
				} catch (Exception e) {
					e.printStackTrace();
					return	response.put(FAIL, e.getMessage());
				}			
		}catch(Exception e) {
			e.printStackTrace();
			return	response.put(FAIL, e.getMessage());
		}
		
		return response;
		
	}
	
}

