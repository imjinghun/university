<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录-欢迎使用师生作业通</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="css/login.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/login.js"></script>

</head>

<body>
<div class="login">
    <h2><font color="black">欢迎使用-师生作业通</font></h2>
	<div class="login-top">
		<h1>登录使用</h1>
		
			<input type="text" placeholder="用户名" name="username" id="username">
			<input type="password" placeholder="密 码" name="password" id="password">
	    
	    <div class="forgot">
	    	<label id="alertlogin" ></label>
	    	<input type="submit" id="submit" name="submit" value="登 录" >
	    </div>
	</div>
	<div class="login-bottom">
		<h3>新用户点击 &nbsp;<a href="register.jsp">注册</a></h3>
	</div>
</div>	
<div class="copyright">
	<p>Copyright &copy; 2017.FenNuTeam All rights reserved.</p>
</div>
</body>
</html>
