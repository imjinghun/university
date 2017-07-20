<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>显示</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <div>
    <h1>登录成功</h1>
    	<!-- 	<table frame="box" rules="all" align="center">
    			<tr>
    				<td>用户名</td>
    				<td></td>
    			</tr>
    			<tr>
    				<td>密码</td>
    				<td></td>
    			</tr>
    			<tr>
    				<td colspan="2" align="center">
    					<input type="button" value="登录" 
    					onclick="javascript:window.location.href='login.jsp';"/>
    					<input type="button" name="register" value="注册" 
    					onclick="javascript:window.location.href='register.jsp';"/>
    				</td>
    			</tr>
    		</table> -->
    	
    </div>
  </body>
</html>
