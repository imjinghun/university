<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" import="java.util.*,java.sql.*,com.jing.dao.*"
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

.textarea2 {
	max-height: 200px;
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
	window.onload = function() {
		display();
	};
	function display() {
		//对于留言内容为空的作业 隐藏旧留言框
		var num = document.getElementsByName("num");
		var msgb = document.getElementsByName("msgbefore");
		for (i = 0; i < num.length + 1; i++) 
		{
			if (msgb[i].value.toString().trim() == "") 
			{
				document.getElementById("msgbefore" + (i + 1)).style.display = "none";
			}
		}
	}

	function setMsg(id) {

		var num = id;//判断点击哪个btn按钮 从而实现对应的留言存储
		var hid = document.getElementById("hid" + num).value;
		var hcid = document.getElementById("hcid" + num).value;
		var htid = document.getElementById("htid" + num).value;
		var date = getNowFormatDate();
		var msg = document.getElementById("msg" + num).value.toString().trim();
		var msgbefore = document.getElementById("msgbefore" + num).value.toString().trim();
		var newmsg = "";
		
		if (msgbefore == "")//第一次留言
		{
			newmsg = "学生(" + date + "):" + msg;
		} 
		else 
		{
			newmsg = msgbefore + "\r\n学生(" + date + "):" + msg;
		}
		var cs = "hid=" + hid + "&hcid=" + hcid + "&htid=" + htid + "&msg=" + newmsg;

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
				if(xmlhttp.responseText=="success")
				{
					location.reload();
				}
				else
				{
					alert("留言失败");
				}
			}
		};
		//url如果不行的话试试 "./servlet/Msg" ./当前目录 
		xmlhttp.open("POST", "servlet/Msg", true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
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
	<%
	DBBean db = new DBBean();
	DBBean db2 = new DBBean();//解决 结果集已关闭 问题
	/*一个ResultSet对象与Statement对象关联，DBBean构造方法只创建了一个Statement对象，每次创建DBBean对象时，就创建了一个statement对象，
	要想使用两个ResultSet得有两个statement，所以再创建一个DBBean对象*/
	String sql = "select * from homework order by hid desc";//where hcid=''通过课程号来确定 所点击课程下的作业

	ResultSet rs=db.executeQuery(sql);
	int i=0;
 	while(rs.next())
 	{
 		i++;
 		//注意此处的 msid='xs1' 整合时需要修改*************************************************
 		String sql2="select msg from message where msid='xs1' and mhid='"+rs.getString("hid")+"'";
 		ResultSet rs2=db2.executeQuery(sql2);
 	%>
	<div class="divzylb">
		<table width="100%" frame="box" rules="all">
			<tr>
				<td style="width:80%;">发布日期：<%=rs.getString("hbegintime") %></td>
				<td rowspan="4"><a href="">提交作业</a> <a href="">查看作业</a>
				</td>
			</tr>
			<tr>
				<td>作业名称：<%=rs.getString("hname") %></td>
			</tr>
			<tr>
				<td>作业内容：<br /> <textarea class="textarea1" readonly><%=rs.getString("hinfo") %></textarea>
				</td>
			</tr>
			<tr>
				<td>截止日期：<%=rs.getString("hendtime") %></td>
			</tr>
		</table>

		<input type="hidden" id="hid<%=i %>" value="<%=rs.getString("hid")%>" />
		<input type="hidden" id="hcid<%=i %>" value="<%=rs.getString("hcid")%>" />
		<input type="hidden" id="htid<%=i %>" value="<%=rs.getString("htid")%>" />
        <input type="hidden" value="<%=i %>" name="num" />

		<table width="100%" frame="box" rules="all">
			<tr>
				<td style="width:80%;">作业留言：<br /> 
					<textarea name="msgbefore" id="msgbefore<%=i %>" class="textarea2" 
					readonly><% if(rs2.next()){out.print(rs2.getString("msg"));}%>
					</textarea> 
					<textarea rows="1" name="msg<%=i %>" id="msg<%=i %>"
						class="textarea3"></textarea>
				</td>
				<td>
					<button id="<%=i %>" onclick="setMsg(this.id)">发送</button>
				</td>
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
