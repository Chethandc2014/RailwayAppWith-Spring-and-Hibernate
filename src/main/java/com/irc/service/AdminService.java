package com.irc.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.irc.dao.AdminDao;
import com.irc.dto.TrainDto;
import com.irc.entity.Train;
import com.irc.util.AppUtil;

import static com.irc.constants.AppConstants.*;

import java.io.Serializable;

@Service
public class AdminService {
	
	@Autowired
	AdminDao adminDao;

	public ObjectNode addTrain(TrainDto trainDto) {
		ObjectNode response = AppUtil.getObjectNodeInstance();
		//JSONObject response=new JSONObject();
		Train train = null;
		try {
			train = convertTrainDtoToTrainEntity(trainDto);
			Serializable trainId = adminDao.addTrain(train);
			response.put(STATUS, SUCCESS);
			response.put("trainId", trainId.toString());
		} catch (Exception e) {
			e.printStackTrace();
			response.put(STATUS, FAIL);
			response.put(MESSAGE, e.getMessage());
		}
		return response;
	}


	public JSONObject updateTrain(TrainDto trainDto) {
		
		JSONObject response=new JSONObject();
		Train train = null;
		try {
			 train = convertTrainDtoToTrainEntity(trainDto);
			adminDao.updateTrain(train);
			response.put(STATUS, SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			response.put(STATUS, FAIL);
			response.put(MESSAGE, e.getMessage());
		}
		return response;
	}
	
	
	public JSONObject deleteTrain(String tainId) {
		JSONObject response=new JSONObject();
		
		try {
			adminDao.deleteTrain(Integer.parseInt(tainId));
			response.put(STATUS, SUCCESS);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.put(STATUS, FAIL);
			response.put(MESSAGE, "Invalid Train ID....");
		} catch (Exception e) {
			e.printStackTrace();
			response.put(STATUS, FAIL);
			response.put(MESSAGE, e.getMessage());
		}
		return response;
		
	}
	
	private Train convertTrainDtoToTrainEntity(TrainDto trainDto) {
		Train train=new Train();
		train.setTrainId(Short.valueOf(trainDto.getTrainId()));
		train.setTrainName(trainDto.getTrainName());
		train.setTrainModel(trainDto.getModel());
		return train;
	}


}
