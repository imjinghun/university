<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="com.jing.dao.DBBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>My JSP 'BookEdit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <%
	DBBean db=new DBBean();
	request.setCharacterEncoding("utf-8");
	String strID = "";
	strID = request.getParameter("id");
	String SQL = "SELECT * FROM BookInfo where id='" + strID + "'";    
	ResultSet rs = db.executeQuery(SQL);    
%>
<center>

<%if(rs.next()==true){ %>
	
  	<br><br>编辑图书信息<br>
    <form name="f1" id="f1" action="action/BookEdit.action" method="post">
      <table border="0">
        <tr>
          <td>书号:</td>
          <td><input type="text" readonly="readonly" name="id" id="ID" value="<%=rs.getString("id") %>"> 书号不允许编辑</td>
        </tr>
        <tr>
          <td>书名:</td>
          <td><input type="text" name="name" id="Name" value="<%=rs.getString("name") %>"></td>
        </tr> 
        <tr>
          <td>ISBN编号:</td>
          <td><input type="text" name="isbn" id="Isbn" value="<%=rs.getString("isbn") %>"></td>
        </tr> 
        <tr>
          <td colspan="2" align="center"><input type="submit" value=" 确定 " ></td>
        </tr>
      </table>
    </form>
<%} else { %>
<br><br>编辑图书信息<br><br>
书号为<%=strID %>的图书数据在数据库中不存在!<br><br>
<a href="BookList.jsp">返回</a>
<%} %>
</center>
    
    
    
    
  </body>
</html>
