<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>校园留言管理系统--浏览留言</title>
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
<table>
		<tr>
			<td>编号</td>
			<td>标题</td>
			<td>发布日期</td>
			<td>操作</td>
		</tr>
		<jsp:useBean id="db" class="bean.DBBean" scope="page" />
		<%
			String s = "select id,title,date from liuyan";
			ResultSet rs = db.executeQuery(s);
			while (rs.next()) {
				int id = rs.getInt(1);
				out.println("<tr><td>" + rs.getInt(1)
				+ "</td><td>" + rs.getString(2)
				+ "</td><td>" + rs.getString(3)
				+"</td><td>"
				+"<a href='look.jsp?id=" + id 
				+ "'>查看</a></td></tr>");
			}
			rs.close();
			db.close();
		%>
	</table>
</body>
</html>