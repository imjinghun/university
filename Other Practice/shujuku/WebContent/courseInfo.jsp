<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
	<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程信息及操作</title>
<style type="text/css">
table {
	border-collapse: collapse;
	border: none;
	margin: 0px auto;
	width: 500px;
}

th, td {
	border: solid #333 1px;
	height: 20px;
}

div {
	text-align: center;
}
</style>
</head>
<body>
	<div>
		<a href="addCourse.jsp">添加课程信息</a><br/><br/>
		<a href="index.jsp">主界面</a>
	</div>
	<table align="center">
		<tr>
			<td>课程号</td>
			<td>课程名</td>
			<td>学分</td>
			<td>学期</td>
			<td>操作</td>
		</tr>
		<jsp:useBean id="db" class="bean.DBBean" scope="page" />
		<%
			String s = "select * from Course";
			ResultSet rs = db.executeQuery(s);
			while (rs.next()) {
				String cno = rs.getString(1);
				out.println("<tr><td>" + rs.getString(1)
				+ "</td><td>" + rs.getString(2)
				+ "</td><td>" + rs.getString(3)
				+ "</td><td>" + rs.getString(4)
				+ "</td><td><a href='editCourse.jsp?cno="
				+ cno +"'>修改</a>&nbsp;<a href='delCourse.jsp?cno="
				+ cno + "'>删除</a>&nbsp;<a href='courseSelect.jsp?cno="
						+ cno + "'>选修情况</a></td></tr>");
			}
			rs.close();
			db.close();
		%>
		</table>
</body>
</html>