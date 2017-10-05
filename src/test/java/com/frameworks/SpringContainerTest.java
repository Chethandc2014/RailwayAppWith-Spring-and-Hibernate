package com.frameworks;

import static org.junit.Assert.assertNotEquals;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContainerTest {

	@Test
	@Ignore
	public void test() {
		//fail("Not yet implemented");
		ApplicationContext apctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		SpringTestBean myBean = (SpringTestBean)apctx.getBean("test");
        System.out.println(myBean.getMessage());
        //assertNotEquals("Spring conainer started", null, myBean);
        Assert.assertNotNull("Spring conainer started successfully...", myBean);
	}

}
