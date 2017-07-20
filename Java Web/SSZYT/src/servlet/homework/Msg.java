package servlet.homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

public class Msg extends HttpServlet
{
	public Msg()
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
		GetValue getV = new GetValue();
		PrintWriter out = response.getWriter();

		// 声明变量
		String mid = "", mhid = "", mcid = "", msid = "", mtid = "", msg = "";

		mhid = request.getParameter("hid");
		mcid = request.getParameter("hcid");
		msid=(String) request.getSession().getAttribute("username");
		mtid = request.getParameter("htid");
		msg = request.getParameter("msg");
		
		String sql="";
		//判断已登录的学生 在此作业下是否存在过留言 存在则更新 否则就插入
		String sql2="select mid from message where msid='"+msid+"' and mhid='"+mhid+"'";
		ResultSet rs=db.executeQuery(sql2);
		try
		{
			if(rs.next())//存在留言
			{
				sql="update message set msg='"+msg+"' where mid='"+rs.getString("mid")+"'";
			}
			else
			{
				mid = getV.getMid();
				sql = "insert into message values('"+ mid+"','"+mhid+"','"+mcid+ "','"+msid+ "','"+ mtid+
						"','"+ msg+"')";
			}
		} catch (SQLException e1)
		{
			System.out.println("留言是否存在查询错误");
		}
		
		try
		{
			int i = db.executeUpdate(sql);
			if (i == 0)
			{
				out.print("<script language='javascript'>alert('留言出错，请重试！');"
						+ "history.go(-1);</script>");
			} else
			{
				out.print("success");
			}

		} catch (Exception e)
		{
			out.print("<script language='javascript'>alert('出错，请重试！');"
					+ "history.back();</script>");
		}
		out.flush();
		out.close();
	}

}
