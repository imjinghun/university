<%@page import="org.hibernate.Query"%>
<%@page import="com.jing.entity.Classes"%>
<%@page import="com.jing.common.HibernateSessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>班级列表-班级信息管理</title>
    
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
    Session ss = HibernateSessionFactory.getSession();
	ss.beginTransaction();
	
	Query query = ss.createQuery("from Classes");
	
	List<Classes> classes = query.list();
	ss.getTransaction().commit();
	ss.close();
     %>
    <center>    
        班级列表
    <br>
    <br>
    <a href="csAdd.jsp">添加</a>
    <br>
    <br>
    
    <table frame="box" rules="all">
    <tr>
    <th>班级编号</th>
    <th>班级名称</th>
    <th>操作</th>
    </tr>
    <%for(int i=0;i<classes.size();i++) { %>
    <tr>
    <td><%=classes.get(i).getCid() %></td>
    <td><%=classes.get(i).getCname() %></td>
    <td>
    	<a href="csEdit.jsp?cs.cid=<%=classes.get(i).getCid() %>" >编辑</a> 
    	<a href="cs_deleteCs?cs.cid=<%=classes.get(i).getCid() %>" >删除</a> </td>
    </tr>
    <% } %>
    </table>
    <br>
    
    <br>
    <a href="index.jsp">返回</a>
    </center>
    
  </body>
</html>
