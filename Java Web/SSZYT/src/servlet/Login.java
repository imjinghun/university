package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBBean;
import dao.FindInfo;

public class Login extends HttpServlet
{
	public Login()
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
		FindInfo fInfo=new FindInfo();
		PrintWriter out = response.getWriter();

		// 声明变量
		String username = "", password="";
		
		username=request.getParameter("username").trim();
		password=request.getParameter("password").trim();
		
		String table="",sql="";
		
		table=fInfo.userExist(username);
		String[] tableid=table.split(" ");
		
		if(table.equals(""))//用户不存在
		{
			out.print("nouname");
		}
		else
		{
			sql="select password from "+tableid[0]+" where "+tableid[1]+"='"+username+"'";
			ResultSet rs=db.executeQuery(sql);
			try
			{
				if(rs.next())
				{
					if(password.equals(rs.getString("password")))
					{
						//将用户名存入session
						request.getSession().setAttribute("username", username);
						//角色存入session
						request.getSession().setAttribute("role", tableid[0]);
						//tableid[0]是数据表名 代表不同角色
						out.print("ok"+" "+tableid[0]);
					}
					else
					{
						out.print("nopwd");
					}
				}
			} catch (SQLException e)
			{
				System.out.println("登录异常");
			}
		}
		out.flush();
		out.close();
	}
}