<%@ page language="java" import="java.util.*,java.sql.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生列表-师生作业通</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./layer/layer.js"></script>
<script type="text/javascript">
//退出课程
	function delStd(role,id){
		layer.confirm('确认删除？',{icon: 3,title:'注意'},function(){
			$.ajax({
				type : "post",
				url : "./servlet/DeleteUser",
				data : {
					"role":role,
					"id":id
				},
				success : function() {
					location.reload();
				}
			});
		});
	}
</script>
  </head>
  
  <body>
  <table frame="box" rules="all">
   	<tr>
   		<td>编号</td>
   		<td>账号</td>
   		<td>学号</td>
   		<td>姓名</td>
   		<td>学校名称</td>
   		<!-- <td>操作</td> -->
   	</tr>
  <% 
  request.setCharacterEncoding("utf-8");
  DBBean db=new DBBean();
  ResultSet rs=db.executeQuery("select * from student");
  int i=0;
  while(rs.next())
  { i++;
  %>
   	<tr>
   		<td><%=i %></td>
   		<td><%=rs.getString("sid") %></td>
   		<td><%=rs.getString("sno") %></td>
   		<td><%=rs.getString("sname") %></td>
   		<td><%=rs.getString("sschool") %></td>
   		<%-- <td>
   		<button onclick="delStd('student','<%=rs.getString("sid")%>')">删除</button></td> --%>
   	</tr>
  <%
  }
  %>
   </table>
  </body>
</html>
