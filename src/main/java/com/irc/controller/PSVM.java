package com.irc.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.irc.entity.SeatType;

public class PSVM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("IndianRailways");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		SeatType find = em.find(SeatType.class, new Long(1));
	}

}
