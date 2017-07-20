<%@ page language="java" import="java.util.*,java.sql.*,dao.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	request.setCharacterEncoding("utf-8");
	DBBean db = new DBBean();
	String hid = request.getParameter("hid");
	String sql = "select mid,msg from message where mhid='" + hid + "'";
	ResultSet rs = db.executeQuery(sql);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>作业留言列表-师生作业通</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<style type="text/css">
.textarea2 {
	max-height: 150px;
	width: 100%;
	resize: none;
	border: none;
	outline: none;
}

.textarea3 {
	max-height: 200px;
	width: 100%;
	resize: none;
}
</style>

<script type="text/javascript">
	function setMsg(id) {

		var num = id;//判断点击哪个btn按钮 从而实现对应的留言存储
		var mid = document.getElementById("mid" + num).value;
		var date = getNowFormatDate();
		var msg = document.getElementById("msg" + num).value.toString().trim();
		var msgbefore = document.getElementById("msgbefore" + num).value.toString().trim();
		var newmsg = "";
		if(msg=="")
		{
			layer.tips("内容不能为空","#msg"+num);
			$("#msg"+num).focus();
			return;
		}
		newmsg = msgbefore + "\r\n老师(" + date + "):" + msg;

		var cs = "mid=" + mid + "&msg=" + newmsg;

		loadAjax(cs);
	}

	function loadAjax(cs) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				if (xmlhttp.responseText == "success") {
					location.reload();
				} else {
					layer.alert("回复留言失败");
				}
			}
		};
		//url不行 试试为 "./servlet/MsgTch" ./当前目录 
		xmlhttp.open("POST", "servlet/MsgTch", true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send(cs);
	}

	function getNowFormatDate() {
		var date = new Date();

		var seperator1 = "/";
		var seperator2 = ":";

		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var hours = date.getHours();
		var minutes = date.getMinutes();
		var seconds = date.getSeconds();

		if (month >= 1 && month <= 9) {
			month = "0" + month;
		}
		if (day >= 0 && day <= 9) {
			day = "0" + day;
		}
		if (hours >= 0 && hours <= 9) {
			hours = "0" + hours;
		}
		if (minutes >= 0 && minutes <= 9) {
			minutes = "0" + minutes;
		}
		if (seconds >= 0 && seconds <= 9) {
			seconds = "0" + seconds;
		}
		var currentdate = year + seperator1 + month + seperator1 + day + " "
				+ hours + seperator2 + minutes + seperator2 + seconds;
		return currentdate;
	}
</script>
</head>

<body>
	<h2>作业留言列表</h2>
	<%
		int i = 0;//留言同学个数
		while (rs.next())
		{
			i++;
	%>
	<div>
		<input type="hidden" id="mid<%=i%>" value="<%=rs.getString("mid")%>" />
		<table width="100%" frame="box" rules="all">
			<tr>
				<td width="80%">第<%=i%>位：<br /> 
				<textarea id="msgbefore<%=i%>" class="textarea2" readonly><%=rs.getString("msg")%></textarea>
				<textarea id="msg<%=i%>" rows="1" class="textarea3"></textarea>
				</td>
				<td>
					<button id="<%=i%>" onclick="setMsg(this.id)">发送</button>
				</td>
			</tr>
		</table>
	</div>
	<%
		}
		if (i == 0)
		{
	%>
	无留言
	<%
		}
	%>
</body>
<script src='js/autosize.js'></script>
<script>
	autosize(document.querySelectorAll('textarea'));
</script>
</html>
