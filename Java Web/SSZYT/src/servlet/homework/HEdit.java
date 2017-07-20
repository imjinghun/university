package servlet.homework;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBBean;

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
		String hid="",hname="",hinfo="",hendtime="";
		
		//变量赋值 获取form中的值
		hid=request.getParameter("hid");
		hname=request.getParameter("hname").trim();
		hinfo=request.getParameter("hinfo").trim();
		hendtime=request.getParameter("hendtime").trim();
		//声明对象
		DBBean db=new DBBean();
		PrintWriter out = response.getWriter();
		
		String sql="update homework set hname='"+hname+"',hinfo='"+hinfo+
				"',hendtime='"+hendtime+"' where hid='"+hid+"'";
		
		try
		{
			int i=db.executeUpdate(sql);
			if (i == 0)
			{
				out.print("修改出错");
				
			} else
			{
				out.print("成功");
			}
			
		} catch (Exception e)
		{
			out.print("修改异常");
		}
		
		out.flush();
		out.close();
	}
}
