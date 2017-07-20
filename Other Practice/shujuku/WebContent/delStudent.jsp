<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除学生信息</title>
</head>
<body>

<jsp:useBean id="db" class="bean.DBBean" scope="page" />
	<%
		String sno=request.getParameter("sno");
		request.setCharacterEncoding("UTF-8");
		int i = db.executeUpdate("delete from Student where sno="+sno);
		if (i == 1) {
			out.println("<script language='javaScript'> alert('删除成功，点击确定后自动跳到学生信息界面！');</script>");
			response.setHeader("refresh", "1;url=studentsInfo.jsp");
		} else {
			out.println("<script language='javaScript'> alert('删除失败，点击确定后自动跳到学生信息界面！');</script>");
			response.setHeader("refresh", "1;url=studentsInfo.jsp");
		}
		db.close();
	%>
</body>
</html>