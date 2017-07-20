<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>首页-欢迎使用师生作业通</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<%
		String id = (String) session.getAttribute("username");
		if (id == null)
		{
	%>
	<jsp:forward page="login.jsp"></jsp:forward>
	<%
		} else
		{
			String role = (String) session.getAttribute("role");
			if (role.equals("student"))
			{
				out.print("<script>window.location.href='./Course/stdIndex.jsp';</script>");
			}
			if (role.equals("teacher"))
			{
				out.print("<script>window.location.href='./Course/tecIndex.jsp';</script>");
			}
			if (role.equals("administrator"))
			{
				out.print("<script>window.location.href='./UserMgt/index.jsp';</script>");
			}
		}
	%>
</body>
</html>
