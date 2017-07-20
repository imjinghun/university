<%@ page language="java" import="java.util.*,java.sql.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生个人信息-师生作业通</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/jquery.js"></script>
	<script>
	$(function(){
		$("#edit").click(function(){
			$("#before").hide();
			$("#after").show();
		});
		$("#cancel").click(function(){
			$("#before").show();
			$("#after").hide();
		});
	});
	function check()
	{
		if($("#sno").val().trim()=="")
		{
			alert("学号不可空");
			return false;
		}
		if($("#name").val().trim()=="")
		{
			alert("姓名不可空");
			return false;
		}
		if($("#school").val().trim()=="")
		{
			alert("学校不可空");
			return false;
		}
	}
	</script>
  </head>
  
  <body>
    <%
    DBBean db=new DBBean();
    String username=(String)session.getAttribute("username");
    
	String sql="select * from student where sid='"+username+"'";
    ResultSet rs=db.executeQuery(sql);
	if(rs.next())
	{%>
		<div id="before">
			<table frame="box" rules="all">
				<tr>
					<td>账号</td>
					<td><%=rs.getString(1)%></td>
				</tr>
				<tr>
					<td>学号</td>
					<td><%=rs.getString(3)%></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><%=rs.getString(4)%></td>
				</tr>
				<tr>
					<td>学校</td>
					<td><%=rs.getString(5)%></td>
				</tr>
			</table>
			<button id="edit">修改</button>
		</div>
		<div id="after" style="display:none;">
		 <form action="servlet/UpdateUser" method="post" name="form1" onsubmit="return check()"> 
			<table frame="box" rules="all">
				<tr>
					<td>账号</td>
					<td><%=rs.getString(1)%></td>
				</tr>
				<tr>
					<td>学号</td>
					<td><input name="sno" id="sno" value="<%=rs.getString(3)%>" />
					</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input name="name" id="name" value="<%=rs.getString(4)%>" />
					</td>
				</tr>
				<tr>
					<td>学校</td>
					<td><input name="school" id="school" value="<%=rs.getString(5)%>" />
					</td>
				</tr>
			</table>
			<input type="submit" value="修改" >
			</form>
			<button id="cancel">取消</button>
		</div>
	
	<%}%>
  </body>
</html>
