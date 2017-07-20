<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除课程信息</title>
</head>
<body>
<jsp:useBean id="db1" class="bean.DBBean" scope="page" />
	<%
		request.setCharacterEncoding("UTF-8");
		String scno=request.getParameter("cno");
		int i = db1.executeUpdate("delete from Course where cno="+scno);
		if (i == 1) {
			out.println("<script language='javaScript'> alert('删除成功，点击确定后自动跳到课程信息界面！');</script>");
			response.setHeader("refresh", "1;url=courseInfo.jsp");
		} else {
			out.println("<script language='javaScript'> alert('删除失败，点击确定后自动跳到课程信息界面！');</script>");
			response.setHeader("refresh", "1;url=courseInfo.jsp");
		}
		db1.close();
	%>
</body>
</html>