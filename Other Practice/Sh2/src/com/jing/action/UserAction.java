package com.jing.action;

import com.jing.dao.UserDao;
import com.jing.model.UserInfo;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport
{
	
	private UserInfo user=new UserInfo();
	private UserDao ud=new UserDao();
	
	public UserInfo getUser()
	{
		return user;
	}

	public void setUser(UserInfo user)
	{
		this.user = user;
	}

	@Override
	public String execute() throws Exception
	{
		//System.out.println(user.getUsername()+"用户名密码"+user.getPassword());
		
		int i=ud.saveUser(user);
		if(i==0)
		{
			return "fail";
		}
		else
		{
			return "success";
		}
	}
	
}
