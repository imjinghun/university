package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

public class AddBorrow extends HttpServlet
{

	public AddBorrow()
	{
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		DBBean db=new DBBean();
		GetValue getV=new GetValue();
		PrintWriter out=response.getWriter();
		
		String userid="",isbn="",name="",author="",starttime="",endtime="";
		
		userid=request.getParameter("userid");
		isbn=request.getParameter("isbn");
		//查询用户是否借阅过此书
		String sql="select * from borrow where userid='"+userid+"' and isbn='"+isbn+"'";
		
		ResultSet rs=db.executeQuery(sql);
		int count=0;
		try
		{
			if(rs.next()){
				out.print("1"); //已经借阅
			}
			else{
				//根据userid查询用户已经借了几本书
				sql="select count(*) from borrow where userid ='"+userid+"'";
				rs=db.executeQuery(sql);
				if(rs.next())
				{
					count=rs.getInt(1);
				}
				if(count==2)
				{
					out.print("2"); //已经借了两本
				}
				else{
					String dates=getV.getDate();
					String date[]=dates.split("#");
					
					name=request.getParameter("name");
					author=request.getParameter("author");
					starttime=date[0];
					endtime=date[1];
					
					sql="insert into borrow values('"+userid+"','"+isbn+"','"+name+"','"
							+author+"','"+starttime+"','"+endtime+"')";
					
					db.executeUpdate(sql);
					out.print("success");
				}
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		System.out.println(sql);
		db.close();
		
		out.flush();
		out.close();
	}

}
