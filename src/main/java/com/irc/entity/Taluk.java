package com.irc.entity;
// Generated 8 Oct, 2017 4:43:35 PM by Hibernate Tools 4.3.5.Final

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
 * Taluk generated by hbm2java
 */
@Entity
@Table(name = "TALUK", schema = "INDIAN_RAILWAYS")
public class Taluk implements java.io.Serializable {

	private short talukId;
	private District district;
	private String talukName;
	private Set<PassengerAddress> passengerAddresses = new HashSet<PassengerAddress>(0);

	public Taluk() {
	}

	public Taluk(short talukId) {
		this.talukId = talukId;
	}

	public Taluk(short talukId, District district, String talukName, Set<PassengerAddress> passengerAddresses) {
		this.talukId = talukId;
		this.district = district;
		this.talukName = talukName;
		this.passengerAddresses = passengerAddresses;
	}

	@Id

	@Column(name = "TALUK_ID", unique = true, nullable = false, precision = 4, scale = 0)
	public short getTalukId() {
		return this.talukId;
	}

	public void setTalukId(short talukId) {
		this.talukId = talukId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID")
	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@Column(name = "TALUK_NAME", length = 20)
	public String getTalukName() {
		return this.talukName;
	}

	public void setTalukName(String talukName) {
		this.talukName = talukName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taluk")
	public Set<PassengerAddress> getPassengerAddresses() {
		return this.passengerAddresses;
	}

	public void setPassengerAddresses(Set<PassengerAddress> passengerAddresses) {
		this.passengerAddresses = passengerAddresses;
	}

}
