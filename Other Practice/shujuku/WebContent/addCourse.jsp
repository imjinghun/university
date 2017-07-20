<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加课程信息</title>
</head>
<body>
<form action="addCourse.jsp" method="post" name="form1" >
		<table align="center">
			<caption>添加课程信息</caption>
			<tr>
				<th >课程号：</th>
				<td ><input name="cno" type="text"></td>
			</tr>
			<tr>
				<th >课程名：</th>
				<td ><input name="cname" type="text"></td>
			</tr>
			<tr>
				<th>学分：</th>
				<td><input name="ccredit" type="text"></td>
			</tr>
			<tr>
				<th>学期：</th>
				<td><input name="semester" type="text"></td>
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
			String cno = request.getParameter("cno");
			String cname = request.getParameter("cname");
			String ccredit = request.getParameter("ccredit");
			String  semester = request.getParameter("semester");

			String sql = "insert into course(Cno,Cname,Ccredit,Semester) values('" + cno + "','" + cname + "',"+ ccredit + ","+ semester + ")";
			int i = db.executeUpdate(sql);
			if (i == 1) {
				out.println("<script language='javaScript'> alert('添加成功,点击确定跳转到课程信息界面!');</script>");
				response.setHeader("refresh", "1;url=courseInfo.jsp");
			} else {
				out.println("<script language='javaScript'> alert('添加失败，点击确定返回添加页面！');</script>");
				response.setHeader("refresh", "1;url=addCourse.jsp");
			}
			db.close();
		}
%>
</body>
</html>