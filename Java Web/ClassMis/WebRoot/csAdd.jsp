<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加班级-班级信息管理</title>
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
  <p><span style="color:red;"><s:property value="errors.saveError[0]"/></span>
  </p>
   <form action="cs_saveCs" method="post" name="form1" id="form1">
	  <table frame="box" rules="all">
        <tr>
          <td>编号:</td>
          <td><input type="text" name="cs.cid" id="cid" ></td>
        </tr>
        <tr>
          <td>名称:</td>
          <td><input type="text" name="cs.cname" id="cname" ></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" value="添加" ></td>
        </tr>
      </table>
	</form>
	<a href="index.jsp">首页</a>
  </body>
</html>
