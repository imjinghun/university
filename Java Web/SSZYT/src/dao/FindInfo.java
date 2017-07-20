package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindInfo
{
	DBBean db=new DBBean();
	
	//判断用户名是否存在 返回空则不存在 否则返回 表名 主键名
	public String userExist(String username)
	{
		String user="";
		//分别从 学生 老师 管理员信息表查询
		String sql="select sid from student where sid='"+username+"'";
		String sql2="select tid from teacher where tid='"+username+"'";
		String sql3="select adminid from administrator where adminid='"+username+"'";
		ResultSet rs=db.executeQuery(sql);
		try
		{
			if(rs.next())
			{
				user="student sid";
			}
			else 
			{
				rs=db.executeQuery(sql2);
				if(rs.next())
				{
					user="teacher tid";
				}
				else
				{
					rs=db.executeQuery(sql3);
					if(rs.next())
					{
						user="administrator adminid";
					}
				}
			}
		} catch (SQLException e)
		{
			System.out.println("用户名是否存在异常");
		}
		return user;
	}
	
	//判断课程是否存在 
	public boolean isKcExist(String id)
	{
		boolean b=false;
		String sql="select tcid from tcourse where tcid='"+id+"'";
		ResultSet rs=db.executeQuery(sql);
		try
		{
			if(rs.next())
			{
				b=true;
			}
		} catch (SQLException e)
		{
			System.out.println("Dao包FindInfo中isKcExist方法查询错误");
		}
		return b;
	}

	// 判断学生是否已经加入此课程
	public boolean isAddCourse(String scid,String scsid)
	{
		boolean b = false;
		String sql = "select scid from scourse where scid='" + scid + "' and scsid='"+scsid+"'";
		ResultSet rs = db.executeQuery(sql);
		try
		{
			if (rs.next())
			{
				b = true;
			}
		} catch (SQLException e)
		{
			System.out.println("Dao包FindInfo中isAddCourse方法查询错误");
		}
		return b;
	}
	
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
