<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页-班级信息管理</title>
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
    <a href="stdList.jsp">学生列表</a> <br><br>
    <a href="csList.jsp">班级列表</a> <br><br>
    <a href="crList.jsp">课程列表</a> <br><br>
    <a href="grade_Xuanke">成绩录入</a> <br><br>
    <a href="gradeList.jsp">统计课程分数信息</a> <br><br>
    
    <form action="xsCrList.jsp" method="post" name="form1">
     统计学生课程信息：<br/>
     输入学号查询: <input type="text" name="stdId" id="stdId"/>
     <input type="submit" value="查询" />
    </form>
    
  </body>
</html>
