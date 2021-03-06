package com.irc.entity;
// Generated 24 Dec, 2017 9:51:38 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * RouteStation generated by hbm2java
 */
@Entity
@Table(name = "ROUTE_STATION", schema = "INDIAN_RAILWAYS")
public class RouteStation implements java.io.Serializable {

	private long routeStationId;
	private Route route;
	private Station station;
	private Integer routeStnOrder;

	public RouteStation() {
	}

	public RouteStation(long routeStationId) {
		this.routeStationId = routeStationId;
	}

	public RouteStation(long routeStationId, Route route, Station station, Integer routeStnOrder) {
		this.routeStationId = routeStationId;
		this.route = route;
		this.station = station;
		this.routeStnOrder = routeStnOrder;
	}

	@Id

	@Column(name = "ROUTE_STATION_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getRouteStationId() {
		return this.routeStationId;
	}

	public void setRouteStationId(long routeStationId) {
		this.routeStationId = routeStationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROUTE_ID")
	@JsonManagedReference
	public Route getRoute() {
		return this.route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATION_ID")
	@JsonManagedReference
	public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Column(name = "ROUTE_STN_ORDER", precision = 5, scale = 0)
	public Integer getRouteStnOrder() {
		return this.routeStnOrder;
	}

	public void setRouteStnOrder(Integer routeStnOrder) {
		this.routeStnOrder = routeStnOrder;
	}

}
