package com.jing.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jing.common.HibernateSessionFactory;
import com.jing.model.UserInfo;

public class UserDao
{
	public int saveUser(UserInfo user)
	{
		int num=0;
		Session session=null;
		Transaction trasaction=null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			num=Integer.parseInt(session.save(user).toString());
			trasaction.commit();
		}
		catch (Exception e) {
			num=0;
			e.printStackTrace();
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
		
		return num;
	}
}
