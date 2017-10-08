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
 * District generated by hbm2java
 */
@Entity
@Table(name = "DISTRICT", schema = "INDIAN_RAILWAYS")
public class District implements java.io.Serializable {

	private short districtId;
	private State state;
	private String districtName;
	private Set<Taluk> taluks = new HashSet<Taluk>(0);

	public District() {
	}

	public District(short districtId) {
		this.districtId = districtId;
	}

	public District(short districtId, State state, String districtName, Set<Taluk> taluks) {
		this.districtId = districtId;
		this.state = state;
		this.districtName = districtName;
		this.taluks = taluks;
	}

	@Id

	@Column(name = "DISTRICT_ID", unique = true, nullable = false, precision = 4, scale = 0)
	public short getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(short districtId) {
		this.districtId = districtId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATE_ID")
	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Column(name = "DISTRICT_NAME", length = 30)
	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
	public Set<Taluk> getTaluks() {
		return this.taluks;
	}

	public void setTaluks(Set<Taluk> taluks) {
		this.taluks = taluks;
	}

}
