package com.irc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.JSONObject;
import org.omg.CORBA.TIMEOUT;
import org.springframework.util.SystemPropertyUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.irc.entity.SeatType;

import oracle.net.aso.g;

public class PSVM {

	public static void main(String[] args) throws ParseException {
		
		Integer i=12;
		Long l=i.longValue();
		
		// TODO Auto-generated method stub
		/*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("IndianRailways");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		SeatType find = em.find(SeatType.class, new Long(1));*/
		
		/*String json="{\"isLoginSuccess\":true,\"message\":\"User loged in succesfully.\"}";
		String parser="{\"isLoginSuccess\":true,\"message\":\"User loged in succesfully.\"}";
		
		String newRes="{\"isLoginSuccess\":true,\"message\":\"User loged in succesfully.\"}";
		String newS1="{\"isBokingSuccess\":true,\"bookingInfo\":\"sdfsdf\"}";
		org.json.JSONObject jsonObj=new JSONObject(newS1);
		System.out.println(jsonObj.toString());*/
		
		//Short s=4;
		//Integer i=43;
		//Short s=(Short)i;
		//i=(Integer)s;
		/*int i=1;
		short s=32;
		i=(short) s;
		System.out.println(s);*/
		/*Integer i=1;
		short shortValue = i.shortValue();
		System.out.println(shortValue);*/
		/*Date time = Calendar.getInstance().getTime();
		System.out.println(time);*/
		/*SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date parse = dateFormat.parse("03/11/2017 09:20:30");
		System.out.println(parse);
*/		
		//Gson gson=new Gson();
		//gson.fr
		/*JsonParser jsonParser=new JsonParser();
		
		JsonElement parse = jsonParser.parse(parser);
		System.out.println(parse);*/
	}

}
