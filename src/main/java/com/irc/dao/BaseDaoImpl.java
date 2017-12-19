package com.irc.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ADMIN
 *
 */
@Repository
public class BaseDaoImpl implements BaseDao {

	    @Autowired
	 SessionFactory sf;
		
		@Transactional
		public Object create(Object object) throws Exception {
	
			try {
				Session session = sf.getCurrentSession();
				 Serializable id = session.save(object);
				 
				 return id;
			} catch (Exception e) {
				throw new Exception("Exception got while adding object", e);
			}
			
		}
		
		@Transactional
		public <T>  Object getEntityById(Class<T> clas, Serializable id)  {
				Session session = sf.getCurrentSession();
				return session.get(clas, id);
			
		}
		
		@Transactional
		public Object merge(Object object) throws Exception {
			try {
				Session session = sf.getCurrentSession();
				session.merge(object);
			} catch (Exception e) {
				throw new Exception("Exception got while merging object", e);
			}
			return null;
		}
	
		@Transactional
		public Object update(Object object) throws Exception {
	
			try {
	
				Session session = sf.getCurrentSession();
				session.update(object);
			} catch (Exception e) {
				throw new Exception("Exception got while updating object", e);
			}
			return null;
		}
	
		@Transactional
		public void delete(Object object) throws Exception {
			try {
				Session session = sf.getCurrentSession();
				 session.delete(object);
			} catch (Exception e) {
				throw new Exception("Exception got while delete object", e);
			}
			
		}

		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}
	
		

		

		

}
