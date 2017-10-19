package com.irc.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.irc.entity.SeatType;

import oracle.net.aso.g;

public class PSVM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("IndianRailways");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		SeatType find = em.find(SeatType.class, new Long(1));*/
		
		String json="{\"isLoginSuccess\":true,\"message\":\"User loged in succesfully.\"}";
		String parser="{\"isLoginSuccess\":true,\"message\":\"User loged in succesfully.\"}";
		
		String newRes="{\"isLoginSuccess\":true,\"message\":\"User loged in succesfully.\"}";
		String newS1="{\"isBokingSuccess\":true,\"bookingInfo\":\"sdfsdf\"}";
		org.json.JSONObject jsonObj=new JSONObject(newS1);
		System.out.println(jsonObj.toString());
		
		//Gson gson=new Gson();
		//gson.fr
		/*JsonParser jsonParser=new JsonParser();
		
		JsonElement parse = jsonParser.parse(parser);
		System.out.println(parse);*/
	}

}
