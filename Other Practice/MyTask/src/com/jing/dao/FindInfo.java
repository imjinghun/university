package com.jing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindInfo
{
	DBBean db=new DBBean();
	//根据作业号 查找此作业下是否有留言
	public boolean isMsgExist(String id)
	{
		boolean b=false;
		String sql="select mid from message where mhid='"+id+"'";
		ResultSet rs=db.executeQuery(sql);
		try
		{
			if(rs.next())
			{
				b=true;
			}
		} catch (SQLException e)
		{
			System.out.println("Dao包FindInfo中isMsgExist方法查询错误");
		}
		return b;
	}
}
