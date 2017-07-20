<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
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

<title>作业列表-师生作业通</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
.divzylb {
	margin-top: 20px;
}

.textarea1 {
	max-height: 400px;
	width: 100%;
	resize: none;
	border: none;
	outline: none;
}
</style>
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./layer/layer.js"></script>
<script type="text/javascript">
//删除作业
	function deleteH(hid){
		layer.confirm('确认删除？',{icon: 3,title:'注意',offset:''},function(){
			$.ajax({
				type : "post",
				url : "servlet/HDel",
				data : {
					"hid":hid
				},
				success : function(retData) {
				if(retData=="删除失败，请重试")
				{
					layer.msg("删除失败，请重试",{time:1500});
				}
				else{
					location.reload();
				}
				}
			});
		});
	}
	//发布作业
	function addH(hcid){
		layer.open({
		  title:'发布作业',
	  	  type: 2,
		  area: ['80%', '100%'],
		  fixed: false, //不固定
		  offset:'t',
		  scrollbar:false,
		  content: 'Homework/HAdd.jsp?hcid='+hcid
		});
	}
	//修改作业
	function updateH(hid)
	{
		layer.open({
		  title:'修改作业',
	  	  type: 2,
		  area: ['80%', '100%'],
		  fixed: false, //不固定
		  offset:'t',
		  scrollbar:false,
		  content: 'Homework/HEdit.jsp?hid='+hid
		});
	}
</script>
</head>

<body>
	<%
		request.setCharacterEncoding("utf-8");
		DBBean db = new DBBean();
		String hcid = request.getParameter("hcid");
	%>
	<div>
	<a href="Homework/HListTec.jsp?hcid=<%=hcid%>">作业</a>
	<a href="File/tecFileList.jsp?cid=<%=hcid%>">资料</a>
	</div>
	<br/>
<div>
<button onclick="addH('<%=hcid%>')">发布作业</button> 
</div>
	<%
	String sql = "select * from homework where hcid='" + hcid
				+ "' order by hid desc";
		ResultSet rs = db.executeQuery(sql);
		while (rs.next()) {
	%>
	<div class="divzylb">
		<table width="100%" frame="box" rules="all">
			<tr>
				<td style="width:80%;">发布日期：<%=rs.getString("hbegintime")%></td>
				<td rowspan="2">
				已交<%=rs.getString("hsubmit") %>
				未交<%=rs.getString("hnosubmit") %>
				<a href="Homework/HDetail.jsp?hid=<%=rs.getString(1) %>" id="zyxq">作业详情</a>
				</td>
			</tr>
			<tr>
				<td>作业名称：<%=rs.getString("hname")%></td>
			</tr>
			<tr>
				<td>作业内容：<br /> <textarea class="textarea1" readonly><%=rs.getString("hinfo")%></textarea>
				</td>
				<td rowspan="2">
					<div id="lytch">
						<button onclick='updateH("<%=rs.getString("hid")%>")'>编辑</button>
						<button onclick='deleteH("<%=rs.getString("hid")%>")'>删除</button>
						<a
							href="Homework/MList.jsp?hid=<%=rs.getString("hid")%>">留言详情</a>
					</div>
					</td>
			</tr>
			<tr>
				<td>截止日期：<%=rs.getString("hendtime")%></td>
			</tr>
		</table>
	</div>
	<%
		}
	%>
</body>
<script src='js/autosize.js'></script>
<script>
	autosize(document.querySelectorAll('textarea'));
</script>
</html>
