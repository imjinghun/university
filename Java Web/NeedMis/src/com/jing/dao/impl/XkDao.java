package com.jing.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.jing.dao.IXkDao;
import com.jing.entity.Xk;

public class XkDao implements IXkDao
{
	//Ioc注入 sessionFactory
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Xk> getXkYi()
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from Xk where code like ?")//
				.setParameter(0, "%0000")//
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Xk> getXkEr(String Yiji)
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from Xk where code like ? and code!= ?")//
				.setParameter(0, Yiji+"%00")//
				.setParameter(1, Yiji+"0000")//
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Xk> getXkSan(String Erji)
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from Xk where code like ? and code!= ?")//
				.setParameter(0, Erji+"%")//
				.setParameter(1, Erji+"00")//
				.list();
	}
}
