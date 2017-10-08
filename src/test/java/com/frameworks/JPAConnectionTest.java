package com.frameworks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.irc.entity.SeatType;




public class JPAConnectionTest {

	@Test
	//@Ignore
	public void test() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("IndianRailways");
		Assert.assertNotNull("JPA container initialised succesfully..", entityManagerFactory);
		EntityManager em = entityManagerFactory.createEntityManager();
		   SeatType find = em.find(SeatType.class, new Long(1));
		   System.out.println(find.getSeatType());
	}

}
