package com.irc.dto;

import java.io.Serializable;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class JsonResponseWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JsonResponseWrapper createResponseWrapper(String jsonStr) {
		JsonResponseWrapper jsonResponseWrapper = new JsonResponseWrapper();
		jsonResponseWrapper.setResponse(jsonStr);
		return jsonResponseWrapper;
	}

    //@JsonRawValue
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	
}
