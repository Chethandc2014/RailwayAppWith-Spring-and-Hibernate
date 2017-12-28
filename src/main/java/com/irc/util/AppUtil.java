package com.irc.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class AppUtil {

	
	 public static <T extends Object> String parseEntityListToString(List<T> list){
			 
		   try {
				 
				ObjectMapper mapper = new ObjectMapper();
				 mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
				return mapper.writeValueAsString(list);//For Converting POJO to JSON..
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				return null;
			}
		 }
	
	 public static ObjectNode	getObjectNodeInstance() {
			 return new ObjectMapper().createObjectNode();
		 }
}
