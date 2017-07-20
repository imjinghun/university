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
<!-- <link rel="stylesheet" href="css/site.css"> -->
<script type="text/javascript">
	$(function() {
		$("#btnCCrs").click(createCrs);
	});
	//添加课程
	function createCrs() {
		//调用layer.prompt方法
		layer.prompt({
			title : '输入课程名称'
		}, function(val, index) {

		if(val.trim()!="")
		{
		$.ajax({
				type : "post",
				url : "./servlet/CourseAdd",
				data : {
					"tcname" : val
				},
				success : function() {
					location.reload();
				}
			});
			layer.close(index);
		}
		else{
			layer.msg("课程名不能为空",{time:1000});
		}
		});
	}
	//修改课程
	function updateCrs(id,name){
	var crsid=id;
	var crsname=name;
		layer.prompt({
			title : '输入课程名称',
			value: crsname
		}, function(val, index) {

		if(val.trim()!="")
		{
		$.ajax({
				type : "post",
				url : "./servlet/CourseEdit",
				data : {
					"tcid":crsid,
					"tcname" : val
				},
				success : function() {
					location.reload();
				}
			});
			layer.close(index);
		}
		else{
			layer.msg("课程名不能为空",{time:1000});
		}
		});
	}
	//删除课程
	function deleteCrs(id){
		var crsid=id;
		layer.confirm('确认删除？',{icon: 3,title:'注意'},function(){
			$.ajax({
				type : "post",
				url : "./servlet/CourseDel",
				data : {
					"tcid":crsid
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

	<a href="tecinfo.jsp">个人信息</a>
	<%
		request.setCharacterEncoding("utf-8");
		String username = (String) request.getSession().getAttribute(
				"username");
	%>
	<h1>创建课程</h1>
	<button id="btnCCrs">创建课程</button>

	<h1>课程列表</h1>
	<table width="95%" frame="box" rules="all" align="center" id="table0">
		<thead>
			<tr>
				<th width=20% align="center">课程号</th>
				<th width=30% align="center">课程名称</th>
				<th width=10% align="center">课程人数</th>
				<th width=10% align="center">创建日期</th>
				<th width=10% align="center">操作</th>
				<!-- <td width=10% align="center">发布作业</td> -->
			</tr>
		</thead>
		<%
			request.setCharacterEncoding("utf-8");
			DBBean db = new DBBean();
			
			String sql = "select * from tcourse where tctid='"+username+"' order by tcid desc";
			ResultSet rs = db.executeQuery(sql);
			while (rs.next())
			{
		%>
		<tr>
			<td width=20% align="center"><%=rs.getString("tcid")%></td>
			<td width=30% align="center"><a
				href="Homework/HListTec.jsp?hcid=<%=rs.getString("tcid")%>"><%=rs.getString("tcname")%></a>
			</td>
			<td width=10% align="center"><%=rs.getString("tcnumber")%></td>
			<td width=10% align="center"><%=rs.getString("tctime")%></td>
			<td width=10% align="center">
				<button id="btnUCrs"
					onclick='updateCrs("<%=rs.getString("tcid")%>","<%=rs.getString("tcname")%>")'>修改</button>
				<button id="btnDCrs"
					onclick='deleteCrs("<%=rs.getString("tcid")%>")'>删除</button>
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
