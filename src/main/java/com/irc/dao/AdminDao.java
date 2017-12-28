package com.irc.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.irc.entity.Coach;
import com.irc.entity.Station;
import com.irc.entity.Train;

@Repository
@Transactional
public class AdminDao extends BaseDaoImpl{

	public Serializable addTrain(Train train) throws Exception {
	
		return (Serializable)create(train);
	}
	
	public void updateTrain(Train trainId) throws Exception {
		update(trainId);
	}

	public void deleteTrain(int trainId) throws Exception {
		Train train = new Train();
		train.setTrainId((short) trainId);
		delete(train);
	}

	public void addCoachToTrain(Coach coach) throws Exception {

			create(coach);
	}

	public void removeCoachFromTrain(int coachId) throws Exception {

		Coach coach = new Coach();
		coach.setCoachId((short) coachId);
		delete(coach);
	}

	public void addStation(Station station) throws Exception {

		create(station);
		
	}

	public void deleteStation(int stationId) throws Exception {

		Station stn=new Station();
		stn.setStationId((short) stationId);
		delete(stn);
	}

}
