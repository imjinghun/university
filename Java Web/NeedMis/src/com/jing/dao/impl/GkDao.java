package com.jing.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.jing.dao.IGkDao;
import com.jing.entity.Gk;

public class GkDao implements IGkDao
{
	// Ioc注入 sessionFactory
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gk> getGk()
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from Gk")//
				.list();
	}

}
