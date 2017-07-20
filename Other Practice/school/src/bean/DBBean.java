package bean;

import java.sql.*;

public class DBBean {

	private String driverStr = "com.mysql.jdbc.Driver";
	private String connStr = "jdbc:mysql://localhost:3306/schoolmanagement";
	private String dbusername = "root";
	private String dbpassword = "tobeno1";
	private Connection conn = null;
	private Statement stmt = null;

	public DBBean() {
		try {
			Class.forName(driverStr);
			conn = DriverManager.getConnection(connStr, dbusername, dbpassword);
			stmt = conn.createStatement();
		} catch (Exception ex) {
			System.out.println("�޷�ͬ���ݿ⽨�����ӣ�");
		}
	}
	//������ɾ��
	public int executeUpdate(String s) {
		int result = 0;
		try {
			result = stmt.executeUpdate(s);
		} catch (Exception ex) {
			System.out.println("ִ�и��´���");
		}
		return result;
	}
	//���ڲ�ѯ
	public ResultSet executeQuery(String s) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(s);
		} catch (Exception ex) {
			System.out.println("ִ�в�ѯ����");
		}
		return rs;
	}
	//���ݴ��������û�����ѯ���ݿ����Ƿ���ڴ��û�
	public String userExist(String uName)
	{
		String username="";
		String sql="select username from user";
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				if(uName.equals(rs.getString(1)))
				{
					username=uName;
					break;
				}
			}
		}
		catch (SQLException e)
	    {
	          e.printStackTrace();
	    }  
		return username;
	}
	
	public void close() {
		try {
			stmt.close();
			conn.close();
		} catch (Exception e) {
		}
	}

}
