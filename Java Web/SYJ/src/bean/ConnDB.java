package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnDB {
	private String driverStr="oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:oracle";
	private String user="user_20142861";
	private String password="123456";
	private Connection conn = null;
	Statement stmt=null;
	public ConnDB()
	{
		try{
			Class.forName(driverStr);
			conn=DriverManager.getConnection(url, user, password);
			stmt=conn.createStatement();//删掉此句出错
		}
		catch(Exception ex)
		{
			System.out.println("数据库连接失败");
		}
		//System.out.println("数据库连接成功");
	}
	public int executeUpdate(String s) {
		int result = 0;
		try {
			result = stmt.executeUpdate(s);
		} catch (Exception ex) {
			System.out.println("执行更新错误！");
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
	public void close() {
		try {
			stmt.close();
			conn.close();
		} catch (Exception e) {
		}
	}
}
