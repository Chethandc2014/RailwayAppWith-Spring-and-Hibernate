package com.irc.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irc.dao.SearchDao;
import com.irc.entity.Route;
import com.irc.entity.Train;

@Service
@Transactional
public class SearchService {

	@Autowired
	SearchDao searchDao;
	
	
	
	/**
	 * @param sourceStn
	 * @param destinationStn
	 * @param dateOfJourney
	 * @return
	 */
	
	public ArrayList<Train> getTrainForSourceAndDestinationStn(String sourceStn,String destinationStn,Date dateOfJourney){
		
	
		ArrayList<Short> routeList = getAllRoutesWithSourceStnLowerOrder(sourceStn,destinationStn);//Getting Routes...
		ArrayList<Train> trainList = getTrainsForRoute(routeList,dateOfJourney);//Getting Trains using Route and DateOfJourney...
		
		return trainList;
	}
	
	/**
	 * @param routeList
	 * @param dateOfJourney
	 * @return
	 */
	public ArrayList<Train> getTrainsForRoute(ArrayList<Short> routeList,Date dateOfJourney) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(dateOfJourney);
		int dayOfJourneyInWeek= instance.get(Calendar.DAY_OF_WEEK);
		ArrayList<Train> trainList = searchDao.getTrainsForRoute(routeList,dayOfJourneyInWeek);
		//checkTrainDaysOfOperation(trainList,dayOfJourneyInWeek);
		return trainList;
	}

	/**
	 * @param sourceStn
	 * @param destinationStn
	 * @return
	 */
	public ArrayList<Short>  getAllRoutesWithSourceStnLowerOrder(String sourceStn,String destinationStn){
	
		  ArrayList<Short> routeList=new ArrayList<Short>();
		  HashMap<Short, Integer> routesWithSourceStnOrder = searchDao.getRoutesWithStnOrder(sourceStn);
		  HashMap<Short, Integer> routesWithDestStnOrder2 = searchDao.getRoutesWithStnOrder(destinationStn);
		  
		  Iterator<Entry<Short, Integer>> sourceRouteiterator = routesWithSourceStnOrder.entrySet().iterator();
		  routesWithDestStnOrder2.keySet();
		
		 while(sourceRouteiterator.hasNext()) {
			
			 Entry<Short, Integer> next = sourceRouteiterator.next();
			 if(routesWithDestStnOrder2.containsKey(next.getKey())) {
				 if(next.getValue()<routesWithDestStnOrder2.get(next.getKey())) {//Checking sourceStb Order Id is< Destination then get the Routes..
					 routeList.add(next.getKey());
				 }
			 }
		 }
		  
		return routeList;
		
	}
	
	
	
}
