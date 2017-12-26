package com.irc.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-Context.xml"})
public class SearchDaoTest {

	
	@Autowired
	SearchDao searchDao;
	
	
	//@Test
	public void testGetStationsForRoute() {
		searchDao.getStationsForRoute(1);
	}
	
	@Test
	public void testGetRoutesWithStnOrder() {

		searchDao.getRoutesWithStnOrder("TUMAKURU");
	}

}
