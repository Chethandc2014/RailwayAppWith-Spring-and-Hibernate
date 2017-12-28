package com.irc.dao;

import static com.irc.constants.AppConstants.COACH_1A;
import static com.irc.constants.AppConstants.COACH_1A_TOTAL;
import static com.irc.constants.AppConstants.COACH_2A;
import static com.irc.constants.AppConstants.COACH_2A_TOTAL;
import static com.irc.constants.AppConstants.COACH_2S;
import static com.irc.constants.AppConstants.COACH_2S_TOTAL;
import static com.irc.constants.AppConstants.COACH_3A;
import static com.irc.constants.AppConstants.COACH_3A_TOTAL;
import static com.irc.constants.AppConstants.COACH_CC;
import static com.irc.constants.AppConstants.COACH_CC_TOTAL;
import static com.irc.constants.AppConstants.COACH_ID;
import static com.irc.constants.AppConstants.COACH_SL;
import static com.irc.constants.AppConstants.COACH_SL_TOTAL;
import static com.irc.constants.AppConstants.SEAT_NO;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.irc.dto.BookingDto;
import com.irc.entity.Booking;
import com.irc.entity.Coach;
import com.irc.entity.CoachSeatNotAvailableException;
import com.irc.entity.CoachType;
import com.irc.entity.Train;
import com.irc.exception.BookingNotAvailableException;
import com.irc.exception.TrainNotExistException;

@Repository
@Transactional
public class BookingDao extends BaseDaoImpl{


	
	
	/**
	 * @param booking
	 * @return
	 * @throws Exception
	 */
	public Booking bookTicket(Booking booking) throws Exception {
		
		Serializable id = (Serializable) create(booking);
		Booking successBookingInfo = (Booking) getEntityById(Booking.class, id);
		return successBookingInfo;
	}
	
	/**
	 * @param dateOfJourney
	 * @param routeId
	 * @param trainID
	 * @param coachId
	 * @return
	 * @throws CoachSeatNotAvailableException
	 */
	public short getBookingSeatNoByCoachId(Date dateOfJourney, int routeId, int trainID,short coachId) throws CoachSeatNotAvailableException {

	    	Query query = sf.getCurrentSession().createQuery("select max(booking.seatNo)+1 as seatNo from Booking as booking where "
														+ " booking.dateOfJourney = :dateOfJourney 	and "
														+ " booking.route.routeId = :routeId and "
														+ " booking.train.trainId = :trainId and "
														+ " booking.coach.coachId = :coachId ");
		
			query.setParameter("dateOfJourney", dateOfJourney);
			query.setParameter("routeId",(short)routeId);
			query.setParameter("trainId",(short)trainID);
			query.setParameter("coachId", coachId);
			List list = query.list();
		Integer availableSeatNo=(Integer)query.list().get(0);

		Coach coach= (Coach) getEntityById(Coach.class, coachId);
		Short coachseatCapacity = coach.getCoachType().getSeatCapacity();
		if(availableSeatNo==null){//First Seat of Coach..
			return 1;
		}else if(availableSeatNo.shortValue()<=coachseatCapacity.shortValue()) {
			return availableSeatNo.shortValue();
		}else {
			throw new CoachSeatNotAvailableException("Coach seats are full for coachId:"+coachId);
		}
	
	}
	
	
	/**
	 * @param dateOfJourney
	 * @param routeId
	 * @param trainID
	 * @param coachType
	 * @return
	 * @throws Exception
	 */
	public Map<String,Short> getActiveBookingCoachIdAndSeatNO(Date dateOfJourney, int routeId, int trainID, String coachType) throws Exception {

		Map<String,Short> map=new HashMap<String, Short>();
		
		try {
			
			Query query = sf.getCurrentSession().createQuery("select booking.coach.coachId,count(booking.seatNo) from Booking as booking where "
															+ " booking.dateOfJourney = :dateOfJourney 	and "
															+ " booking.route.routeId = :routeId and "
															+ " booking.train.trainId = :trainId and "
															+ " booking.coach.coachType.coachType = :coachType "
															+ " group by booking.coach.coachId "
															+ " order by booking.coach.coachId desc");
			  
			query.setParameter("dateOfJourney", dateOfJourney);
			query.setParameter("routeId", (short)routeId);
			query.setParameter("trainId",(short) trainID);
			query.setParameter("coachType", coachType);
			List list = query.list();
			if(list.size()>0) {
				Object []object = (Object[]) list.get(0);
			 Short currentCoachId=(Short) object[0];
			 Long  currentSeatNo=(Long)object[1];
			    map.put(COACH_ID, currentCoachId);//Short data depends on Number() Data type in DB column
				map.put(SEAT_NO, currentSeatNo.shortValue());
			}
			/*Object []object  = (Object[]) query.list().get(0);
			map.put(COACH_ID, (Short) object[0]);//Short data depends on Number() Data type in DB column
			map.put(SEAT_NO, (Long) object[1]);*/
		} catch (Exception e) {
			throw e;
		}
		return map;
	}
	
	
	/**
	 * @param clas
	 * @param taindId
	 * @return
	 */
	public boolean checkTrainIdExistInSystem(Class<Train> clas,int taindId) {
			
		      Object entityById = getEntityById(clas, Short.valueOf((short)taindId));//Train ID is expecting be in Short According DB
			  	if(entityById!=null){
			  		return true;
			  	}else {
			  		return false;
			  	}
   	}
	
