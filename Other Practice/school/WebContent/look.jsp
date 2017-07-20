<%@ page language="java" contentType="text/html; charset=utf-8" language="java"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>留言详情</title>
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
			<td>详情</td>
		</tr>
		<jsp:useBean id="db" class="bean.DBBean" scope="page" />
		<%
		String id = request.getParameter("id");
		ResultSet rs = db.executeQuery("select content from liuyan where id='" + id +"'");
		rs.next();
			
		out.println("<tr><td>" + rs.getString(1)+ "</td></tr>");
			
		rs.close();
		db.close();
		%>
	</table>
</body>
</html>