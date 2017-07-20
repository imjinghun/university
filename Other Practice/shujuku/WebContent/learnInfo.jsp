<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学习情况</title>
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
    <table align="center">
		<tr>
			<td>课程号</td>
			<td>课程名</td>
			<td>学分</td>
			<td>学期</td>
			<td>成绩</td>
		</tr>
		<jsp:useBean id="db" class="bean.DBBean" scope="page" />
		<%
			String s = "select SC.Cno,Cname,Ccredit,Semester,grade from sc join course c on sc.cno=c.cno";
			ResultSet rs = db.executeQuery(s);
			while (rs.next()) {
				String sno = rs.getString(1);
				out.println("<tr><td>" + rs.getString(1)
				+ "</td><td>" + rs.getString(2)
				+ "</td><td>" + rs.getString(3)
				+ "</td><td>" + rs.getString(4)
				+ "</td><td>" + rs.getString(5)
				+ "</td><td>");
			}
			rs.close();
			db.close();
		%>
	</table>
	<br/>
	<div>
		<a href="studentsInfo.jsp">返回学生信息界面</a>
	</div>
</body>
</html>