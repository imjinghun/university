package servlet.homework;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

public class HDel extends HttpServlet
{
	public HDel()
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
		
		// 声明对象
		DBBean db = new DBBean();
		String hid = "";

		hid=request.getParameter("hid");
		PrintWriter out = response.getWriter();
		
		String[] sql=new String[3];
		//删除作业语句 作业相关的留言信息 学生资料表作业选相关
		sql[0] = "delete from homework where hid='" + hid + "'";
		sql[1]="delete from message where mhid='" + hid + "'";
		sql[2]="delete from smaterial where smhid='" + hid + "'";
		int i=db.executeBatch(sql);
		if(i==0)
		{
			out.print("删除失败，请重试");
		}
		else
		{
			out.print("删除成功");
		}
		
		out.flush();
		out.close();
	}

}
