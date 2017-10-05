package com.irc.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class LoginDao{

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
