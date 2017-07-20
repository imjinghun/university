<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>提交成绩</title>
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
<form action="submitGrade.jsp" method="post" name="form1" >
<table align="center">
	<tr>
		<td>
			请输入学号：
		</td>
		<td>
			<input name="sno" type="text">
		</td>
		<td>
			请输入课程号：
		</td>
		<td>
			<input name="cno" type="text">
		</td>
		<td>
			请输入成绩：
		</td>
		<td>
			<input name="grade" type="text">
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="submit" value="提交">
		</td>
	</tr>
</table>
</form>
<jsp:useBean id="db" class="bean.DBBean" scope="page" />
	<%
		request.setCharacterEncoding("UTF-8");
		String submit = request.getParameter("submit");
		if (submit != null && !submit.equals("")) {
			String sno = request.getParameter("sno");
			String cno = request.getParameter("cno");
			String grade = request.getParameter("grade");
			
			String sql = "insert into Sc(Sno,Cno,Grade) values('" + sno + "','" + cno + "','" + grade + "')";
			int i = db.executeUpdate(sql);
			if (i == 1) {
				out.println("<script language='javaScript'> alert('添加成功,点击确定跳转到选课情况界面!');</script>");
				response.setHeader("refresh", "1;url=courseSelect.jsp");
			} else {
				out.println("<script language='javaScript'> alert('添加失败，点击确定返回本页面！');</script>");
				response.setHeader("refresh", "1;url=submitGrade.jsp");
			}
			db.close();
		}
	%>
</body>
</html>