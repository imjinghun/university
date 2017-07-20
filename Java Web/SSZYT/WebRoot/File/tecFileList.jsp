<%@ page language="java" import="java.util.*,java.sql.*,dao.*"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript">
	//文件删除
	function delFile(id)
	{
		layer.confirm('确认删除?', {icon: 3,title:'注意'},
		function(index){
			$.ajax({
				type:"post",
				url:"./servlet/delete",
				data:{
				"mtid":id
				},
				success:function(){
					location.reload();
				}
			});
		});
	}
	//上传文件
	function uploadFile(cid)
	{
		layer.open({
		  title:'上传资料',
	  	  type: 2,
		  area: ['450px', '320px'],
		  fixed: false, //不固定
		  offset:'t',
		  scrollbar:false,
		  content: 'File/upload.jsp?cid='+cid,
		  end:function(){
		  	location.reload();
		  }
		});
	}
</script>

</head>

<body>
	<%
    	request.setCharacterEncoding("utf-8");
    	DBBean db=new DBBean();
    	String cid=request.getParameter("cid");
    	String role=(String)session.getAttribute("role");
   		if(role.equals("teacher")){
     %>
	<div>
		<a href="Homework/HListTec.jsp?hcid=<%=cid%>">作业</a> 
		<a href="File/tecFileList.jsp?cid=<%=cid%>">资料</a>
	</div>
	<br />
	<div>
		<button onclick="uploadFile('<%=cid%>')">上传资料</button>
	</div>
	<%} if(role.equals("student")){%>
	<div>
		<a href="Homework/HListStd.jsp?hcid=<%=cid%>">作业</a> 
		<a href="File/tecFileList.jsp?cid=<%=cid%>">资料</a>
	</div>
	<%}%>
	<br />
	<div>
		<table frame="box" rules="all">
			<tr>
				<td>资料名</td>
				<td>上传时间</td>
				<td>操作</td>
			</tr>
			<%
    	String sql="select * from tmaterial where tmcid = '"+cid+"'order by tmid desc";
    	ResultSet rs =db.executeQuery(sql);
    	while(rs.next())
    	{
    	%>
			<tr>
				<td>
				<%
    	String name=rs.getString("tmname").substring(rs.getString("tmname").indexOf("_")+1);;
		out.print(name);
    	 %>
				</td>
				<td><%=rs.getString("tmtime") %></td>
				<td>
				<a href="./servlet/downloadcommon?mtid=<%=rs.getString("tmid")%>"><button>下载</button></a> 
				<%if(role.equals("teacher")){%>
				<button onclick='delFile("<%=rs.getString("tmid")%>")'>删除</button>
				<%} %>
				</td>
			</tr>

			<%
    	}
    	db.close();
     %>
		</table>
	</div>
</body>
</html>
