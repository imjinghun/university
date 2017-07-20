<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" import="java.util.*,java.sql.*,com.jing.dao.*"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	request.setCharacterEncoding("utf-8");
	
	String hid=request.getParameter("hid");
	DBBean db=new DBBean();
	//查询作业名称 内容 创建及截止时间
	String sql="select hname,hinfo,hbegintime,hendtime from homework where hid='"+hid+"'";
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>编辑作业</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="Js/Rili/laydate.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	list-style: none;
}

html {
	background-color: #E3E3E3;
	font-size: 14px;
	color: #000;
	font-family: '微软雅黑'
}

h2 {
	line-height: 30px;
	font-size: 20px;
}

a,a:hover {
	text-decoration: none;
}

.box {
	width: 970px;
	padding: 10px 20px;
	background-color: #fff;
	margin: 10px auto;
}

.box a {
	padding-right: 20px;
}

.demo1,.demo2,.demo3,.demo4,.demo5,.demo6 {
	margin: 25px 0;
}

.layinput {
	height: 22px;
	line-height: 22px;
	width: 150px;
	margin: 0;
}
</style>

<script type="text/javascript">
	!function() {
		laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
		laydate({
			elem : '#demo'
		});//绑定元素
	}();

	//日期范围限制
	var start = {
		elem : '#hendtime',
		format : 'YYYY/MM/DD hh:mm:ss',
		min : laydate.now(), //设定最小日期为当前日期
		max : '2099/12/30', //最大日期
		istime : true,
		istoday : false,//不显示 今天 两字

	};
</script>

<script>
function inputcheck()
{
	var hname=document.getElementById("hname");
	var hinfo=document.getElementById("hinfo");
	var hendtime=document.getElementById("hendtime");
	if(hname.value.toString().trim()=="")
	{
		alert("作业名称不可空");
		hname.focus();
		return false;
	}
	if(hinfo.value.toString().trim()=="")
	{
		alert("作业内容不可空");
		hinfo.focus();
		return false;
	}
	if(hendtime.value.toString().trim()=="")
	{
		alert("截止日期不可空");
		hendtime.style.border="1px solid red";
		return false;
	}
	if(hname.value.toString().trim().length>50)
	{
	alert("作业名称过长");
	hname.focus();
	return false;
	}
	
	return true;
	
}
</script>

</head>

<body>
<%
	ResultSet rs=db.executeQuery(sql);
 	if(rs.next())
 	{
 		%>
 		<div class="box">
		<form id="form1" name="form1" method="post" action="servlet/HEdit" onsubmit="return inputcheck()">
		
		<input type="hidden" name="hid" id="hid" value="<%=hid%>" />
		<input type="hidden" name="hbegintime" id="hbegintime" value="<%=rs.getString("hbegintime")%>" />
		
			<table width="100%" border="0">
				<tr>
					<th scope="row">作业名称</th>
					<td><input placeholder="最多50字" type="text" name="hname" id="hname" width="500px" value="<%=rs.getString("hname")%>"/>50字内</td>
				</tr>
				<tr>
					<th scope="row">作业内容</th>
					<td><textarea name="hinfo" id="hinfo"  style="max-height: 500px;width: 100%;resize: none;"><%=rs.getString("hinfo")%></textarea>
</td>
				</tr>
				<tr>
					<th scope="row">截止日期</th>
					<td>
						<div class="demo2">
							<input placeholder="选择日期" class="laydate-icon" id="hendtime" name="hendtime" 
							value="<%=rs.getString("hendtime") %>" onClick="laydate(start)" readonly>
						</div></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="确认" />
					</td>
				</tr>
			</table>
		</form>
	</div>
 		<%
 	}
 	else
 	{
 	%>
 	meiyou
 	<% 
 	}
 %>
	
</body>

<script src='Js/autosize.js'></script>
<script>
	autosize(document.querySelectorAll('textarea'));
</script>

</html>
