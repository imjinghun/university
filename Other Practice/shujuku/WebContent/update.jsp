<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>更新修改</title>
</head>
<body>
<jsp:useBean id="db" class="bean.DBBean" scope="page" />
	<%
		request.setCharacterEncoding("UTF-8");
	    String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String ssex = request.getParameter("ssex");
		String sage = request.getParameter("sage");
		String sdept = request.getParameter("sdept");
		String sql = "update Student set Sname='" + sname + "',Ssex='" + ssex+"',Sage=" + sage+",Sdept='"+sdept
				+ "' where sno=" + sno;
		int i = db.executeUpdate(sql);
		if (i == 1) {
			out.println("<script language='javaScript'> alert('修改成功，点击确定后自动跳到学生信息界面。');</script>");
			response.setHeader("refresh", "1;url=studentsInfo.jsp");
		}
		db.close();
	%>
</body>
</html>