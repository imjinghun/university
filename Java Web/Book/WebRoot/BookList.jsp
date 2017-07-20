<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="com.jing.dao.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	DBBean db=new DBBean();
	String sql="select * from BookInfo"; 
	
	ResultSet rs=db.executeQuery(sql);
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BookList.jsp' starting page</title>
    
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
        图书列表
    <br>
    <br>
    <a href="BookAdd.html">添加</a>
    <br>
    <br>
    
    <table border="1" cellspacing="0" cellpadding="4">
    <tr>
    <th>书号</th><th>书名</th><th>ISBN编号</th>
    </tr>
    <%while (rs.next()) { %>
    <tr>
    <td><%=rs.getString("id") %></td>
    <td><%=rs.getString("name") %></td>
    <td><%=rs.getString("isbn") %></td>
    <td>
    	<a href="BookEdit.jsp?id=<%=rs.getString("id") %>" >编辑</a> 
    	<a href="action/BookDelete.action?id=<%=rs.getString("id") %>" >删除</a> </td>
    </tr>
    <% } %>
    </table>
    <br>
    
    <br>
    <a href="index.jsp">退出</a>
    </center>
  </body>
</html>
