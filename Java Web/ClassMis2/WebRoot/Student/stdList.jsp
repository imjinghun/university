<%@page import="com.jing.entity.Student"%>
<%@page import="com.jing.service.StudentService" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生列表-班级信息管理</title>
    
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
	StudentService stdService = (StudentService)context.getBean("stdService");  
	List<Student> students = stdService.listStd();
     %>
    <center>    
        学生列表
    <br>
    <br>
    <a href="register.jsp">添加</a>
    <br>
    <br>
    
    <table frame="box" rules="all">
    <tr>
    <th>学号</th>
    <th>姓名</th>
    <th>性别</th>
    <th>出生日期</th>
    <th>联系电话</th>
    <th>家庭住址</th>
    <th>班级编号</th>
    <th>班级名称</th>
    <th>操作</th>
    </tr>
    <%for(int i=0;i<students.size();i++) { %>
    <tr>
    <td><%=students.get(i).getSid() %></td>
    <td><%=students.get(i).getSname() %></td>
    <td><%=students.get(i).getSsex() %></td>
    <td><%=students.get(i).getSbirth() %></td>
    <td><%=students.get(i).getStel() %></td>
    <td><%=students.get(i).getSaddress() %></td>
    <td><%=students.get(i).getClasses().getCid() %></td>
    <td><%=students.get(i).getClasses().getCname() %></td>
    <td>
    	<a href="./Student/stdEdit.jsp?std.sid=<%=students.get(i).getSid() %>" >编辑</a> 
    	<a href="std_deleteStd?std.sid=<%=students.get(i).getSid() %>" >删除</a> </td>
    </tr>
    <% } %>
    </table>
    <br>
    
    <br>
    <a href="index.jsp">返回</a>
    </center>
    
  </body>
</html>
