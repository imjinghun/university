<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改学生信息</title>
</head>
<body>

<jsp:useBean id="db" class="bean.DBBean" scope="page" />
	<%
		
		request.setCharacterEncoding("UTF-8");
		String sno=request.getParameter("sno");
		ResultSet rs = db.executeQuery("select * from Student where sno=" + sno);
		rs.next();
	%>
	<form action="update.jsp" method="post" name="form1">
		<table>
			<caption>修改学生信息</caption>
			
			<tr>
				<th >姓名：</th>
				<td ><input name="sname" type="text"
					value="<%=rs.getString(2)%>"></td>
			</tr>
			<tr>
				<th>性别：</th>
				<td><input name="ssex" type="text"
					value="<%=rs.getString(3)%>"></td>
			</tr>
			<tr>
				<th>年龄：</th>
				<td><input name="sage" type="text"
					value="<%=rs.getString(4)%>"></td>
			</tr>
			<tr>
				<th>系别：</th>
				<td><input name="sdept" type="text"
					value="<%=rs.getString(5)%>"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="hidden" name="sno" value="<%=sno%>">
					<input type="submit" value="修改"> <input type="reset"
					value="重置"></th>
			</tr>
		</table>
	</form>
	<%
		db.close();
	%>
</body>
</html>