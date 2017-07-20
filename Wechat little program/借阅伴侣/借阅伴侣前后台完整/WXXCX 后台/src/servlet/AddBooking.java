package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBBean;

public class AddBooking extends HttpServlet
{
	public AddBooking()
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
		PrintWriter out=response.getWriter();
		
		String userid="",name="",author="";
		userid=request.getParameter("userid");
		name=request.getParameter("name");
		author=request.getParameter("author");
		
		String sql="select * from booking where userid='"+userid+"' and name='"
				+name+"' and author='"+author+"'";
		
		ResultSet rs=db.executeQuery(sql);
		try
		{
			if(rs.next()){
				out.print("1");
			}
			else{
				sql="insert into booking values('"+userid+"','"+name+"','"+author+"')";
				db.executeUpdate(sql);
				out.print("success");
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
