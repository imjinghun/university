package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBBean;

public class DelBooking extends HttpServlet
{
	public DelBooking()
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
		
		String sql="delete from booking where userid='"
				+userid+"' and name='"+name+"' and author='"+author+"'";
		
		System.out.println(sql);
		
		db.executeUpdate(sql);
		
		out.print("success");
		db.close();
		
		out.flush();
		out.close();
	}

}
