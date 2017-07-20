package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBBean;

public class DelBorrow extends HttpServlet
{

	public DelBorrow()
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
		
		String userid="",isbn="";
		userid=request.getParameter("userid");
		isbn=request.getParameter("isbn");
		
		String sql="delete from borrow where userid='"+userid+"' and isbn='"+isbn+"'";
		
		System.out.println(sql);
		
		db.executeUpdate(sql);
		out.print("success");
		db.close();
		
		out.flush();
		out.close();
	}

}
