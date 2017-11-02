package com.irc.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.irc.entity.Coach;
import com.irc.entity.Train;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-Context.xml"})  
public class AdminDaoTest {

	@Autowired
	AdminDao adminDao;
	
	@Test
	@Transactional
	public void testAddTrain() throws Exception {
		Train trn=new Train();
		trn.setTrainId((short) 1238);
		adminDao.addTrain(trn);
		
	}
	@Test()
	@Transactional
	public void testDeletTrain() {
		try {
			adminDao.deleteTrain(1239);//this will not throw any exception if Entity is not there in  DB/// similar to DELERE  FROM TABLE_NAME WHERE COLUMN_NAME='VALUE' ==>RETURN 0 if no records found
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
	
	@Test()
	@Transactional
	public void testAddCoachToTrain() {

		Train trn=new Train();
		trn.setTrainId((short)1238);
		//trn.seTra
		
		Coach coach=new Coach();
		coach.setCoachId((short)1);
		
	}

}
