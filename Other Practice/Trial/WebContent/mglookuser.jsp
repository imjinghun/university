<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>河北省重大技术征集系统--查看注册者信息</title>
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
			<td>用户名</td>
			<td>密码</td>
			<td>姓名</td>
			<td>电话</td>
			<td>工作单位</td>
		</tr>
		<jsp:useBean id="db" class="bean.DBBean" scope="page" />
		<%
			String s = "select * from user";
			ResultSet rs = db.executeQuery(s);
			while (rs.next()) {
				String cno = rs.getString(1);
				out.println("<tr><td>" + rs.getString(1)
				+ "</td><td>" + rs.getString(2)
				+ "</td><td>" + rs.getString(3)
				+ "</td><td>" + rs.getString(4)
				+ "</td><td>" + rs.getString(5)
				+ "</td>");
			}
			rs.close();
			db.close();
		%>
	</table>
</body>
</html>