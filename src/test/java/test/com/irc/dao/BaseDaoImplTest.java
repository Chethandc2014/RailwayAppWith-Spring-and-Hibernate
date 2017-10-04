package test.com.irc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.irc.controller.LoginController;
import com.irc.dao.BaseDaoImpl;
import com.irc.model.Passenger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath*:src/main/java/spring+hibernateProd.xml"})  
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager") 
@Configurable
public class BaseDaoImplTest  {

	/*@Autowired
	BaseDaoImpl baseDaoImpl;*/
	@Autowired
	LoginController loginController;
	
	@Test
	public void test() throws Exception {
		/*Passenger passenger=new Passenger();
		passenger.setPassengerId((short) 123);
		passenger.setPassengerName("Chethan");
		ApplicationContext appctx=new ClassPathXmlApplicationContext("spring+hibernateTest.xml");
		BaseDaoImpl baseDaoImpl = (BaseDaoImpl) appctx.getBean("baseDaoImpl");
		baseDaoImpl.create(passenger);
		 System.out.println("Record created successfully..");*/
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

}
