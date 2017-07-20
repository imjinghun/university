package com.jing.action;

import com.jing.dao.UserDao;
import com.jing.model.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<UserInfo>
{
	//注入dao
	private UserDao userDao;
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
	//封装数据
	private UserInfo userInfo=new UserInfo();
	@Override
	public UserInfo getModel()
	{
		return userInfo;
	}
	
	//注册
	public String register()
	{
		String result="failreg";
		if(userDao.getByname(userInfo.getUsername())!=null)
		{
			this.addFieldError("msg", "用户已存在");
			return result;
		}
		if(userDao.saveUser(userInfo).equals(userInfo.getUsername())){
			result="successreg";
		}
		return result;
	}
	
	//登录
	public String login()
	{
		String result="faillogin";
		if(userDao.getByname(userInfo.getUsername())==null)
		{
			this.addFieldError("msg", "用户不存在");
			return result;
		}
		else if(userDao.getUser(userInfo)==null)
		{
			this.addFieldError("msg", "密码不正确");
			return result;
		}
		else
		{
			result="successlogin";
		}
		return result;
	}
}
