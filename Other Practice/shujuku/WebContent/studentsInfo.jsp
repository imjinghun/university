<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息及操作</title>
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
		<a href="addStudent.jsp">添加学生信息</a><br/><br/>
	</div>
	<table align="center">
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>系别</td>
			<td>操作</td>
		</tr>
		<jsp:useBean id="db" class="bean.DBBean" scope="page" />
		<%
			String s = "select * from Student";
			ResultSet rs = db.executeQuery(s);
			while (rs.next()) {
				String sno = rs.getString(1);
				out.println("<tr><td>" + rs.getString(1)
				+ "</td><td>" + rs.getString(2)
				+ "</td><td>" + rs.getString(3)
				+ "</td><td>" + rs.getString(4)
				+ "</td><td>" + rs.getString(5)
				+ "</td><td><a href='editStudent.jsp?sno="
				+ sno +"'>修改</a>&nbsp;<a href='delStudent.jsp?sno="
				+ sno + "'>删除</a>&nbsp;<a href='learnInfo.jsp?sno="+sno+"'>学习情况</a></td></tr>");
			}
			rs.close();
			db.close();
		%>
	</table>
</body>
</html>