package servlet.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBBean;

public class CourseEdit extends HttpServlet
{
	public CourseEdit()
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
		
		String tcid="",tcname="";
		tcid=request.getParameter("tcid");
		tcname=request.getParameter("tcname");
		String sql[]=new String[2];
		//更新 学生老师课程表 课程名称
		sql[0]="update tcourse set tcname ='"+tcname+"' where tcid='"+tcid+"'";
		sql[1]="update scourse set scname ='"+tcname+"' where scid='"+tcid+"'";
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
