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
    
    <title>注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <div>
     <h3><s:property value="errors.msg[0]"/></h3>
    	<form action="mvc_register" method="post">
    		<table frame="box" rules="all" align="center">
    			<tr>
    				<td>用户名</td>
    				<td><input type="text" name="username" /></td>
    			</tr>
    			<tr>
    				<td>密码</td>
    				<td><input type="password" name="password" /></td>
    			</tr>
    			<tr>
    				<td colspan="2" align="center">
    					<input type="submit" name="submit" value="确认"/>
    					<input type="button" value="登录" 
    					onclick="javascript:window.location.href='login.jsp';"/>
    				</td>
    			</tr>
    		</table>
    	</form>
    </div>
  </body>
</html>
