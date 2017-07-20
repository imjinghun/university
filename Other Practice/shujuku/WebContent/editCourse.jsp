<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改课程信息</title>
</head>
<body>
<jsp:useBean id="db1" class="bean.DBBean" scope="page" />
	<%
		request.setCharacterEncoding("UTF-8");
		String scno=request.getParameter("cno");
		ResultSet rs = db1.executeQuery("select * from course where cno=" + scno);
		rs.next();
	%>
	<form action="update1.jsp" method="post" name="form1">
		<table>
			<caption>修改课程信息</caption>
			
			<tr>
				<th >课程名：</th>
				<td ><input name="cname" type="text"
					value="<%=rs.getString(2)%>"></td>
			</tr>
			<tr>
				<th>学分：</th>
				<td><input name="ccredit" type="text"
					value="<%=rs.getString(3)%>"></td>
			</tr>
			<tr>
				<th>学期：</th>
				<td><input name="semester" type="text"
					value="<%=rs.getString(4)%>"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="hidden" name="cno" value="<%=scno%>">
					<input type="submit" value="修改"> <input type="reset"
					value="重置"></th>
			</tr>
		</table>
	</form>
	<%
		db1.close();
	%>
</body>
</html>