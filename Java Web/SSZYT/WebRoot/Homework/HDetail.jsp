<%@ page language="java" import="java.util.*,java.sql.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件列表-师生作业通</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <table frame="box" rules="all">
  <tr>
    	<td>资料名</td>
    	<td>上传时间</td>
    	<td>操作</td>
    	</tr>
    <%
    	request.setCharacterEncoding("utf-8");
    	DBBean db=new DBBean();
    	String hid=request.getParameter("hid");
    	String sql="select * from smaterial where smhid = '"+hid+"'order by smid desc";
    	ResultSet rs =db.executeQuery(sql);

    	while(rs.next())
    	{
    	%>
    	<tr>
    	<td><%
    	String name=rs.getString("smname").substring(rs.getString("smname").indexOf("_")+1);;
		out.print(name);
    	 %></td>
    	<td><%=rs.getString("smtime") %></td>
    	<td>
    	<a href="./servlet/download?mtid=<%=rs.getString("smid")%>"><button>下载</button></a>
    	</td>
    	</tr>
    	
    	<%
    	}
    	db.close();
     %>
     </table>
  </body>
</html>
