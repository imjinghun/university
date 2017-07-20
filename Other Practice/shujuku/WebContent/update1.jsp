<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>更改课程信息</title>
</head>
<body>
<jsp:useBean id="db" class="bean.DBBean" scope="page" />
	<%
		request.setCharacterEncoding("UTF-8");
	    String cno = request.getParameter("cno");
		String cname = request.getParameter("cname");
		String  ccredit= request.getParameter("ccredit");
		String semester = request.getParameter("semester");
		String sql = "update Course set Cname='" + cname + "',Ccredit=" + ccredit+",Semester='"+semester
				+ "' where cno=" + cno;
		int i = db.executeUpdate(sql);
		if (i == 1) {
			out.println("<script language='javaScript'> alert('修改成功，点击确定后自动跳到课程信息界面。');</script>");
			response.setHeader("refresh", "1;url=courseInfo.jsp");
		}
		db.close();
	%>
</body>
</html>