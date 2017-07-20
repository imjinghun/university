<%@ page language="java" contentType="text/html; charset=utf-8" language="java"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>校园留言管理系统--添加留言</title>
<script>
	function check()
	{
		if(form1.title.value=="")
		{
			form1.title.focus();
			alert("标题不能为空");
			return false;
		}
		if(form1.content.value=="")
		{
			form1.content.focus();
			alert("内容不能为空");
			return false;
		}
		if(form1.title.value.length>30)
		{
			form1.title.focus();
			alert("标题不符合要求");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form name="form1" action="useradd.jsp" method="post" onsubmit="return check()">
		<table width="80%" border="1" align="center">
			<caption>留言表</caption>
			<tr>
				<td width="30%">留言标题：</td>
				<td width="70%"><textarea name="title" style="width:100%;height:100%;border:none;overflow:hidden"></textarea></td>
			</tr>
			<tr>
			<td colspan="2">留言内容（从下一行开始填写）：</td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="content" style="width:100%;height:100%;border:none;overflow:hidden"></textarea></td>
			</tr>
		</table>
		<p align="center">
		<input type="submit" name="sure" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
		</p>
	</form>
	<jsp:useBean id="db" class="bean.DBBean" scope="page" />
	
	<%
		request.setCharacterEncoding("UTF-8");
		String submit = request.getParameter("sure");
		if (submit != null && !submit.equals("")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			String sql = "insert into liuyan(title,content) values('" + title + "','" + content + "'" + ")";
			int i = db.executeUpdate(sql);
			if (i == 1) {
				out.println("<script language='javaScript'> alert('填写留言成功,点击确定转到用户界面!');</script>");
				response.setHeader("refresh", "1;url=user.jsp");
			} else {
				out.println("<script language='javaScript'> alert('填写留言失败，点击确定返回添加页面！');</script>");
				response.setHeader("refresh", "1;url=useradd.jsp");
			}
			db.close();
		}
	%>
</body>
</html>