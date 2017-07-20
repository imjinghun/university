<%@ page language="java" import="java.util.*,java.sql.*,dao.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>课程-师生作业通</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./layer/layer.js"></script>
<script type="text/javascript" src="./js/common.js"></script>
<script type="text/javascript" src="js/slimtable.min.js"></script>
<link rel="stylesheet" href="css/slimtable.css">
<script type="text/javascript">
    //加入课程
	function inCrs(){
		layer.prompt({
				title : '输入课程号'
			}, function(val, index) {
	
			if(val.trim()!="")
			{
			$.ajax({
					type : "post",
					url : "./servlet/stdAddCourse",
					data : {
						"scid" : val
					},
					success : function(retData) {
					if(retData=="已经加入此课程")
					{
					layer.msg("已经加入此课程",{time:1000});
					}
					else if(retData=="课程不存在")
					{
					layer.msg("课程不存在",{time:1000});
					}
					else{
					location.reload();
					}
					}
				});
			
			}
			else{
				layer.msg("课程号不能为空",{time:1000});
			}
			});
	}
    //退出课程
	function outCrs(id){
		var crsid=id;
		layer.confirm('确认退出？',{icon: 3,title:'注意'},function(){
			$.ajax({
				type : "post",
				url : "./servlet/stdDelCourse",
				data : {
					"scid":crsid
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

		<button onclick="quit()">退出系统</button>
<button onclick="revisePwd()">修改密码</button>
		<a href="stdinfo.jsp">个人信息</a>
		<h1>加入课程</h1>
		<button onclick="inCrs()">加入课程</button>


	<%
		request.setCharacterEncoding("utf-8");
		String username = (String) request.getSession().getAttribute(
				"username");
	%>
	<h1>课程列表</h1>
	<table width="95%" frame="box" rules="all" align="center" id="table0">
	<thead>	
		<tr>
			<th width=20% align="center">课程号</th>
			<th width=30% align="center">课程名称</th>
			<th width=10% align="center">加入日期</th>
			<th width=10% align="center">操作</th>
			<th width=10% align="center">课程资料</th>
		</tr>
</thead>
		<%
			DBBean db = new DBBean();
			String q = "";
			q = "select * from scourse where scsid='" + username
					+ "' order by scid desc";
			ResultSet rs = db.executeQuery(q);
			int i = 0;
			while (rs.next())
			{
		%>
		<tr>
			<td width=20% align="center"><%=rs.getString("scid")%></td>
			<td width=30% align="center"><a
				href="Homework/HListStd.jsp?hcid=<%=rs.getString(1)%>"><%=rs.getString("scname")%></a>
			</td>
			<td width=10% align="center"><%=rs.getString("sctime")%></td>
			<td width=10% align="center">
				<button onclick='outCrs("<%=rs.getString("scid")%>")'>退出课程</button>
			</td>
			<td><a href="File/tecFileList.jsp?cid=<%=rs.getString("scid")%>">资料</a>
			</td>
		</tr>
		<%
			}
			db.close();
		%>
	</table>
	<script type="text/javascript">
		$(function() {
			$("#table0").slimtable();
		});
	</script>
</body>
</html>