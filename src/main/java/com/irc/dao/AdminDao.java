package com.irc.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.irc.entity.Coach;
import com.irc.entity.Station;
import com.irc.entity.Trains;

@Repository
@Transactional
public class AdminDao extends BaseDaoImpl{

	public void addTrain(Trains train) throws Exception {
	
		create(train);
	}

	public void deleteTrain(int trainId) throws Exception {
		Trains trains = new Trains();
		trains.setTrainId(trainId);
		delete(trains);
	}

	public void addCoachToTrain(Coach coach) throws Exception {

			create(coach);
	}

	public void removeCoachFromTrain(int coachId) throws Exception {

		Coach coach = new Coach();
		coach.setCoachId(coachId);
		delete(coach);
	}

	public void addStation(Station station) throws Exception {

		create(station);
		
	}

	public void deleteStation(int stationId) throws Exception {

		Station stn=new Station();
		stn.setStationId(stationId);
		delete(stn);
	}

}
