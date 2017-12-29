package com.irc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.irc.entity.District;
import com.irc.entity.State;
import com.irc.entity.Taluk;


@Repository
@Transactional
public class ApplicationDao extends BaseDaoImpl{

	
	public List<State> getStates() {
		List<State> stateList=null;
		Criteria criteria = sf.getCurrentSession().createCriteria(State.class);
		stateList = criteria.list();
		return stateList;
	}

	public List<District> getDistrictsByStateId(String stateId) {
		List<District> districtList = null;
		
		Query query = sf.getCurrentSession().createQuery("select district from District as district where district.state.stateId =:stateId ");
		query.setParameter("stateId", Short.valueOf(stateId));
		districtList = query.list();
		return districtList;
		
	}

	public List<Taluk> getTaluksByDistrictId(String districtId) {
		List<Taluk> talukList=null;
		Query query = sf.getCurrentSession().createQuery("select taluk from Taluk as taluk where taluk.district.districtId =:districtId");
		query.setParameter("districtId", Short.valueOf(districtId));
		talukList = query.list();
		return talukList;
	}

	
	
	
	
}
