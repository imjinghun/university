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
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>

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
		if(msg=="")
		{
			layer.tips("内容不能为空","#msg"+num);
			$("#msg"+num).focus();
			return;
		}
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
					layer.alert("留言失败");
				}
			}
		};
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
<script type="text/javascript">
	//上传作业
	function uploadH(cid,hid)
	{
		layer.open({
		  title:'提交作业',
	  	  type: 2,
		  area: ['450px', '320px'],
		  fixed: false, //不固定
		  offset:'t',
		  scrollbar:false,
		  content: 'File/upload.jsp?cid='+cid+'&hid='+hid
		});
	}
	//查看作业
	function lookH(hid)
	{
		layer.open({
		  title:'作业详情',
	  	  type: 2,
		  area: ['50%', '100%'],
		  fixed: false, //不固定
		  offset:'t',
		  scrollbar:false,
		  content: 'File/stdFileList.jsp?hid='+hid
		});
	}
</script>
</head>

<body>
	<%
	request.setCharacterEncoding("utf-8");
	String hcid=request.getParameter("hcid");
	String username=(String)request.getSession().getAttribute("username");
	%>
	<div>
		<a href="Homework/HListStd.jsp?hcid=<%=hcid%>">作业</a> 
		<a href="File/tecFileList.jsp?cid=<%=hcid%>">资料</a>
	</div>
	<%
	DBBean db = new DBBean();
	DBBean db2 = new DBBean();//解决 结果集已关闭 问题
	/*一个ResultSet对象与Statement对象关联，DBBean构造方法只创建了一个Statement对象，每次创建DBBean对象时，就创建了一个statement对象，
	要想使用两个ResultSet得有两个statement，所以再创建一个DBBean对象*/
	String sql = "select * from homework where hcid='"+hcid+"' order by hid desc";//where hcid=''通过课程号来确定 所点击课程下的作业

	ResultSet rs=db.executeQuery(sql);
	int i=0;
 	while(rs.next())
 	{
 		i++;
 		String sql2="select msg from message where msid='"+username+"' and mhid='"+rs.getString("hid")+"'";
 		ResultSet rs2=db2.executeQuery(sql2);
 	%>
	<div class="divzylb">
		<table width="100%" frame="box" rules="all">
			<tr>
				<td style="width:80%;">发布日期：<%=rs.getString("hbegintime") %></td>
				<td rowspan="4">
					<button onclick="uploadH('<%=rs.getString("hcid")%>','<%=rs.getString("hid")%>')">提交作业</button>
					<button onclick="lookH('<%=rs.getString("hid")%>')">查看作业</button>
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
					readonly><% if(rs2.next()){out.print(rs2.getString("msg"));}%></textarea> 
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
<script src='js/autosize.js'></script>
<script>
	autosize(document.querySelectorAll('textarea'));
</script>

</html>
