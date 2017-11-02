package com.irc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BookingDao extends BaseDaoImpl{

	
	
	public void getBookingInfoByDateAndTrainID(int trainID,String coachType) {

		Session session = sf.getCurrentSession();
		Query query = session.createQuery("from Booking as booking where booking.train.trainId = :trainId and booking.coach.coachType.coachType = :coachType");
		query.setParameter("trainId",(short) trainID);
		query.setParameter("coachType", coachType);
		List list = query.list();
		System.out.println(list.toString());
	}
	
	
	public Object bookTicket() throws Exception {
	
		return null;
		
	}
	
	
	
}
