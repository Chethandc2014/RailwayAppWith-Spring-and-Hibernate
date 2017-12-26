package com.irc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.sql.DisjunctionFragment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.SystemPropertyUtils;

import com.irc.entity.Route;
import com.irc.entity.RouteTrain;
import com.irc.entity.RouteTrainId;
import com.irc.entity.Station;
import com.irc.entity.Train;
import com.irc.entity.TrainWeeklySchedule;

@Repository
public class SearchDao extends BaseDaoImpl{

	
	
	/**
	 * @param routeId
	 * @return
	 */
	@Transactional
	public ArrayList<Station> getStationsForRoute(int routeId) {
		
		//String hql="select route from Route route where route.routeId = :routeId";
		String hql="select routeStation.station from RouteStation as routeStation where routeStation.route.routeId = :routeId";
          Session session = sf.openSession();
          Query query = session.createQuery(hql);
          query.setParameter("routeId",(short) routeId);
          
          ArrayList list = (ArrayList<Station>)query.list();
          System.out.println(list);
		return list;
          
          
	}

	/**
	 * @param stn
	 * @return
	 */
	@Transactional
	public HashMap<Short, Integer> getRoutesWithStnOrder(String stn) {
		
		HashMap<Short, Integer> routeMap=new HashMap<Short, Integer>();
		String hql="select routeStation.route.routeId,routeStation.routeStnOrder from RouteStation as routeStation where routeStation.station.stationName= :stn";
		
		
		Session session = sf.openSession();
		Query query = session.createQuery(hql);
		
		query.setParameter("stn", stn);
		List list = query.list();
		
		System.out.println(list);
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			Object next[] = (Object[]) iterator.next();
			routeMap.put((Short)next[0], (Integer)next[1]);
		}
		return routeMap;
		
	}

	/**
	 * @param routeList
	 * @param DayOfJourney
	 * @return
	 */
	@Transactional
	public ArrayList<Train> getTrainsForRoute(ArrayList<Short> routeList,int DayOfJourney) {
	
		Session session = sf.openSession();
		
		//String hql="select routeTrain.train from RouteTrain as routeTrain where routeTrain.route.routeId in ";
		
		StringBuilder values=new StringBuilder("(");
		Iterator<Short> iterator = routeList.iterator();
		while(iterator.hasNext()) {
			values.append(iterator.next()+",");
		}
		if(",".equals(new Character(values.charAt(values.length()-1)).toString())) {
			values.replace(values.length()-1, values.length(), "");
		}
		values.append(")");
		if(!(values.toString().length()>2)) {//No values in List
			return null;
		}
		//Query query = session.createQuery(hql+values);
		//List trainList = query.list();	
		
		String hqlForTrainOperations="select routeTrain.route.routeId,routeTrain.train,routeTrain.trainWeeklySchedule from RouteTrain as routeTrain where routeTrain.route.routeId in ";
		
		Query query2 = session.createQuery(hqlForTrainOperations+values);
		
		List list = query2.list();
		Iterator iterator2 = list.iterator();
		ArrayList<Train> trainList=new ArrayList<Train>();
		while(iterator2.hasNext()) {
			Object next[] = (Object[]) iterator2.next();
			
			Short routeId = (Short) next[0];
			Train train=(Train)next[1];
			TrainWeeklySchedule schedule=(TrainWeeklySchedule) next[2];
			
			switch (DayOfJourney) {
			case 1:
				addToTrainList(schedule.getDaySunday(),train,trainList);
				break;
			case 2:
				addToTrainList(schedule.getDayMonday(),train,trainList);
				break;
			case 3:
				addToTrainList(schedule.getDayTuesday(),train,trainList);
				break;
			case 4:
				addToTrainList(schedule.getDayWednesday(),train,trainList);
				break;
			case 5:
				addToTrainList(schedule.getDayThursday(),train,trainList);
				break;
			case 6:
				addToTrainList(schedule.getDayFriday(),train,trainList);
				break;
			case 7:
				addToTrainList(schedule.getDaySaturday(),train,trainList);
				break;
			
			}
			
		}
		
		/*Criteria criteria = session.createCriteria(RouteTrainId.class);
		Disjunction disjunction=null;
		Object array[] = routeList.toArray();
		for(Object routeId:array) {//Imp
			SimpleExpression criterion= Restrictions.eq("routeId", routeId);
			 disjunction = Restrictions.or(criterion);
		}
		criteria.add(disjunction);*/
		return (ArrayList<Train>) trainList;
	}
	
	/**
	 * @param isDayPresent
	 * @param train
	 * @param list
	 */
	public void addToTrainList(boolean isDayPresent,Train train,ArrayList<Train> list) {
		if(isDayPresent) {
			list.add(train);
		}
	}

	
	
}
