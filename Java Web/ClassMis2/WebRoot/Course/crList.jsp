<%@page import="com.jing.entity.Course"%>
<%@page import="com.jing.service.CourseService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>课程列表-班级信息管理</title>
    
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
    <jsp:directive.page import="org.springframework.web.context.WebApplicationContext"/>
  <%  
	WebApplicationContext context = (WebApplicationContext)this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);  
	CourseService crService = (CourseService)context.getBean("crService");  
	
	List<Course> course = crService.listCr();
    %>
    <center>    
       课程列表
    <br>
    <br>
    <a href="Course/crAdd.jsp">添加</a>
    <br>
    <br>
    
    <table frame="box" rules="all">
    <tr>
    <th>课程编号</th>
    <th>课程名称</th>
    <th>课程性质</th>
    <th>学分</th>
    <th>操作</th>
    </tr>
    <%for(int i=0;i<course.size();i++) { %>
    <tr>
    <td><%=course.get(i).getCrid() %></td>
    <td><%=course.get(i).getCrname() %></td>
    <td><%=course.get(i).getCrnature() %></td>
    <td><%=course.get(i).getCrcredit() %></td>
    <td>
    	<a href="./Course/crEdit.jsp?cr.crid=<%=course.get(i).getCrid() %>" >编辑</a> 
    	<a href="cr_deleteCr?cr.crid=<%=course.get(i).getCrid() %>" >删除</a> </td>
    </tr>
    <% } %>
    </table>
    <br>
    
    <br>
    <a href="index.jsp">首页</a>
    </center>
    
  </body>
</html>
