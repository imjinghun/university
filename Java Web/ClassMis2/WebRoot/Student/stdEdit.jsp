<%@page import="com.jing.entity.Student"%>
<%@page import="com.jing.service.StudentService" %>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>编辑学生信息-班级信息管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <jsp:directive.page import="org.springframework.web.context.WebApplicationContext"/>
  <%  
	WebApplicationContext context = (WebApplicationContext)this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);  
	StudentService stdService = (StudentService)context.getBean("stdService");  
	%>
  <%
  	// 获取数据
	request.setCharacterEncoding("utf-8");
	String strID = "";
	strID = request.getParameter("std.sid");
  
	Student student = stdService.findById(strID);
   %>
<center>
<h2>编辑学生信息</h2>
<p><span style="color:red;"><s:property value="errors.updError[0]"/></span>
<%if(student != null){ %>
	
    <form name="f1" id="f1" action="std_updateStd" method="post">
      <table frame="box" rules="all">
        <tr>
          <td>学号:</td>
          <td><input type="text" readonly="readonly" name="std.sid" id="sid" value="<%=student.getSid() %>"></td>
        </tr>
        <tr>
          <td>班级编号:</td>
          <td><input type="text" name="classid" id="classid" value="<%=student.getClasses().getCid() %>"></td>
        </tr>
        <tr>
          <td>密码:</td>
          <td><input type="text" name="std.spwd" id="spwd" value="<%=student.getSpwd() %>"></td>
        </tr> 
        <tr>
          <td>姓名:</td>
          <td><input type="text" name="std.sname" id="sname" value="<%=student.getSname() %>"></td>
        </tr> 
         
        <tr>
          <td>性别:</td>
          <td>
          <input type="hidden" id="sex"  value="<%=student.getSsex() %>"/>
          <label for="boy">男</label>
		  <input type="radio" name="std.ssex" value="男" id="boy">
		  <label for="gril">女</label>
		  <input type="radio" name="std.ssex" value="女" id="gril">
          </td>
        </tr> 
        <tr>
          <td>出生日期:</td>
          <td><input type="text" name="std.sbirth" id="sbirth" value="<%=student.getSbirth() %>"></td>
        </tr> 
        <tr>
          <td>联系电话:</td>
          <td><input type="text" name="std.stel" id="stel" value="<%=student.getStel() %>"></td>
        </tr> 
        <tr>
          <td>家庭住址:</td>
          <td><input type="text" name="std.saddress" id="saddress" value="<%=student.getSaddress() %>"></td>
        </tr> 
        
        <tr>
          <td colspan="2" align="center"><input type="submit" value="确定 " ></td>
        </tr>
      </table>
    </form>
<%} else { %>
学号为<%=strID %>的学生数据在数据库中不存在!<br><br>
<a href="./Student/stdList.jsp">返回</a>
<%} %>
</center>
  </body>
  <script type="text/javascript">
	  var sex=document.getElementById("sex").value;
	  if(sex=="男")
	  {
	  	document.getElementsByName("std.ssex")[0].checked=true;
	  }
	  if(sex=="女")
	  {
	  	document.getElementsByName("std.ssex")[1].checked=true;
	  }
  </script>
</html>
