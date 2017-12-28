package com.irc.service;

import static com.irc.constants.AppConstants.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.irc.dao.BookingDao;
import com.irc.dto.BookingDto;
import com.irc.entity.Booking;
import com.irc.entity.Coach;
import com.irc.entity.CoachSeatNotAvailableException;
import com.irc.entity.CoachType;
import com.irc.entity.Route;
import com.irc.entity.Train;
import com.irc.exception.BookingNotAvailableException;
import com.irc.exception.TrainNotExistException;
import com.irc.util.AppUtil;

@Service
@Transactional
public class BookingService {

	@Autowired
	BookingDao bookingDao;
	
	/**
	 * @param bookingDTO
	 * @return
	 */
	
	public JSONObject bookTiket(BookingDto bookingDTO) {
		JSONObject response = new JSONObject();
		try {
			//Booking Business Logic
			//1)Check the Current Booking Train's Coach and Seat No for Route and Date of Journey
		
			Date dateOfJourney=new SimpleDateFormat("dd/MM/yyyy").parse(bookingDTO.getDateOfJourney());
			short routeId=Short.parseShort(bookingDTO.getRouteId());
			short trainId=Short.parseShort(bookingDTO.getTrainNo());
			String coachType=bookingDTO.getSeatType();
			Map<String, Short> currentBookingCoachAndSeatNoMap = bookingDao.getActiveBookingCoachIdAndSeatNO(dateOfJourney,routeId,trainId, coachType);
			
			Short currentCoachId=currentBookingCoachAndSeatNoMap.get(COACH_ID);
			Short currentSeatNo=currentBookingCoachAndSeatNoMap.get(SEAT_NO);
			//2)Check the SeatNo Max Count for Coach Type
			Short coachSeatLimit = bookingDao.getMaxSeatLimitForCoachByCoachType(bookingDTO.getSeatType());//SeatType is Same as CoachType
			if(currentCoachId ==null || currentSeatNo==null) {//No Booking add for Coach.. First seat Booking for CoachType in Route
				Short nextCoachId = bookingDao.getNextCoachIDByDateRouteAndTrainId(dateOfJourney, routeId, trainId, coachType);
				Booking booking = generateBookingEntity(bookingDTO,nextCoachId);
				Booking bookingInfo = bookingDao.bookTicket(booking);
				response.put("isBokingSuccess", true);
				response.put("message", "Booking Done succesfully..");
				response.put("bookingInfo", bookingInfo);
			}else if(currentSeatNo.shortValue()<coachSeatLimit.shortValue()) {//Checking for current Coach is Available for Booking
				Booking booking = generateBookingEntity(bookingDTO,currentCoachId);
				Booking bookingInfo = bookingDao.bookTicket(booking);
				response.put("isBokingSuccess", true);
				response.put("message", "Booking Done succesfully..");
				response.put("bookingInfo", bookingInfo);
			
			}else if(currentSeatNo.shortValue()==coachSeatLimit.shortValue()) {//Checking for current seatNo is last seat of Coach.. Then Get Next Coach
			
				try {
					Short nextCoachId = bookingDao.getNextCoachIDByDateRouteAndTrainId(dateOfJourney, routeId, trainId, coachType);
					//3)Book Ticket using NextCoachID
					Booking booking = generateBookingEntity(bookingDTO,nextCoachId);
					Booking bookingInfo = bookingDao.bookTicket(booking);
					response.put("isBokingSuccess", true);
					response.put("message", "Booking Done succesfully..");
					response.put("bookingInfo", bookingInfo);
					
				}catch (BookingNotAvailableException e) {
					response.put("isBokingSuccess", false);
					response.put("message", e.getMessage());
				}catch(CoachSeatNotAvailableException e) {
					response.put("isBokingSuccess", false);
					response.put("message", e.getMessage());
				}catch(TrainNotExistException e){
					response.put("isBokingSuccess", false);
					response.put("message", e.getMessage());
				}
				
			}
			
		} catch (Exception e) {
			response.put("isBokingSuccess", false);
			response.put("message", "Ticket Booking failed due to "+e.getMessage());
		}
		return response;
		
	}

	/**
	 * @param bookingDTO
	 * @param coachId
	 * @return
	 * @throws ParseException
	 * @throws CoachSeatNotAvailableException
	 */
	private Booking generateBookingEntity(BookingDto  bookingDTO,short coachId) throws ParseException, CoachSeatNotAvailableException  {
		Date dateOfJourney = new SimpleDateFormat("dd/MM/yyyy").parse(bookingDTO.getDateOfJourney());
		short trainId=Short.valueOf(bookingDTO.getTrainNo());
		short routeId = Short.parseShort(bookingDTO.getRouteId());
		CoachType coachTypeEntity = bookingDao.getCoachTypeEntity(bookingDTO.getSeatType());
		short seatNo = bookingDao.getBookingSeatNoByCoachId(dateOfJourney,routeId,trainId, coachId);
		
		Train train=new Train();
		train.setTrainId(trainId);
	
		Coach coach=new Coach();
		coach.setCoachId(coachId);
		coach.setCoachType(coachTypeEntity);
		
		Route route=new Route();
		route.setRouteId(routeId);
		
		Booking booking=new Booking();
		booking.setRoute(route);
		booking.setTrain(train);
		booking.setCoach(coach);
		booking.setSeatNo(seatNo);
		booking.setDateOfJourney(dateOfJourney);
		booking.setDateOfBooking(Calendar.getInstance().getTime());
		booking.setSourceStn(bookingDTO.getBoardingStn());
		booking.setDestinationStn(bookingDTO.getDeBoardingStn());
		return booking;
	}
	
	
	public ObjectNode getBookingHistory(String passengerId) {
		ObjectNode responseJson = AppUtil.getObjectNodeInstance();

		try {
			List<Booking> bookingHistory = bookingDao.getBookingHistory(passengerId);
			responseJson.put("bookingHisList", AppUtil.parseEntityListToString(bookingHistory));
			responseJson.put(STATUS, SUCCESS);
		}catch(Exception e) {
			e.printStackTrace();
			responseJson.put(STATUS, FAIL);	
			responseJson.put(MESSAGE, e.getMessage());
		}
		return responseJson;
		
	}
	
	

}
