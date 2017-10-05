package com.frameworks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.irc.model.SeatType;

public class HiebrnateContainerTest {

	/**
	 * 
	 */
	@Test
	@Ignore
	public void test() {
		// fail("Not yet implemented");
		Configuration configure = new Configuration().configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();
		SessionFactory sf = configure.buildSessionFactory(sr);
		// Assert.assertNotEquals("SessionFactoryCreated Succesfully..",null, sf);
		Assert.assertNotNull("SessionFactoryCreated Succesfully..", sf);
		System.out.println("Hibenate container initilised successfully..");
		// ServiceRegistoryBuilder is deprecated in Hibernate 4.3
		
		Session ses = sf.openSession();
	    SeatType type=(SeatType) ses.get(SeatType.class, new Long(1));
	    System.out.println(type.getSeatType());
	}

}
