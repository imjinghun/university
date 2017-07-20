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
    
    <title>添加学生-班级信息管理</title>
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
   <form action="std_register" method="post" name="form1" id="form1">
	  <table frame="box" rules="all">
        <tr>
          <td>学号:</td>
          <td><input type="text" name="std.sid" id="sid" ></td>
        </tr>
        <tr>
          <td>班级编号:</td>
          <td><input type="text" name="classid" id="classid" ></td>
        </tr>
        <tr>
          <td>密码:</td>
          <td><input type="password" name="std.spwd" id="spwd" ></td>
        </tr> 
        <tr>
          <td>姓名:</td>
          <td><input type="text" name="std.sname" id="sname" ></td>
        </tr> 
         
        <tr>
          <td>性别:</td>
          <td>
          <input type="hidden" id="sex" />
          <label for="boy">男</label>
		  <input type="radio" name="std.ssex" value="男" id="boy">
		  <label for="gril">女</label>
		  <input type="radio" name="std.ssex" value="女" id="gril">
          </td>
        </tr> 
        <tr>
          <td>出生日期:</td>
          <td><input type="text" name="std.sbirth" id="sbirth" ></td>
        </tr> 
        <tr>
          <td>联系电话:</td>
          <td><input type="text" name="std.stel" id="stel" ></td>
        </tr> 
        <tr>
          <td>家庭住址:</td>
          <td><input type="text" name="std.saddress" id="saddress" ></td>
        </tr> 
        
        <tr>
          <td colspan="2" align="center"><input type="submit" value="添加" ></td>
        </tr>
      </table>
	</form>
	<a href="index.jsp">首页</a>
  </body>
</html>
