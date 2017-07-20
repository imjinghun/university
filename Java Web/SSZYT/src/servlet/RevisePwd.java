package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBBean;

public class RevisePwd extends HttpServlet
{
	public RevisePwd()
	{
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
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
		String sql="";
		PrintWriter out = response.getWriter();
		String role=(String)request.getSession().getAttribute("role");
		String username=(String)request.getSession().getAttribute("username");
		String pwd=request.getParameter("pwd");
		if (role.equals("teacher"))
		{
			sql="update teacher set password='"+pwd+"' where tid='"+username+"'";
		}
		if (role.equals("student"))
		{
			sql="update student set password='"+pwd+"' where sid='"+username+"'";
		}
		if(role.equals("administrator"))
		{
			sql="update administrator set password='"+pwd+"' where adminid='"+username+"'";
		}
		int i=db.executeUpdate(sql);
		if(i==1)
		{
			out.print("成功");
		}
		else
		{
			out.print("失败");
		}
		out.flush();
		out.close();
	}

}
