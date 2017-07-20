<%@page import="com.jing.entity.Classes"%>
<%@page import="com.jing.service.ClassesService"%>
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
    <title>编辑班级信息-班级信息管理</title>
    
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
	ClassesService csService = (ClassesService)context.getBean("csService");  
%> 
  <%
  	// 获取数据
	request.setCharacterEncoding("utf-8");
	String strID = "";
	strID = request.getParameter("cs.cid");
	Classes classes = csService.findById(strID);
   %>
<center>
<h2>编辑班级信息</h2>
<%if(classes != null){ %>
	
    <form name="f1" id="f1" action="cs_updateCs" method="post">
      <table frame="box" rules="all">
        <tr>
          <td>班级编号:</td>
          <td><input type="text" readonly="readonly" name="cs.cid" id="cid" value="<%=classes.getCid() %>"></td>
        </tr>
        <tr>
          <td>班级名称:</td>
          <td><input type="text" name="cs.cname" id="cname" value="<%=classes.getCname() %>"></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" value="确定 " ></td>
        </tr>
      </table>
    </form>
<%} else { %>
班级编号为<%=strID %>的班级数据在数据库中不存在!<br><br>
<a href="./Classes/csList.jsp">返回</a>
<%} %>
</center>
  </body>
</html>
