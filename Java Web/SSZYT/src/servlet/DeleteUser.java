package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBBean;

public class DeleteUser extends HttpServlet
{
	public DeleteUser()
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
		String role=request.getParameter("role");
		String id=request.getParameter("id");
		if(role.equals("teacher"))
		{
			/**
			 * 查询出此老师所有的课程号 根据课程号进行删除 学生课程信息 学生资料表
			 * 根据老师账号删除 作业表 老师资料表 留言表 老师课程表 老师信息表
			 */
		}
		if(role.equals("student"))
		{
			
		}
		out.flush();
		out.close();
	}

}
