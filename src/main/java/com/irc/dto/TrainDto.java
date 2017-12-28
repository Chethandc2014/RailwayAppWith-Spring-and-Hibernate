package com.irc.dto;

import java.io.Serializable;

public class TrainDto implements Serializable{

	String trainName;
	String trainId;
	String model;
	
	CoachDto coachesDto[];

	public String getTrainName() {
		return trainName;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public CoachDto[] getCoachesDto() {
		return coachesDto;
	}

	public void setCoachesDto(CoachDto[] coachesDto) {
		this.coachesDto = coachesDto;
	}
	
	
}
