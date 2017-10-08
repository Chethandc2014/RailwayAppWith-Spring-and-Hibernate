package com.irc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.irc.controller.LoginController;
import com.irc.dao.BaseDaoImpl;
import com.irc.dao.LoginDao;
import com.irc.entity.Passenger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-Context.xml"})  
@Transactional
public class BaseDaoImplTest  {

	/*@Autowired
	BaseDao baseDao;*/
	@Autowired@Qualifier("baseDaoImpl")
	BaseDao baseDao;
	
	/*@Autowired
	LoginController loginController;
	*/
	@Autowired
	LoginDao loginDao;
	
	@Test
	public void test() throws Exception {
		//System.out.println("Loging DAO Reference:"+loginDao.getName());
		Passenger passenger=new Passenger();
		passenger.setPassengerId("TestUser");
		passenger.setPassengerName("Chethan");
		passenger.setPassword("TestPass");
		/*ApplicationContext appctx=new ClassPathXmlApplicationContext("spring+hibernateTest.xml");
		BaseDaoImpl baseDaoImpl = (BaseDaoImpl) appctx.getBean("baseDaoImpl");*/
		/*baseDao.create(passenger);*/
		baseDao.create(passenger);
		 System.out.println("Record created successfully..");
	}
	/*public void setBaseDaoImpl(BaseDaoImpl baseDaoImpl) {
		this.baseDaoImpl = baseDaoImpl;
	}
*/

}
