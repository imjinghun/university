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

public class CourseDel extends HttpServlet
{
	public CourseDel()
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
		PrintWriter out = response.getWriter();
		String tcid=request.getParameter("tcid");
		String sql[]=new String[6];
		//删除 学生课程 老师课程 课程相关作业  资料 留言  
		sql[0]="delete from scourse where scid='"+tcid+"'";
		sql[1]="delete from tcourse where tcid='"+tcid+"'";
		sql[2]="delete from homework where hcid='"+tcid+"'";
		sql[3]="delete from tmaterial where tmcid='"+tcid+"'";
		sql[4]="delete from smaterial where smcid='"+tcid+"'";
		sql[5]="delete from message where mcid='"+tcid+"'";
	 	int ret=db.executeBatch(sql);
	 	if(ret==1)
	 	{
	 		out.print("成功");
	 	}
	 	else{
	 		out.print("失败");
	 	}
		out.flush();
		out.close();
	}

}
