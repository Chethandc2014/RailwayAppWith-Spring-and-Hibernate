package com.irc.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.irc.entity.Trains;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-Context.xml"})  
public class AdminDaoTest {

	@Autowired
	AdminDao adminDao;
	
	@Test
	@Transactional
	public void testAddTrain() throws Exception {
		Trains trn=new Trains();
		trn.setTrainId(1238);
		adminDao.addTrain(trn);
		
	}
	@Test()
	public void testDeletTrain() {
		try {
			adminDao.deleteTrain(1239);//this will not throw any exception if Entity is not there in  DB/// similar to DELERE  FROM TABLE_NAME WHERE COLUMN_NAME='VALUE' ==>RETURN 0 if no records found
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

}
