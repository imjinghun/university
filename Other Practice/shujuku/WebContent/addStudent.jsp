<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加学生信息</title>
</head>
<body>
<form action="addStudent.jsp" method="post" name="form1"  >
		<table align="center">
			<caption>添加学生信息</caption>
			<tr>
				<th >学号：</th>
				<td ><input name="sno" type="text"></td>
			</tr>
			<tr>
				<th >姓名：</th>
				<td ><input name="sname" type="text"></td>
			</tr>
			<tr>
				<th>性别：</th>
				<td><input name="ssex" type="text"></td>
			</tr>
			<tr>
				<th>年龄：</th>
				<td><input name="sage" type="text"></td>
			</tr>
			<tr>
				<th>系别：</th>
				<td><input name="sdept" type="text"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" name="submit" value="添加">
					<input type="reset" value="重置"></th>
			</tr>
		</table>
	</form>
	<jsp:useBean id="db" class="bean.DBBean" scope="page" />
	<%
		request.setCharacterEncoding("UTF-8");
		String submit = request.getParameter("submit");
		if (submit != null && !submit.equals("")) {
			String sno = request.getParameter("sno");
			String sname = request.getParameter("sname");
			String ssex = request.getParameter("ssex");
			String sage = request.getParameter("sage");
			String  sdept = request.getParameter("sdept");

			String sql = "insert into Student(Sno,Sname,Ssex,Sage,Sdept) values('" + sno + "','" + sname + "','"+ ssex + "',"+ sage + ",'"+ sdept + "')";
			int i = db.executeUpdate(sql);
			if (i == 1) {
				out.println("<script language='javaScript'> alert('添加成功,点击确定跳转到学生信息界面!');</script>");
				response.setHeader("refresh", "1;url=studentsInfo.jsp");
			} else {
				out.println("<script language='javaScript'> alert('添加失败，点击确定返回添加页面！');</script>");
				response.setHeader("refresh", "1;url=addStudent.jsp");
			}
			db.close();
		}
	%>
</body>
</html>