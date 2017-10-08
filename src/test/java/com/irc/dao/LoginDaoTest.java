package com.irc.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.irc.entity.Passenger;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-Context.xml"}) 
@Transactional
public class LoginDaoTest {

	@Autowired
	LoginDao loginDao;
	
	@Test
	public void test() throws Exception {
		//fail("Not yet implemented");
		
		Passenger pass=new Passenger();
		pass.setPassengerId("TestUser");
		pass.setPassword("TestPass");
		Passenger login = loginDao.login(pass);
		Assert.assertNotNull("Login DAO is working fine...", login);
		System.out.println("User Name fetched From Login DAO--->"+login.getPassengerName());
		
	}

}
