package com.frameworks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.irc.model.SeatType;


public class SpringHibernateIntegrationTest {

	@Test
	public void test() {
		
	ApplicationContext appctx=new ClassPathXmlApplicationContext("spring+hibernateTest.xml");
	SessionFactory sf = (SessionFactory) appctx.getBean("sessionFactory");
	Assert.assertNotNull("Spring and Hibernate Integeated succesfully...", sf);
	System.out.println("Spring and Hibernate Integeation working succesfully...");
	Session ses = sf.openSession();
	SeatType type = (SeatType) ses.load(SeatType.class, new Long(1));
	System.out.println(type.getSeatType());
	}

}
