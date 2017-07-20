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
    
    <title>添加课程-班级信息管理</title>
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
  <p><span style="color:red;"><s:property value="errors.saveError[0]"/></span>
  </p>
   <form action="cr_saveCr" method="post" name="form1" id="form1">
	  <table frame="box" rules="all">
        <tr>
          <td>编号:</td>
          <td><input type="text" name="cr.crid"  ></td>
        </tr>
        <tr>
          <td>名称:</td>
          <td><input type="text" name="cr.crname"  ></td>
        </tr>
        <tr>
          <td>课程性质:</td>
          <td>
          <select name="cr.crnature" id="crnature">
          	<option value="必修">必修课</option>
          	<option value="选修">选修课</option>
          	<option value="学位">学位课</option>
          </select>
          </td>
        </tr>
        <tr>
          <td>学分:</td>
          <td><input type="text" name="cr.crcredit"  ></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" value="添加" ></td>
        </tr>
      </table>
	</form>
	<a href="index.jsp">首页</a>
	<a href="Course/crList.jsp">课程列表</a>
	</center>
  </body>
</html>
