<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" import="java.util.*,java.sql.*,com.jing.dao.*"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	DBBean db=new DBBean();
	String sql="select * from homework order by hid desc";//where hcid=''确定课程号
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>作业列表-师生作业通</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.divzylb{
margin-top:20px;
}

.textarea1{
max-height: 400px;
width:100%;
resize:none;
border:none;
outline:none;
}
</style>

</head>

<body>
	<%
	ResultSet rs=db.executeQuery(sql);
 	while(rs.next())
 	{
 		%>
	<div class="divzylb">
		<table width="100%" frame="box" rules="all">
			<tr>
				<td style="width:80%;">发布日期：<%=rs.getString("hbegintime") %></td>
				<td rowspan="2"><a href="Hxq.jsp" id="zyxq">作业详情</a></td>
			</tr>
			<tr>
				<td>作业名称：<%=rs.getString("hname") %></td>
			</tr>
			<tr>
				<td>作业内容：<br /> <textarea class="textarea1" readonly><%=rs.getString("hinfo") %></textarea>
				</td>
				<td rowspan="2">
					<div id="lytch">
						<a href="HEdit.jsp?hid=<%=rs.getString("hid")%>">编辑</a> 
						<a href="servlet/HDel?hid=<%=rs.getString("hid")%>"
							onclick="javascript:return confirm('确认删除?');">删除</a> 
						<a href="MList.jsp?hid=<%=rs.getString("hid")%>">留言详情</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>截止日期：<%=rs.getString("hendtime") %></td>
			</tr>
		</table>
	</div>
	<%}%>
</body>
<script src='JS/autosize.js'></script>
<script>
	autosize(document.querySelectorAll('textarea'));
</script>
</html>
