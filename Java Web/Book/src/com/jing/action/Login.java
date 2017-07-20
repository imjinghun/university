package com.jing.action;

import java.sql.ResultSet;

import com.jing.dao.DBBean;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport
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
			String sql="select password from UserInfo where username='"+u+"'";
			ResultSet rs=db.executeQuery(sql);
			try
			{
				if(rs.next())
				{
					if(p.equals(rs.getString(1)))
					{
						result="Success";
					}
					else
					{
						setMsg("密码错误!");
					}
				}
			} catch (Exception e)
			{
				setMsg("出错了!");
				return "Error";
			}
		}
		else
		{
			setMsg("用户不存在!");
		}
		return result;
	}
	
	
}
