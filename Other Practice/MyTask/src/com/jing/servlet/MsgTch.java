package com.jing.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jing.dao.*;

public class MsgTch extends HttpServlet
{
	public MsgTch()
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
		PrintWriter out = response.getWriter();

		// 声明变量
		String mid = "", msg = "";

		/**************** 注意整合时，msid需要将学生账号号sid传过来 ***************************************************/
		//本页面写的是学生的留言
		
		mid = request.getParameter("mid");
		msg = request.getParameter("msg");
		
		//System.out.println(mid+" "+msg);

		String sql="update message set msg='"+msg+"' where mid='"+mid+"'";
		
		try
		{
			int i = db.executeUpdate(sql);
			if (i == 0)
			{
				out.print("<script language='javascript'>alert('回复出错，请重试！');"
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
