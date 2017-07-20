package com.jing.action;

import com.jing.dao.DBBean;
import com.opensymphony.xwork2.ActionSupport;

public class BookAdd extends ActionSupport
{
	DBBean db=new DBBean();
	private String id = "";
	private String name = "";
	private String isbn = "";
	private String msg = "";
	
	
	public String getId()
	{
		return id;
	}


	public void setId(String id)
	{
		this.id = id;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String getIsbn()
	{
		return isbn;
	}


	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
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
		try
		{
			String strSql = "insert into BookInfo values('" + getId() + "','" + getName() +"','" + getIsbn() + "')";    
			int i=db.executeUpdate(strSql);
			if(i==0)
			{
				setMsg("书号重复，添加失败");
				return "Error";
			}
		}
		catch (Exception e) 
		{
			setMsg("添加失败!");
			return "Error";
		}
		
		return "Success";
	}
		
}
