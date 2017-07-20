package com.jing.service;

import com.jing.dao.UserDao;
import com.jing.model.UserInfo;

public class UserService
{
	private UserDao userDao;
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
	
	public String save(UserInfo userInfo)
	{
		String result="fail";
		if(userDao.saveUser(userInfo).equals(userInfo.getUsername())){
			result="success";
		}
		return result;
	}
	
}
