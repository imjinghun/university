package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBBean
{
	private String driverStr = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String connStr = "jdbc:sqlserver://localhost:1433; DatabaseName=dbSSZYT";
	private String dbusername = "sa";
	private String dbpassword = "123456";
	private Connection conn = null;
	private Statement stmt = null;

	public DBBean() {
		try {
			Class.forName(driverStr);
			conn = DriverManager.getConnection(connStr, dbusername, dbpassword);
			//返回可滚动的结果集，当数据库变化时，当前结果集同步改变  当需要前后移动指针时 用到这条语句
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (Exception ex) {
			System.out.println("无法同数据库建立连接！"+ex);
		}
	}
	//获取链接
	public Connection getConn()
	{
		return conn;
	}
	
	//返回语句执行成功的条数(数据库中受影响的行数)
	public int executeUpdate(String s) {
		int result = 0;
		try {
			result = stmt.executeUpdate(s);
		} catch (Exception ex) {
			System.out.println("执行更新错误！"+ex);
		}
		return result;
	}

	// 批处理更新 str为String类型的数组 每个元素 存储sql语句
	public int executeBatch(String[] str)
	{
		int[] r;
		int result = 1;//返回的结果 自定义1表示批处理成功
		int length=str.length;
		try
		{
			//取消自动提交 (默认为true 自动提交)  sql命令的提交由应用程序负责，程序必须调用commit或者rollback方法
			conn.setAutoCommit(false);
			for(int i=0;i<length;i++)
			{
				stmt.addBatch(str[i]);
			}
			r=stmt.executeBatch(); //执行批处理语句  返回每条语句执行成功的条数 返回值为 int[]
			conn.commit();//提交事物
			
			//判断每条语句执行成功的条数 全部>=0 则成功
			for(int i=0;i<r.length;i++)
			{
				if(r[i]<0)
				{
					result=0;
					break;
				}
			}
			
		} catch (SQLException e)
		{
			try
			{
				System.out.println("批处理出错"+e);
				result=0;
				//将数据回滚
				conn.rollback();
			} catch (SQLException e1)
			{
				System.out.println("数据回滚出错");
			}
		}
		
		return result;
	}
	//返回ResultSet结果集
	public ResultSet executeQuery(String s) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(s);
		} catch (Exception ex) {
			System.out.println("执行查询错误！"+ex);
		}
		return rs;
	}
	
	public void close() {
		try {
			stmt.close();
			conn.close();
		} catch (Exception e) {
		}
	}
}
