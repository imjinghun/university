package servlet.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBBean;
import dao.GetValue;

public class CourseAdd extends HttpServlet
{
	public CourseAdd()
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
		// 设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		//创建对象
		DBBean db=new DBBean();
		GetValue getV=new GetValue();
		PrintWriter out = response.getWriter();
		
		String tcid,tctid,tcname,tctime;
		
		tcid=getV.getCid();
		tctid=(String)request.getSession().getAttribute("username");
		tcname=request.getParameter("tcname");
		tctime=getV.getDate();
		
		/**
		 * 使用预编译对象进行对数据库的操作 
		 * 防止SQL注入
		 */
		String sql="insert into tcourse(tcid,tctid,tcname,tctime) values(?,?,?,?)";
		PreparedStatement pstm=null;
		Connection conn=db.getConn();
		
		try
		{
			pstm=conn.prepareStatement(sql);
			
			pstm.setString(1, tcid);
			pstm.setString(2, tctid);
			pstm.setString(3, tcname);
			pstm.setString(4, tctime);
			
			pstm.executeUpdate();
			
			//out.print("<script>window.location='../Course/tecIndex.jsp';</script>");
		} catch (SQLException e)
		{
			System.out.println("创建课程异常");
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}

}
