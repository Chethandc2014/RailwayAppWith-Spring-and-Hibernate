package com.irc.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.irc.entity.District;
import com.irc.entity.State;
import com.irc.entity.Taluk;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-Context.xml"})  
public class ApplcationDaoTest {

	@Autowired
	ApplicationDao applicationDao;
	
	//@Test
	public void testGetStates() {
		
		List<State> states = applicationDao.getStates();
		Assert.assertNotNull("Getting States..", states);
		
	}
	
	//@Test
	public void testGetDistrictsByStateId() {
		
		List<District> districtsList= applicationDao.getDistrictsByStateId("1");
		Assert.assertNotNull("Getting Districs..", districtsList);
		
	}

	
	@Test
	public void testGetTaluksByDistrictId() {
		
		List<Taluk> talukList= applicationDao.getTaluksByDistrictId("1");
		Assert.assertNotNull("Getting Districs..", talukList);
		
	}
}
