<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<jsp:useBean id="db" class="bean.DBBean" scope="page" />
<%
	request.setCharacterEncoding("UTF-8");
	String username=request.getParameter("username");
	//System.out.println(username);
	if(username!=""&&username!=null)
	{
		String sql="delete from mgtInfo where username='"+username+"'";
		int i=db.executeUpdate(sql);
		if (i == 1) {
			response.setHeader("refresh", "0.1;url=yhgl.jsp");
		} 
		else {
			out.println("<script language='javaScript'> alert('删除失败，点击确定重新删除！');history.back();</script>");
		}
		db.close();
	}

%>
</body>
</html>