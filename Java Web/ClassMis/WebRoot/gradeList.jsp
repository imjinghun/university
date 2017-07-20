<%@page import="org.hibernate.Query"%>
<%@page import="com.jing.entity.Grade"%>
<%@page import="com.jing.common.HibernateSessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生课程列表-班级信息管理</title>
    
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
    <%
    Session ss = HibernateSessionFactory.getSession();
	ss.beginTransaction();
	
	Query query = ss.createQuery("select g.id.course.crid,g.id.course.crname,max(g.ggrade),min(g.ggrade),avg(g.ggrade) from Grade g,Course c where g.id.course.crid=c.crid group by g.id.course.crid,g.id.course.crname");
	
	List<Object[]> list = query.list();
	ss.getTransaction().commit();
	ss.close();
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
				<td><%=objects[4]%></td>
			</tr>
			<%}%>
		</table>
		<% }else{out.print("没有信息");}%>
		<br> 
		<br> <a href="index.jsp">返回</a>
	</center>
    
  </body>
</html>
