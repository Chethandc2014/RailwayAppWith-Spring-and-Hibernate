package com.irc.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface BaseDao {

	/**
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public Object create(Object object) throws Exception;
	/**
	 * @param <T>
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public <T> Object getObjectbyId(Class<T> clas,Serializable id) throws Exception;
	
	/**
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public Object update(Object object) throws Exception;
	/**
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public void delete(Object object) throws Exception;
	/**
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public Object merge(Object object) throws Exception;
	
}
