package com.irc.dto;

import java.io.Serializable;

public class BookingDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 610717802082333615L;
	
	private String trainNo;
	private String coachId;
	private String coachType;
	private String routeId;
	private String seatType;
	private String dateOfJourney;
	private String dateOfBooking;
	private String boardingStn;
	private String deBoardingStn;

	public String getTrainNo() {
		return trainNo;
	}

	public String getBoardingStn() {
		return boardingStn;
	}

	public void setBoardingStn(String boardingStn) {
		this.boardingStn = boardingStn;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getDeBoardingStn() {
		return deBoardingStn;
	}

	public void setDeBoardingStn(String deBoardingStn) {
		this.deBoardingStn = deBoardingStn;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	public String getCoachId() {
		return coachId;
	}

	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}

	public String getCoachType() {
		return coachType;
	}

	public void setCoachType(String coachType) {
		this.coachType = coachType;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(String dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

}
