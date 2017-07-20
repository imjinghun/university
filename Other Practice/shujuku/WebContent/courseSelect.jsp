<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选课情况</title>
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
			<td>学号</td>
			<td>课程号</td>
			<td>姓名</td>
			<td>系别</td>
			<td>成绩</td>
		</tr>
		<jsp:useBean id="db" class="bean.DBBean" scope="page" />
		<%
			String s = "select SC.Sno,cno,Sname,Sdept,grade from Student s join Sc on s.sno=sc.sno";
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
		<div>
			<a href="courseInfo.jsp">返回课程信息界面</a>
		</div>
</body>
</html>