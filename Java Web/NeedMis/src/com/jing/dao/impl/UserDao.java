package com.jing.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.jing.dao.IUserDao;
import com.jing.entity.UserInfo;

public class UserDao implements IUserDao{

	//IOC容器注入 sessionFactory 对象
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//根据主键查询 查看用户是否存在
	@Override
	public UserInfo getUser(UserInfo userInfo)
	{
		return (UserInfo)sessionFactory.getCurrentSession()//
				.get(UserInfo.class, userInfo.getUsername());
	}
	@Override
	public UserInfo findById(String username)
	{
		return (UserInfo)sessionFactory.getCurrentSession()//
				.get(UserInfo.class, username);
	}
	//根据用户名 和 密码 验证用户身份
	@Override
	public UserInfo findByUser(UserInfo userInfo)
	{
		return (UserInfo) sessionFactory.getCurrentSession()//
		.createQuery("from UserInfo where username=? and password=?")//
		.setString(0, userInfo.getUsername())//
		.setString(1, userInfo.getPassword())//
		.uniqueResult();
	}
	//保存用户
	@Override
	public void save(UserInfo userInfo)
	{
		sessionFactory.getCurrentSession().save(userInfo);
	}
	//更新用户信息
	@Override
	public void update(UserInfo userInfo)
	{
		sessionFactory.getCurrentSession().update(userInfo);
	}
	@Override
	public void delete(UserInfo userInfo)
	{
		sessionFactory.getCurrentSession().delete(userInfo);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> getUser()
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from UserInfo where powers =?")//
				.setString(0, "users")//
				.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> getMgt()
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from UserInfo where powers =?")//
				.setString(0, "mgt")//
				.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> getAssessor()
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from UserInfo where powers =?")//
				.setString(0, "assessor")//
				.list();
	}
	

}
