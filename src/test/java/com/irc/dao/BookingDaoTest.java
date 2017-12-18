package com.irc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.irc.entity.Booking;
import com.irc.entity.CoachType;
import com.irc.exception.BookingNotAvailableException;
import com.irc.exception.TrainNotExistException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-Context.xml"})  
public class BookingDaoTest {

	@Autowired
	BookingDao bookingDao;
	
	@Test
	public void testGetActiveBookingCoachIdAndSeatNoReturnObjectForValidInputs() throws ParseException, Exception {

		Map<String, Short> map = bookingDao.getActiveBookingCoachIdAndSeatNO(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2017"),1,1235, "1A");
		Assert.assertNotNull("Map contains coachId and MAx SeatNo", map);
	}
	
	@Test
	public void testGetCoachIdByTrainIdAndCoachType() {
		Short coachId = bookingDao.getCoachIdByTrainIdAndCoachType(1236, "1A");
		Assert.assertNotNull("CoachID by TrainID and CoachType...", coachId);
	}
	
	@Test
	public void testGetMaxSeatLimitForCoachByCoachType(){
		Short maxSeatLimit = bookingDao.getMaxSeatLimitForCoachByCoachType("1A");
		Assert.assertNotNull("MAX seatLimit for 1A CoachType..", maxSeatLimit);
	}
	
	@Test
	public void testGetNextCoachIDByDateRouteAndTrainIdRuturnNext1ACoachIdForValidInput() throws Exception {
		Short nextCoachId = bookingDao.getNextCoachIDByDateRouteAndTrainId(new SimpleDateFormat("dd/MM/yyyy").parse("09/11/2017") ,1,1236, "1A");
		Assert.assertNotNull("Next Coach Id...", nextCoachId);
		System.out.println(nextCoachId);
	}
	
	@Test
	public void testGetBookingSeatNoByCoachId() throws Exception {
		Short seatNo = bookingDao.getBookingSeatNoByCoachId(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2017") ,(short)1,(short)1235, (short)1);
		
	}
	
	@Test
	public void testGetNextCoachIDByDateRouteAndTrainIdRuturnNext2ACoachIdForValidInput() throws Exception {
		Short nextCoachId = bookingDao.getNextCoachIDByDateRouteAndTrainId(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2017") ,1,1235, "2A");
		Assert.assertNotNull("Next Coach Id...", nextCoachId);
		System.out.println(nextCoachId);
	}
	
	@Test
	public void testGetCoachTypeEntity() {
		CoachType coachTypeEntity = bookingDao.getCoachTypeEntity("1A");
		Assert.assertNotNull("CoachType Entity for 1A..", coachTypeEntity);
	}
	
	@Test
	public void testGetNextCoachIDByDateRouteAndTrainIdRuturnNext3ACoachIdForValidInput() throws Exception {
		Short nextCoachId = bookingDao.getNextCoachIDByDateRouteAndTrainId(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2017") ,1,1235, "3A");
		Assert.assertNotNull("Next Coach Id...", nextCoachId);
		System.out.println(nextCoachId);
	}
	
	@Test
	public void testGetNextCoachIDByDateRouteAndTrainIdRuturnNextCC_CoachIdForValidInput() throws Exception {
		Short nextCoachId = bookingDao.getNextCoachIDByDateRouteAndTrainId(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2017") ,1,1235, "CC");
		Assert.assertNotNull("Next Coach Id...", nextCoachId);
		System.out.println(nextCoachId);
	}
	
	@Test
	public void testGetNextCoachIDByDateRouteAndTrainIdRuturnNextSLCoachIdForValidInput() throws Exception {
		Short nextCoachId = bookingDao.getNextCoachIDByDateRouteAndTrainId(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2017") ,1,1235, "SL");
		Assert.assertNotNull("Next Coach Id...", nextCoachId);
		System.out.println(nextCoachId);
	}
	
	@Test
	public void testGetNextCoachIDByDateRouteAndTrainIdRuturnNext2SCoachIdForValidInput() throws Exception {
		Short nextCoachId = bookingDao.getNextCoachIDByDateRouteAndTrainId(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2017") ,1,1235, "2S");
		Assert.assertNotNull("Next Coach Id...", nextCoachId);
		System.out.println(nextCoachId);
	}
	
	@Test(expected=TrainNotExistException.class)
	public void testGetNextCoachIDByDateRouteAndTrainIdThrowsTrainNotExistException() throws Exception {
		 bookingDao.getNextCoachIDByDateRouteAndTrainId(new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2017") ,1,0, "1A"); //Pass TrainID Not exist In System..
	}
	
	@Test(expected=BookingNotAvailableException.class)
	public void testGetNextCoachIDByDateRouteAndTrainIdThrowsBookingNotAvailableException() throws Exception {
		Short nextCoachId = bookingDao.getNextCoachIDByDateRouteAndTrainId(new SimpleDateFormat("dd/MM/yyyy").parse("09/11/2017") ,1,1236, "1A");
		Assert.assertNotNull("Next Coach Id...", nextCoachId);
		System.out.println(nextCoachId);
	}
	
	
	@Test
	public void testGetBookingInfoByDateAndTrainIDRturnObjectForValidInput() throws Exception {
		List<Booking> bookingList = bookingDao.getBookingListByDateRouteAndTrainID("03/11/2017 17:23:00",1,1235, "1A");
		Assert.assertNotNull("Booking List for Valid Inputs...", bookingList);
	}
	
	@Test
	public void testGetBookingInfoByDateAndTrainIDReturnEmptyListlForValidInputNotInDB() throws Exception {
		List<Booking> bookingList = bookingDao.getBookingListByDateRouteAndTrainID("03/11/2017 17:23:00",1,1235, "1Z");
	
		Assert.assertEquals("Booking Empty List for Valid Input but No Data in DB..", 0,bookingList.size());
	}
	
	
	@Test(expected=ParseException.class)
	public void testGetBookingInfoByDateAndTrainIDThrowsExeptionForInvalidInput() throws Exception {
		bookingDao.getBookingListByDateRouteAndTrainID("03/11/2017fs 17:23:00",1,1235, "1A"); //In correct Date
	}
	
	@Test
	public void testGetBookingInfoByPnrNoReurnValidObjectForValidInput() throws Exception {
		Booking bookingPnr = bookingDao.getBookingInfoByPnrNo(12351103112017l);
		Assert.assertNotNull("Booking Info by PNR for Valide Input..", bookingPnr);
	}
	
	@Test
	public void testGetBookingInfoByPnrNoReurnNullForInvalideOrNonExistenceValue() throws Exception{
		Booking bookingPnr = bookingDao.getBookingInfoByPnrNo(0l);
		Assert.assertNull("Booking Info by PNR for Non Existance Value..",bookingPnr);
	}
	
}
