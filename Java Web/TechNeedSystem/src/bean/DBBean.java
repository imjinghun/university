package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBBean {
	private String driverStr = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String connStr = "jdbc:sqlserver://localhost:1433; DatabaseName=techneedsystem";
	private String dbusername = "sa";
	private String dbpassword = "123456";
	private Connection conn = null;
	private Statement stmt = null;

	public DBBean() {
		try {
			Class.forName(driverStr);
			conn = DriverManager.getConnection(connStr, dbusername, dbpassword);
			stmt = conn.createStatement();
			//System.out.println("建立连接成功！");
		} catch (Exception ex) {
			System.out.println("无法同数据库建立连接！");
		}
	}

	public int executeUpdate(String s) {
		int result = 0;
		try {
			result = stmt.executeUpdate(s);
		} catch (Exception ex) {
			System.out.println("执行更新错误！"+ex);
		}
		return result;
	}

	public ResultSet executeQuery(String s) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(s);
		} catch (Exception ex) {
			System.out.println("执行查询错误！");
		}
		return rs;
	}
	//用户表
	public String userExist(String user)
	{
		String User="";
		String sql="select username from userinfo";
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				//System.out.println(rs.getString(1));
				if(user.equals(rs.getString(1)))
				{
					User=user;
					break;
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}  
		return User;
	}
	//管理员表
	public String managerExist(String user)
	{
		String User="";
		String sql="select username from managerinfo";
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				//System.out.println(rs.getString(1));
				if(user.equals(rs.getString(1)))
				{
					User=user;
					break;
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}  
		return User;
	}
	//形式审核员表
		public String assessorExist(String user)
		{
			String User="";
			String sql="select username from assessorinfo";
			try{
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					//System.out.println(rs.getString(1));
					if(user.equals(rs.getString(1)))
					{
						User=user;
						break;
					}
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}  
			return User;
		}
		//部门审核员表
				public String mgtExist(String user)
				{
					String User="";
					String sql="select username from mgtinfo";
					try{
						ResultSet rs=stmt.executeQuery(sql);
						while(rs.next())
						{
							//System.out.println(rs.getString(1));
							if(user.equals(rs.getString(1)))
							{
								User=user;
								break;
							}
						}
					}
					catch (SQLException e)
					{
						e.printStackTrace();
					}  
					return User;
				}	
	public void close() {
		try {
			stmt.close();
			conn.close();
		} catch (Exception e) {
		}
	}
}
