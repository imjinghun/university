package com.jing.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.jing.dao.IGmDao;
import com.jing.entity.Gm;

public class GmDao implements IGmDao
{
	// Ioc注入 sessionFactory
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Gm> getGmMen()
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from Gm where code like ?")//
				.setParameter(0, "%0000")//
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gm> getGmDa(String Men)
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from Gm where code like ? and code!= ?")//
				.setParameter(0, Men+"%00")//
				.setParameter(1, Men+"0000")//
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gm> getGmZhong(String Da)
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from Gm where code like ? and code!= ?")//
				.setParameter(0, Da+"%")//
				.setParameter(1, Da+"00")//
				.list();
	}

}
