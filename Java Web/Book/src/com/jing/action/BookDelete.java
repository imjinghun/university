package com.jing.action;

import com.jing.dao.DBBean;
import com.opensymphony.xwork2.ActionSupport;

public class BookDelete extends ActionSupport
{
	DBBean db=new DBBean();
	private String id = "";

	
	public String getId()
	{
		return id;
	}


	public void setId(String id)
	{
		this.id = id;
	}
	private String msg="";
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
			String strSql = "delete from BookInfo where id='" + getId() + "'";    
			int i=db.executeUpdate(strSql);
			if(i==0)
			{
				setMsg("删除失败");
				return "Error";
			}
		}
		catch (Exception e) 
		{
			return "Error";
		}
				
		return "Success";
	}
	
	

}
