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

public class AddCollection extends HttpServlet
{

	public AddCollection()
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
		
		String userid="",isbn="",name="",author="",image="",summary="",catalog="",
				publisher="",authintro="";
		
		userid=request.getParameter("userid");
		isbn=request.getParameter("isbn");
		name=request.getParameter("name");
		author=request.getParameter("author");
		image=request.getParameter("image");
		summary=request.getParameter("summary");
		catalog=request.getParameter("catalog");
		publisher=request.getParameter("publisher");
		authintro=request.getParameter("authintro");
		
		String sql="select * from collect where userid='"+userid+"' and isbn='"+isbn+"'";
		ResultSet rs=db.executeQuery(sql);
		try
		{
			if(rs.next()){
				out.print("1");
			}
			else{
				sql="insert into collect values('"+userid+"','"+isbn+"','"+name+"','"+author+"','"+image+"','"
						+summary+"','"+catalog+"','"+publisher+"','"+authintro+"')";
				
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
