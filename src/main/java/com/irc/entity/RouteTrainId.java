package com.irc.entity;
// Generated 25 Dec, 2017 4:39:11 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RouteTrainId generated by hbm2java
 */
@Embeddable
public class RouteTrainId implements java.io.Serializable {

	private int routeTrainId;
	private int routeId;
	private int trainId;
	private int trainWeeklyScheduleId;

	public RouteTrainId() {
	}

	public RouteTrainId(int routeTrainId, int routeId, int trainId, int trainWeeklyScheduleId) {
		this.routeTrainId = routeTrainId;
		this.routeId = routeId;
		this.trainId = trainId;
		this.trainWeeklyScheduleId = trainWeeklyScheduleId;
	}

	@Column(name = "ROUTE_TRAIN_ID", nullable = false, precision = 5, scale = 0)
	public int getRouteTrainId() {
		return this.routeTrainId;
	}

	public void setRouteTrainId(int routeTrainId) {
		this.routeTrainId = routeTrainId;
	}

	@Column(name = "ROUTE_ID", nullable = false, precision = 5, scale = 0)
	public int getRouteId() {
		return this.routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	@Column(name = "TRAIN_ID", nullable = false, precision = 5, scale = 0)
	public int getTrainId() {
		return this.trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	@Column(name = "TRAIN_WEEKLY_SCHEDULE_ID", nullable = false, precision = 5, scale = 0)
	public int getTrainWeeklyScheduleId() {
		return this.trainWeeklyScheduleId;
	}

	public void setTrainWeeklyScheduleId(int trainWeeklyScheduleId) {
		this.trainWeeklyScheduleId = trainWeeklyScheduleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RouteTrainId))
			return false;
		RouteTrainId castOther = (RouteTrainId) other;

		return (this.getRouteTrainId() == castOther.getRouteTrainId()) && (this.getRouteId() == castOther.getRouteId())
				&& (this.getTrainId() == castOther.getTrainId())
				&& (this.getTrainWeeklyScheduleId() == castOther.getTrainWeeklyScheduleId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getRouteTrainId();
		result = 37 * result + this.getRouteId();
		result = 37 * result + this.getTrainId();
		result = 37 * result + this.getTrainWeeklyScheduleId();
		return result;
	}

}
