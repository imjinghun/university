<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>课程-师生作业通</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./layer/layer.js"></script>
	<script type="text/javascript" src="./js/common.js"></script>


  </head>
  
  <body>
   <button onclick="quit()">退出系统</button>
   <button onclick="revisePwd()">修改密码</button>
  <a href="admininfo.jsp">个人信息</a>
  <br/><br/>
 <div>
  老师
  <jsp:include page="stdList.jsp"></jsp:include><br/><br/>
  </div>
   <div>
  学生
  <jsp:include page="tecList.jsp"></jsp:include>
    </div>
  </body>
</html>
