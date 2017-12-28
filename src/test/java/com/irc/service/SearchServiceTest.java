package com.irc.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-Context.xml" })
public class SearchServiceTest {

	@Autowired
	SearchService searchService;
	
	//@Test
	public void testGetAllRoutesWithSourceStnLowerOrder() {
		
		searchService.getAllRoutesWithSourceStnLowerOrder("TUMAKURU", "BENGALURU");
	}

	@Test
	public void testGetTrainsForRoute() {
		ArrayList<Short> routeIdList=new ArrayList<Short>();
		routeIdList.add((short) 1);
		routeIdList.add((short) 3);
		routeIdList.add((short)4);
		searchService.getTrainsForRoute(routeIdList, new Date());
	}
}
