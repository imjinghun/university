<%@page import="com.jing.entity.Grade"%>
<%@page import="com.jing.service.GradeService"%>
<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>课程信息列表-班级信息管理</title>
    
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
	GradeService gdService = (GradeService)context.getBean("gdService");  
	
	List<Object[]> list = gdService.listCG();
    if(list.size()!=0)
	{
		int i=0;//为了只得到一次学生学号姓名
		for(Iterator<Object[]> iterator=list.iterator();iterator.hasNext();){ 
			i++;
            Object[] objects = (Object[]) iterator.next(); 
            %>
	<center>
		<%if(i==1){ %>
		<br><br>
		课程信息列表
		<br/><br>
		<table frame="box" rules="all">
			<tr>
				<th>课程编号</th>
				<th>课程名称</th>
				<th>最高分</th>
				<th>最低分</th>
				<th>平均分</th>
			</tr>
			<%} %>
			<tr>
				<td><%=objects[0]%></td>
				<td><%=objects[1]%></td>
				<td><%=objects[2]%></td>
				<td><%=objects[3]%></td>
				<td><%
				DecimalFormat df=new DecimalFormat(".##");
				String st=df.format(objects[4]);
				out.print(st);
				%></td>
			</tr>
			<%}%>
		</table>
		<% }else{out.print("没有信息");}%>
		<br> 
		<br> <a href="index.jsp">返回</a>
	</center>
    
  </body>
</html>
