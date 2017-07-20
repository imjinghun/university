<%@page import="org.hibernate.Query"%>
<%@page import="com.jing.entity.Grade"%>
<%@page import="com.jing.common.HibernateSessionFactory"%>
<%@page import="org.hibernate.Session"%>
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
    
    <title>成绩录入-班级信息管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function setGrade()
	{
		var g=document.getElementsByName("gscore");
		for(var i=0;i<g.length;i++)
		{
			if(g[i].value=="")
			{
				g[i].style.display="none";
				g[i].value="-1";
			}
		}
	}
	</script>
  </head>
  
  <body>
  <%
    Session ss = HibernateSessionFactory.getSession();
	ss.beginTransaction();
	
	Query query = ss.createQuery("from Grade");
	
	List<Grade> grade = query.list();
	ss.getTransaction().commit();
	ss.close();
     
   %>
   <form action="grade_saveGrade" method="post" name="form1" id="form1" onsubmit="">
	  <table frame="box" rules="all">
	  <tr>
    <th>学号</th>
    <th>姓名</th>
    <th>课程编号</th>
    <th>课程名称</th>
    <th>成绩</th>
    </tr>
    <%for(int i=0;i<grade.size();i++) { %>
    <tr>
    <td><%=grade.get(i).getId().getStudent().getSid() %></td>
    <td><%=grade.get(i).getId().getStudent().getSname() %></td>
    <td><%=grade.get(i).getId().getCourse().getCrid() %></td>
    <td><%=grade.get(i).getId().getCourse().getCrname() %></td>
    <td><%if(grade.get(i).getGgrade()!=null){ out.print(grade.get(i).getGgrade()+
    "<input type='hidden' name='gscore' value="+grade.get(i).getGgrade()+" >"); } else {%>
    <input type="text" name="gscore" >
    <%} %>
    <input type="hidden" name="sid" value="<%=grade.get(i).getId().getStudent().getSid()%>">
    <input type="hidden" name="crid" value="<%=grade.get(i).getId().getCourse().getCrid()%>">
    </td>
    
    </tr>
    <% } %>
        <tr>
          <td colspan="2" align="center"><input type="submit" value="一键录入" ></td>
        </tr>
      </table>
	</form>
	
	<a href="index.jsp">首页</a>
  </body>
</html>
