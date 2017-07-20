package com.jing.action;

import com.jing.dao.DBBean;
import com.opensymphony.xwork2.ActionSupport;

public class register extends ActionSupport
{
	DBBean db=new DBBean();
	
	private String username;
	private String password;
	private String msg = "";
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	@Override
	public String execute() throws Exception
	{
		String result="Error";
		String u,p;
		u=getUsername();
		p=getPassword();
		boolean b=db.userExist(u);
		if(b==true)
		{
			setMsg("用户已存在!");
		}
		else
		{
			String sql="insert into UserInfo values('"+u+"','"+p+"')";
			try
			{
				int i=db.executeUpdate(sql);
				if(i==0)
				{
					setMsg("注册失败!");
				}
				else
				{
					result="Success";
				}
			} catch (Exception e)
			{
				setMsg("出错!");
			}
			
		}
		return result;
	}
	
	
}
