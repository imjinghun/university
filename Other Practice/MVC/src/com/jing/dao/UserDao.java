package com.jing.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.jing.model.UserInfo;


public class UserDao
{
	//注入sessionFactory
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	//保存
	public String saveUser(UserInfo userInfo)
	{
		return (String) sessionFactory.getCurrentSession().save(userInfo);
	}
	
	//根据用户名查找
	public UserInfo getByname(String username)
	{
		UserInfo userInfo=(UserInfo) sessionFactory.getCurrentSession()//
				.get(UserInfo.class, username);
		return userInfo;
	}
	//根据用户名 密码查找
	public UserInfo getUser(UserInfo userInfo)
	{
		UserInfo user=(UserInfo)sessionFactory.getCurrentSession()//
				.createQuery("from UserInfo where username=? and password=?")//
				.setParameter(0, userInfo.getUsername())//
				.setParameter(1, userInfo.getPassword())//
				.uniqueResult();
		return user;
	}
}
