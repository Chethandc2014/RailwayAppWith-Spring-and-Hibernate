package com.irc.model;
// Generated 2 Oct, 2017 8:28:59 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PassengerAddress generated by hbm2java
 */
@Entity
@Table(name = "PASSENGER_ADDRESS", schema = "INDIAN_RAILWAYS")
public class PassengerAddress implements java.io.Serializable {

	private short passengerAddressId;
	private Taluk taluk;
	private String houseNo;
	private String street;
	private Set<Passenger> passengers = new HashSet<Passenger>(0);

	public PassengerAddress() {
	}

	public PassengerAddress(short passengerAddressId) {
		this.passengerAddressId = passengerAddressId;
	}

	public PassengerAddress(short passengerAddressId, Taluk taluk, String houseNo, String street,
			Set<Passenger> passengers) {
		this.passengerAddressId = passengerAddressId;
		this.taluk = taluk;
		this.houseNo = houseNo;
		this.street = street;
		this.passengers = passengers;
	}

	@Id

	@Column(name = "PASSENGER_ADDRESS_ID", unique = true, nullable = false, precision = 4, scale = 0)
	public short getPassengerAddressId() {
		return this.passengerAddressId;
	}

	public void setPassengerAddressId(short passengerAddressId) {
		this.passengerAddressId = passengerAddressId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TALUK_ID")
	public Taluk getTaluk() {
		return this.taluk;
	}

	public void setTaluk(Taluk taluk) {
		this.taluk = taluk;
	}

	@Column(name = "HOUSE_NO", length = 20)
	public String getHouseNo() {
		return this.houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	@Column(name = "STREET", length = 20)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "passengerAddress")
	public Set<Passenger> getPassengers() {
		return this.passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

}
