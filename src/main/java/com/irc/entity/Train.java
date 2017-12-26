package com.irc.entity;
// Generated 3 Nov, 2017 10:44:37 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Train generated by hbm2java
 */
@Entity
@Table(name = "TRAIN", schema = "INDIAN_RAILWAYS")
public class Train implements java.io.Serializable {

	private short trainId;
	private String trainModel;
	private String trainAvgSpeed;
	private String trainName;
	private Short coach1aTotal;
	private Short coach2aTotal;
	private Short coach3aTotal;
	private Short coachCcTotal;
	private Short coachSlTotal;
	private Short coach2sTotal;
	private Set<TrainStatus> trainStatuses = new HashSet<TrainStatus>(0);
	private Set<TrainSchedule> trainSchedules = new HashSet<TrainSchedule>(0);
	private Set<Booking> bookings = new HashSet<Booking>(0);
	private Set<Coach> coaches = new HashSet<Coach>(0);
	private Set<RouteTrain> routeTrains = new HashSet<RouteTrain>(0);

	public Train() {
	}

	public Train(short trainId) {
		this.trainId = trainId;
	}

	public Train(short trainId, String trainModel, String trainAvgSpeed, String trainName, Short coach1aTotal,
			Short coach2aTotal, Short coach3aTotal, Short coachCcTotal, Short coachSlTotal, Short coach2sTotal,
			Set<TrainStatus> trainStatuses, Set<TrainSchedule> trainSchedules, Set<Booking> bookings,
			Set<Coach> coaches) {
		this.trainId = trainId;
		this.trainModel = trainModel;
		this.trainAvgSpeed = trainAvgSpeed;
		this.trainName = trainName;
		this.coach1aTotal = coach1aTotal;
		this.coach2aTotal = coach2aTotal;
		this.coach3aTotal = coach3aTotal;
		this.coachCcTotal = coachCcTotal;
		this.coachSlTotal = coachSlTotal;
		this.coach2sTotal = coach2sTotal;
		this.trainStatuses = trainStatuses;
		this.trainSchedules = trainSchedules;
		this.bookings = bookings;
		this.coaches = coaches;
	}

	@Id

	@Column(name = "TRAIN_ID", unique = true, nullable = false, precision = 4, scale = 0)
	public short getTrainId() {
		return this.trainId;
	}

	public void setTrainId(short trainId) {
		this.trainId = trainId;
	}

	@Column(name = "TRAIN_MODEL", length = 30)
	public String getTrainModel() {
		return this.trainModel;
	}

	public void setTrainModel(String trainModel) {
		this.trainModel = trainModel;
	}

	@Column(name = "TRAIN_AVG_SPEED", length = 30)
	public String getTrainAvgSpeed() {
		return this.trainAvgSpeed;
	}

	public void setTrainAvgSpeed(String trainAvgSpeed) {
		this.trainAvgSpeed = trainAvgSpeed;
	}

	@Column(name = "TRAIN_NAME", length = 30)
	public String getTrainName() {
		return this.trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	@Column(name = "COACH_1A_TOTAL", precision = 3, scale = 0)
	public Short getCoach1aTotal() {
		return this.coach1aTotal;
	}

	public void setCoach1aTotal(Short coach1aTotal) {
		this.coach1aTotal = coach1aTotal;
	}

	@Column(name = "COACH_2A_TOTAL", precision = 3, scale = 0)
	public Short getCoach2aTotal() {
		return this.coach2aTotal;
	}

	public void setCoach2aTotal(Short coach2aTotal) {
		this.coach2aTotal = coach2aTotal;
	}

	@Column(name = "COACH_3A_TOTAL", precision = 3, scale = 0)
	public Short getCoach3aTotal() {
		return this.coach3aTotal;
	}

	public void setCoach3aTotal(Short coach3aTotal) {
		this.coach3aTotal = coach3aTotal;
	}

	@Column(name = "COACH_CC_TOTAL", precision = 3, scale = 0)
	public Short getCoachCcTotal() {
		return this.coachCcTotal;
	}

	public void setCoachCcTotal(Short coachCcTotal) {
		this.coachCcTotal = coachCcTotal;
	}

	@Column(name = "COACH_SL_TOTAL", precision = 3, scale = 0)
	public Short getCoachSlTotal() {
		return this.coachSlTotal;
	}

	public void setCoachSlTotal(Short coachSlTotal) {
		this.coachSlTotal = coachSlTotal;
	}

	@Column(name = "COACH_2S_TOTAL", precision = 4, scale = 0)
	public Short getCoach2sTotal() {
		return this.coach2sTotal;
	}

	public void setCoach2sTotal(Short coach2sTotal) {
		this.coach2sTotal = coach2sTotal;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "train")
	public Set<TrainStatus> getTrainStatuses() {
		return this.trainStatuses;
	}

	public void setTrainStatuses(Set<TrainStatus> trainStatuses) {
		this.trainStatuses = trainStatuses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "train")
	public Set<TrainSchedule> getTrainSchedules() {
		return this.trainSchedules;
	}

	public void setTrainSchedules(Set<TrainSchedule> trainSchedules) {
		this.trainSchedules = trainSchedules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "train")
	public Set<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "train")
	public Set<Coach> getCoaches() {
		return this.coaches;
	}

	public void setCoaches(Set<Coach> coaches) {
		this.coaches = coaches;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "train")
	public Set<RouteTrain> getRouteTrains() {
		return this.routeTrains;
	}

	public void setRouteTrains(Set<RouteTrain> routeTrains) {
		this.routeTrains = routeTrains;
	}

}
