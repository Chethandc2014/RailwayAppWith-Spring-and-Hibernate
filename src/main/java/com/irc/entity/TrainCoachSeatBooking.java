package com.irc.entity;
// Generated 8 Oct, 2017 4:43:35 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TrainCoachSeatBooking generated by hbm2java
 */
@Entity
@Table(name = "TRAIN_COACH_SEAT_BOOKING", schema = "INDIAN_RAILWAYS")
public class TrainCoachSeatBooking implements java.io.Serializable {

	private long trainCoachSeatBookingId;
	private Trains trains;
	private Coach coach;
	private Integer seatTypeId;
	private Short seatNo;
	private Short pnrNo;

	public TrainCoachSeatBooking() {
	}

	public TrainCoachSeatBooking(long trainCoachSeatBookingId) {
		this.trainCoachSeatBookingId = trainCoachSeatBookingId;
	}

	public TrainCoachSeatBooking(long trainCoachSeatBookingId, Trains trains, Coach coach, Integer seatTypeId,
			Short seatNo, Short pnrNo) {
		this.trainCoachSeatBookingId = trainCoachSeatBookingId;
		this.trains = trains;
		this.coach = coach;
		this.seatTypeId = seatTypeId;
		this.seatNo = seatNo;
		this.pnrNo = pnrNo;
	}

	@Id

	@Column(name = "TRAIN_COACH_SEAT_BOOKING_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getTrainCoachSeatBookingId() {
		return this.trainCoachSeatBookingId;
	}

	public void setTrainCoachSeatBookingId(long trainCoachSeatBookingId) {
		this.trainCoachSeatBookingId = trainCoachSeatBookingId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRAIN_ID")
	public Trains getTrains() {
		return this.trains;
	}

	public void setTrains(Trains trains) {
		this.trains = trains;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COACH_ID")
	public Coach getCoach() {
		return this.coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	@Column(name = "SEAT_TYPE_ID", precision = 6, scale = 0)
	public Integer getSeatTypeId() {
		return this.seatTypeId;
	}

	public void setSeatTypeId(Integer seatTypeId) {
		this.seatTypeId = seatTypeId;
	}

	@Column(name = "SEAT_NO", precision = 4, scale = 0)
	public Short getSeatNo() {
		return this.seatNo;
	}

	public void setSeatNo(Short seatNo) {
		this.seatNo = seatNo;
	}

	@Column(name = "PNR_NO", precision = 4, scale = 0)
	public Short getPnrNo() {
		return this.pnrNo;
	}

	public void setPnrNo(Short pnrNo) {
		this.pnrNo = pnrNo;
	}

}
