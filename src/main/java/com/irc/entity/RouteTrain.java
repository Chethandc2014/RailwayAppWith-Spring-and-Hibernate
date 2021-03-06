package com.irc.entity;
// Generated 25 Dec, 2017 4:39:11 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * RouteTrain generated by hbm2java
 */
@Entity
@Table(name = "ROUTE_TRAIN", schema = "INDIAN_RAILWAYS")
public class RouteTrain implements java.io.Serializable {

	private RouteTrainId id;
	private Route route;
	private Train train;
	private TrainWeeklySchedule trainWeeklySchedule;

	public RouteTrain() {
	}

	public RouteTrain(RouteTrainId id, Route route, Train train, TrainWeeklySchedule trainWeeklySchedule) {
		this.id = id;
		this.route = route;
		this.train = train;
		this.trainWeeklySchedule = trainWeeklySchedule;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "routeTrainId", column = @Column(name = "ROUTE_TRAIN_ID", nullable = false, precision = 5, scale = 0)),
			@AttributeOverride(name = "routeId", column = @Column(name = "ROUTE_ID", nullable = false, precision = 5, scale = 0)),
			@AttributeOverride(name = "trainId", column = @Column(name = "TRAIN_ID", nullable = false, precision = 5, scale = 0)),
			@AttributeOverride(name = "trainWeeklyScheduleId", column = @Column(name = "TRAIN_WEEKLY_SCHEDULE_ID", nullable = false, precision = 5, scale = 0)) })
	public RouteTrainId getId() {
		return this.id;
	}

	public void setId(RouteTrainId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROUTE_ID", nullable = false, insertable = false, updatable = false)
	@JsonManagedReference
	public Route getRoute() {
		return this.route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRAIN_ID", nullable = false, insertable = false, updatable = false)
	@JsonManagedReference
	public Train getTrain() {
		return this.train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRAIN_WEEKLY_SCHEDULE_ID", nullable = false, insertable = false, updatable = false)
	@JsonManagedReference
	public TrainWeeklySchedule getTrainWeeklySchedule() {
		return this.trainWeeklySchedule;
	}

	public void setTrainWeeklySchedule(TrainWeeklySchedule trainWeeklySchedule) {
		this.trainWeeklySchedule = trainWeeklySchedule;
	}

}
