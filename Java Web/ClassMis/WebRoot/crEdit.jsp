<%@page import="com.jing.entity.Course"%>
<%@page import="com.jing.common.HibernateSessionFactory"%>
<%@page import="org.hibernate.Session"%>
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
    <title>编辑课程信息-班级信息管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <%
  	// 获取数据
	request.setCharacterEncoding("utf-8");
	String strID = "";
	
	strID = request.getParameter("cr.crid");
  
    Session ss = HibernateSessionFactory.getSession();
	ss.beginTransaction();
	
	Course course = (Course)ss.get(Course.class, strID);

	ss.getTransaction().commit();
	ss.close();
    
    
   %>
<center>
<h2>编辑课程信息</h2>
<%if(course != null){ %>
	
    <form name="f1" id="f1" action="cr_updateCr" method="post">
      <table frame="box" rules="all">
        <tr>
          <td>课程编号:</td>
          <td><input type="text" readonly="readonly" name="cr.crid" id="crid" value="<%=course.getCrid() %>"></td>
        </tr>
        <tr>
          <td>课程名称:</td>
          <td><input type="text" name="cr.crname" id="crname" value="<%=course.getCrname() %>"></td>
        </tr>
        <tr>
          <td>课程性质:</td>
          <td>
          	  <input type="hidden" name="crnature" id="cr" value="<%=course.getCrnature() %>">
	          <select name="cr.crnature" id="crnature">
	          	<option value="必修">必修课</option>
	          	<option value="选修">选修课</option>
	          	<option value="学位">学位课</option>
	          </select>
          </td>
        </tr>
        <tr>
          <td>学分:</td>
          <td><input type="text" name="cr.crcredit" id="crcredit" value="<%=course.getCrcredit() %>"></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" value="确定 " ></td>
        </tr>
      </table>
    </form>
<%} else { %>
课程编号为<%=strID %>的课程数据在数据库中不存在!<br><br>
<a href="crList.jsp">返回</a>
<%} %>
</center>
  </body>
<script type="text/javascript">
	var crnature = document.getElementById("cr").value;
	var cn = document.getElementById("crnature");
	var op=cn.options;
	for ( var i = 0; i < op.length; i++) {
		if (cn.options[i].value == crnature) {
			cn.options[i].selected = true;
			break;
		}
	}
</script>

</html>
