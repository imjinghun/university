package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBBean;

public class UpdateUser extends HttpServlet
{
	public UpdateUser()
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
		String role=(String)request.getSession().getAttribute("role");
		String username=(String)request.getSession().getAttribute("username");
		String sno,name,school,sql="";
		if(role.equals("teacher"))
		{
			name=request.getParameter("name");
			school=request.getParameter("school");
			sql="update teacher set tname='"+name+"',tschool='"+school+"' where tid='"+username+"'";
			db.executeUpdate(sql);
			out.print("<script>window.location='../tecinfo.jsp'</script>");
		}
		if(role.equals("student"))
		{
			sno=request.getParameter("sno");
			name=request.getParameter("name");
			school=request.getParameter("school");
			sql="update student set sno='"+sno+"',sname='"+name+"',sschool='"+school+"' where sid='"+username+"'";
			db.executeUpdate(sql);
			out.print("<script>window.location='../stdinfo.jsp'</script>");
		}
		if(role.equals("administrator"))
		{
			name=request.getParameter("name");
			sql="update administrator set adminname='"+name+"' where adminid='"+username+"'";
			db.executeUpdate(sql);
			out.print("<script>window.location='../admininfo.jsp'</script>");
		}
		out.flush();
		out.close();
	}

}
