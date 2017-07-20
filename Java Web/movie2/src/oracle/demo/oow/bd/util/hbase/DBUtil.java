package oracle.demo.oow.bd.util.hbase;

import java.sql.*;

public class DBUtil {
	private String driverStr = ConstantsHBase.MYSQL_DRIVER;
	private String connStr = ConstantsHBase.MYSQL_URL;
	private String dbusername = ConstantsHBase.MYSQL_USERNAME;
	private String dbpassword = ConstantsHBase.MYSQL_PASSWORD;
	private Connection conn = null;
	private Statement stmt = null;

	public DBUtil() {
		/*try {
			stmt = getConn().createStatement();
		} catch (Exception ex) {
			System.out.println("DBUtil无法同数据库建立连接！");
		}*/
	}
	public Connection getConn(){
		try {
			Class.forName(driverStr);
			conn = DriverManager.getConnection(connStr, dbusername, dbpassword);
			//stmt = conn.createStatement();
		} catch (Exception ex) {
			System.out.println("Connection无法同数据库建立连接！"+ex);
		}
		return conn;
	}
	//用于增删改
	public int executeUpdate(String s) {
		int result = 0;
		try {
			result = stmt.executeUpdate(s);
		} catch (Exception ex) {
			System.out.println("执行更新错误！");
		}
		return result;
	}
	//用于查询
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
			//stmt.close();
			conn.close();
		} catch (Exception e) {
		}
	}
}
