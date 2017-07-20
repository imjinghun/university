<%@page import="com.jing.entity.Grade"%>
<%@page import="com.jing.service.GradeService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>学生课程信息-班级信息管理</title>

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
	GradeService gdService = (GradeService)context.getBean("gdService");  
	%>
	<%
    request.setCharacterEncoding("utf-8");
	String strID = "";
	strID = request.getParameter("stdId");
	List<Object[]> list = gdService.listXC(strID);
	//System.out.println(list.size());
	if(list.size()!=0)
	{
		int i=0;//为了只得到一次学生学号姓名
		for(Iterator<Object[]> iterator=list.iterator();iterator.hasNext();){ 
			i++;
            Object[] objects = (Object[]) iterator.next(); 
            %>
	<center>
		<%if(i==1){ out.print("<br><br>【 学号："+strID+"，姓名："+objects[0] +"】的课程信息列表");%>
		<br/><br>
		学分汇总：<label id="sumcredit"></label>
		<br/><br>
		<table frame="box" rules="all">
			<tr>
				<th>课程编号</th>
				<th>课程名称</th>
				<th>学分</th>
				<th>成绩</th>
			</tr>
			<%} %>
			<tr>
				<td>
					<%
					if(objects[4]!=null && (Double)objects[4]<60)
            {out.print("<font color='red'>"+objects[1]+"</font>");}//
            else{out.print(objects[1]);}
             %>
				<td>
					<%if(objects[4]!=null && (Double)objects[4]<60)
            {out.print("<font color='red'>"+objects[2]+"</font>");}//
            else{out.print(objects[2]);}
             %>
				<td>
					<%
					if(objects[4]==null){out.print("0.0");}
					else if((Double)objects[4]<60){out.print("0.0");%>
             	<input type="hidden" name="credit" value="0.0">
             <%}else{out.print(objects[3]);%>
            	<input type="hidden" name="credit" value="<%=objects[3]%>">
            	<%} %>
				<td><%
					if(objects[4]==null){out.print("无");}
					else{out.print(objects[4]);}
				 %></td>
			</tr>
			<%}%>
		</table>
		<% }else{out.print("学号为【"+strID+"】学生不存在");}%>
		<br> 
		<br> <a href="index.jsp">返回</a>
	</center>

</body>
<script type="text/javascript">
	var credit=document.getElementsByName("credit");
	var sum=0.0,s;
	for(var i=0;i<credit.length;i++)
	{
		s=Number(credit[i].value.toString());
		sum+=s;
	}
	document.getElementById("sumcredit").innerText=sum;
</script>
</html>
