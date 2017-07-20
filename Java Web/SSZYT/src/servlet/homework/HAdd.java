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

public class HAdd extends HttpServlet
{
	public HAdd()
	{
		super();
	}

	public void destroy()
	{
		super.destroy();
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
		String hid = "", hcid="",htid="",hname = "", hinfo = "", hbegintime = "", hendtime = "";
		int hsubmit=0,hnosubmit=0;
		
		hcid=request.getParameter("hcid");
		
		//查询此课程所属老师账号及人数
		String sql1="select tctid,tcnumber from tcourse where tcid='"+hcid+"'";
		
		ResultSet rs=db.executeQuery(sql1);
		try
		{
			if(rs.next())
			{
				htid=rs.getString("tctid");
				hnosubmit=rs.getInt("tcnumber");
			}
			
		} catch (SQLException e1)
		{
			out.print("课程人数异常，请重试");
		}
		
		// 变量赋值
		hname = request.getParameter("hname").trim();
		hinfo = request.getParameter("hinfo").trim();
		hendtime = request.getParameter("hendtime").trim();
		hid = getV.getHid();
		hbegintime = getV.getDate();
		
		String sql = "insert into homework values('"+ hid+"','"+hcid+"','"+htid+ "','"+ hname+
				"','"+ hinfo+ "','"+ hbegintime+ "','" + hendtime + "',"+hsubmit+","+hnosubmit+")";
		try
		{
			int i = db.executeUpdate(sql);
			if (i == 0)
			{
				out.print("发布作业出错，请重试");
			}
			else
			{
				out.print("成功");
			}

		} catch (Exception e)
		{
			out.print("发布作业异常");
		}

		out.flush();
		out.close();
	}
}