	/**
	 * @param coachType
	 * @return
	 */
	public CoachType getCoachTypeEntity(String coachType) {

		  Query query = sf.getCurrentSession().createQuery("select coachType from CoachType as coachType where coachType.coachType = :coachType");
		  query.setParameter("coachType", coachType);
		  CoachType coachTypeEntity = (CoachType) query.list().get(0);
		  return coachTypeEntity;
	
	}
	
	/**
	 * @param dateOfJourney
	 * @param routeId
	 * @param trainID
	 * @param coachType
	 * @return
	 * @throws TrainNotExistException
	 * @throws BookingNotAvailableException
	 */
	public Short getNextCoachIDByDateRouteAndTrainId(Date dateOfJourney,int routeId,int trainID,String coachType) throws TrainNotExistException, BookingNotAvailableException  {

		 Short nextCoachId=null;
		 if(!checkTrainIdExistInSystem(Train.class,trainID)) {
			
			 throw new TrainNotExistException("No Train exist with TrainId:"+trainID);
		 }
		
		 String selectCoachFromBookingQuery="select booking.coach.coachId from Booking as booking where "
					+ " booking.dateOfJourney = :dateOfJourney 	and "
					+ " booking.route.routeId = :routeId and "
					+ " booking.train.trainId = :trainId and "
					+ " booking.coach.coachType.coachType = :coachType ";

		 Query query = sf.getCurrentSession().createQuery("select coach.coachId from Coach as coach where"
								+ " coach.coachType.coachType =:coachType and "
								+ " coach.train.trainId =:trainId and"
								+ " coach.coachId NOT IN ( "+selectCoachFromBookingQuery+" )"
								+ "	order by coach.coachId asc");
		 
				query.setParameter("dateOfJourney", dateOfJourney);
				query.setParameter("routeId",(short)routeId);
				query.setParameter("trainId",(short) trainID);
				query.setParameter("coachType", coachType);
		
			List list = query.list();
			if(list.size()>0) {
			return	nextCoachId =(Short) list.get(0);
			}else {
				throw new BookingNotAvailableException("Seats are not available for "+coachType);
			}
	
	}
	
	
	/**
	 * @param trainID
	 * @param coachType
	 * @return
	 */
	public Short getCoachIdByTrainIdAndCoachType(int trainID,String coachType) {
		Short coachId=null;
		String selectCoachFromBookingQuery="select booking.coach.coachId from Booking as booking where "
											+ " booking.dateOfJourney = :dateOfJourney 	and "
											+ " booking.route.routeId = :routeId and "
											+ " booking.train.trainId = :trainId and "
											+ " booking.coach.coachType.coachType = :coachType ";
		
		Query query = sf.getCurrentSession().createQuery("select coach.coachId from Coach as coach where"
														+ " coach.coachType.coachType =:coachType and "
														+ " coach.train.trainId =:trainID and"
														+ " coach.coachId NOT IN ( "+selectCoachFromBookingQuery+" )"
														+ "	order by coach.coachId asc");
		query.setParameter("coachType", coachType);
		query.setParameter("trainID", (short)trainID);
		List list = query.list();
		if(list.size()>0) {
			coachId =(Short) list.get(0);
		}
		return coachId;
	}
	
	
	/**
	 * @param coachType
	 * @return
	 */
	public Short getMaxSeatLimitForCoachByCoachType(String coachType) {

		Query query = sf.getCurrentSession().createQuery("select coachtype.seatCapacity from CoachType as coachtype where coachtype.coachType = ?");
			query.setParameter(0, coachType);
			Short seatLimit = (Short) query.list().get(0);//DB Row single value in Row hence...Short object
			return seatLimit;
			
	}
	
	
	/**
	 * @param dateOfJourneyStr
	 * @param routeId
	 * @param trainID
	 * @param coachType
	 * @return
	 * @throws Exception
	 */
	public List<Booking> getBookingListByDateRouteAndTrainID(String dateOfJourneyStr,int routeId,int trainID,String coachType) throws Exception {

		List<Booking> bookingList=null;
		try {
		
		Date dateOfJourney=null;
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			 dateOfJourney = format.parse(dateOfJourneyStr);
		} catch (ParseException e) {
			throw e;
		}
		Session session = sf.getCurrentSession();
		Query query = session.createQuery("from Booking as booking where booking.train.trainId = :trainId and booking.coach.coachType.coachType = :coachType"
				+ " and booking.dateOfJourney = :dateOfJourney and booking.route.routeId = :routeId");
		query.setParameter("dateOfJourney", dateOfJourney);
		query.setParameter("routeId",(short)routeId);
		query.setParameter("trainId",(short) trainID);
		query.setParameter("coachType", coachType);
		
		 bookingList = (List<Booking>)query.list();
		} catch (Exception e) {
		    throw e;
		}
		return bookingList;
	}
	
	
	/**
	 * @param pnrNo
	 * @return
	 * @throws Exception
	 */
	public Booking getBookingInfoByPnrNo(long pnrNo) throws Exception {
		List bookingList=null;
		try {
		
			Query query = sf.getCurrentSession().createQuery("from  Booking as booking where booking.pnrNo = :pnrNo");
			query.setParameter("pnrNo", pnrNo);
			bookingList = query.list();
		} catch (Exception e) {
			throw e;
		}
		return bookingList!=null && bookingList.size()>0?(Booking) bookingList.get(0):null;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Booking> getBookingHistory(String passengerId) throws Exception {
		List<Booking> bookingList=null;
		try {
			String pnrListStr = getAllpnrListForPassenger(passengerId);
			Query query = sf.getCurrentSession().createQuery("from Booking as booking where booking.pnrNo IN ("+pnrListStr+")");
			bookingList = (List<Booking>)query.list();
		} catch (Exception e) {
			throw e;
		}
		return bookingList;
		
	}
	
	
	public String getAllpnrListForPassenger(String passengerId) {
		
		Query query = sf.getCurrentSession().createQuery("select passHis.pnrNo from PassengerBookingHistory as passHis where passHis.passenger.passengerId = :passengerId");
		query.setParameter("passengerId", passengerId);
		StringBuilder pnrStr=new StringBuilder();
		List list =(List<Long>) query.list();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			pnrStr.append("'"+iterator.next().toString()+"',");
		}
		
		if(pnrStr.toString().endsWith(",")) {
			pnrStr=pnrStr.replace(pnrStr.length()-1, pnrStr.length(), "");
		}
		
		return pnrStr.toString();
	}
	
	
	
	
	
	
	
	
	
}
