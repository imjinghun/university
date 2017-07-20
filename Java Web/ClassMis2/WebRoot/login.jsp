<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录-班级管理系统</title>
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
  <center>
   <p><span style="color:red;"><s:property value="errors.loginError[0]"/></span>
   <form action="std_login" method="post" name="form1" id="form1">
	 <table frame="box" rules="all">
        <tr>
          <td>学号:</td>
          <td><input type="text" name="std.sid" id="sid" ></td>
        </tr>
        <tr>
          <td>密码:</td>
          <td><input type="password" name="std.spwd" id="spwd" ></td>
        </tr> 
        <tr>
          <td colspan="2" align="center"><input type="submit" value="登录" ></td>
        </tr> 
      </table>
	</form>
	<a href="register.jsp">添加</a>
	<a href="index.jsp">首页</a>
	</center>
  </body>
</html>
