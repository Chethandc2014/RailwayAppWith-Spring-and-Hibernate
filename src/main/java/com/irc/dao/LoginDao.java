package com.irc.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.irc.entity.Passenger;

@Repository
@Transactional
public class LoginDao  extends BaseDaoImpl{

	
	public Passenger login(Passenger passenger) throws Exception {

		Passenger passengerInfo = (Passenger) getEntityById(Passenger.class, passenger.getPassengerId());
		return passengerInfo;

	}

}
