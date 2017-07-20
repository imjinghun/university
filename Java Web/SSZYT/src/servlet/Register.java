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

public class Register extends HttpServlet
{

	/**
	 * Constructor of the object.
	 */
	public Register()
	{
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 创建对象
		DBBean db = new DBBean();
		FindInfo fInfo=new FindInfo();
		PrintWriter out = response.getWriter();

		// 声明变量
		String username = "", password="",identity="",sno = "",name = "", school = "";
		
		username=request.getParameter("username").trim();
		password=request.getParameter("password").trim();
		identity=request.getParameter("identity").trim();
		
		name=request.getParameter("name").trim();
		school=request.getParameter("school").trim();
		String user=fInfo.userExist(username);
		if(user.equals(""))//不存在
		{
			String sql="insert into teacher values('"+username+"','"+password+"','"+name+"','"+school+"')";
			
			if(identity.equals("学生"))
			{
				sno=request.getParameter("sno").trim();
				sql="insert into student values('"+username+"','"+password+"','"+sno+"','"+name+"','"+school+"')";
			}
			
			int i=db.executeUpdate(sql);
			if(i==0)
			{
				out.print("fail");
			}
			else
			{
				out.print("success");
			}
		}
		else
		{
			out.print("exist");
		}
		
		out.flush();
		out.close();
	}
}
