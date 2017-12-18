package com.irc.entity;
// Generated 3 Nov, 2017 10:44:37 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SeatCharges generated by hbm2java
 */
@Entity
@Table(name = "SEAT_CHARGES", schema = "INDIAN_RAILWAYS")
public class SeatCharges implements java.io.Serializable {

	private short seatChargesId;
	private SeatType seatType;
	private short chargePerKm;
	private Short expCharges;
	private Short superFastCharges;

	public SeatCharges() {
	}

	public SeatCharges(short seatChargesId, SeatType seatType, short chargePerKm) {
		this.seatChargesId = seatChargesId;
		this.seatType = seatType;
		this.chargePerKm = chargePerKm;
	}

	public SeatCharges(short seatChargesId, SeatType seatType, short chargePerKm, Short expCharges,
			Short superFastCharges) {
		this.seatChargesId = seatChargesId;
		this.seatType = seatType;
		this.chargePerKm = chargePerKm;
		this.expCharges = expCharges;
		this.superFastCharges = superFastCharges;
	}

	@Id

	@Column(name = "SEAT_CHARGES_ID", unique = true, nullable = false, precision = 4, scale = 0)
	public short getSeatChargesId() {
		return this.seatChargesId;
	}

	public void setSeatChargesId(short seatChargesId) {
		this.seatChargesId = seatChargesId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEAT_TYPE_ID", nullable = false)
	public SeatType getSeatType() {
		return this.seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	@Column(name = "CHARGE_PER_KM", nullable = false, precision = 4, scale = 0)
	public short getChargePerKm() {
		return this.chargePerKm;
	}

	public void setChargePerKm(short chargePerKm) {
		this.chargePerKm = chargePerKm;
	}

	@Column(name = "EXP_CHARGES", precision = 4, scale = 0)
	public Short getExpCharges() {
		return this.expCharges;
	}

	public void setExpCharges(Short expCharges) {
		this.expCharges = expCharges;
	}

	@Column(name = "SUPER_FAST_CHARGES", precision = 4, scale = 0)
	public Short getSuperFastCharges() {
		return this.superFastCharges;
	}

	public void setSuperFastCharges(Short superFastCharges) {
		this.superFastCharges = superFastCharges;
	}

}
