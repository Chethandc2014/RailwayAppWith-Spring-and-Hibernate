package com.irc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.irc.dao.ApplicationDao;
import com.irc.entity.District;
import com.irc.entity.State;
import com.irc.entity.Taluk;
import com.irc.util.AppUtil;
import static com.irc.constants.AppConstants.*;

@Service
@Transactional
public class ApplicationService {


	@Autowired
	ApplicationDao applicationDao;

	public ObjectNode getStates() {
		ObjectNode response = AppUtil.getObjectNodeInstance();
		
		try {
			List<State> states = applicationDao.getStates();
			response.put("stateList",AppUtil.parseEntityListToString(states));
			response.put(STATUS, SUCCESS);
		}catch(Exception e) {
			response.put(STATUS, FAIL);
			response.put(MESSAGE, e.getMessage());
		}
		
		return response;
	}

	public ObjectNode getDistrictsByStateId(String stateId) {
		ObjectNode response = AppUtil.getObjectNodeInstance();
		try {
			
			List<District> districtList = applicationDao.getDistrictsByStateId(stateId);
			response.put("stateList",AppUtil.parseEntityListToString(districtList));
			response.put(STATUS, SUCCESS);
		}catch(Exception e) {
			response.put(STATUS, FAIL);
			response.put(MESSAGE, e.getMessage());
		}
		return response;
		
	}

	public ObjectNode getTaluksByDistrictId(String districtId) {
		ObjectNode response = AppUtil.getObjectNodeInstance();
		
		try {
			
			List<Taluk> talukList = applicationDao.getTaluksByDistrictId(districtId);
			response.put("stateList",AppUtil.parseEntityListToString(talukList));
			response.put(STATUS, SUCCESS);
		}catch(Exception e) {
			response.put(STATUS, FAIL);
			response.put(MESSAGE, e.getMessage());
		}
		
		return response;
	}

}
