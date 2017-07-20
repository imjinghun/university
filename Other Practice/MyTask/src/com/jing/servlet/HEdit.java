package com.jing.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jing.dao.DBBean;

public class HEdit extends HttpServlet
{
	public HEdit()
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
		//设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//变量定义
		String hid="",hname="",hinfo="",hbegintime="",hendtime="";
		
		//变量赋值 获取form中的值 
		hid=request.getParameter("hid");
		hname=request.getParameter("hname");
		hinfo=request.getParameter("hinfo");
		hbegintime=request.getParameter("hbegintime");
		hendtime=request.getParameter("hendtime");
		
		//声明对象
		DBBean db=new DBBean();
		PrintWriter out = response.getWriter();
		
		String sql="update homework set hname='"+hname+"',hinfo='"+hinfo+"',hbegintime='"+hbegintime+
				"',hendtime='"+hendtime+"' where hid='"+hid+"'";
		
		try
		{
			int i=db.executeUpdate(sql);
			if (i == 0)
			{
				out.print("<script language='javascript'>alert('更新作业出错，请重试！');"
						+ "history.go(-1);</script>");
			} else
			{
				out.print("<script language='javascript'>window.location.href='../HListTch.jsp';</script>");
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
