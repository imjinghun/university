<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
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

<title>编辑作业</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/Rili/laydate.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<!-- 日历控件 -->
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

<!-- 输入验证  -->
<script>
$(function(){
textnum();
});
//提交时检查
function inputcheck()
{
	var hname=document.getElementById("hname");
	var hinfo=document.getElementById("hinfo");
	var hendtime=document.getElementById("hendtime");
	if(hname.value.toString().trim()=="")
	{
		layer.tips("作业名称不可空","#hname");
		hname.focus();
		return false;
	}
	if(hinfo.value.toString().trim()=="")
	{
		layer.tips("作业内容不可空","#hinfo");
		hinfo.focus();
		return false;
	}
	if(hendtime.value.toString().trim()=="")
	{
		layer.tips("截止日期不可空","#hendtime");
		return false;
	}
	if(hname.value.toString().trim().length>50)
	{
		layer.tips("作业名称过长","#hname");
		hname.focus();
		return false;
	}
	return true;
}
//设置作业名称文本框 字数实时显示
function textnum()
{
	var length=document.getElementById("hname").value.toString().trim().length;
	document.getElementById("num").innerText=50-length;
}
</script>

<style type="text/css">
.divcenter { /*margin使div里面的div水平居中*/
	margin: 20px auto;
	width: 85%;
	_height: 100%;
	min-height: 100%;
	overflow: auto;
	background-color: #fff;
}

.textarea1 {
	max-height: 500px;
	width: 99%;
	font-size: 16px;
	resize: none;
}

.input {
	width: 80%;
	height: 20px;
	font-size: 16px;
}

table {
	margin: 0 auto;
	width: 100%;
	border: 20px solid #fff;
}

.btn {
	width: 60px;
	height: 30px;
	background-color: #66CDAA;
	border: none;
	font-size: 16px;
}

.btn:hover {
	background-color: #4EEE94;
}
</style>

<script type="text/javascript">
	var index = parent.layer.getFrameIndex(window.name);

	function edit(hid){
		var hname=$("#hname").val();
		var hinfo=$("#hinfo").val();
		var hendtime=$("#hendtime").val();
		if(inputcheck()){
			$.ajax({
				type:"post",
				url:"./servlet/HEdit",
				data:{
					//"hcid":hcid,
					"hid":hid,
					"hname":hname,
					"hinfo":hinfo,
					"hendtime":hendtime
				},
				success:function(retData){
					if(retData=="成功")
					{
						layer.msg("作业修改成功，1秒后自动关闭",{time:1000});
						
						setTimeout(function(){parent.location.reload();},1000);
					}
					else{
						layer.msg("作业修改异常，1秒后重试",{time:1000});
					}
				}
			});
		}
	}
</script>

</head>

<body>
	<%
	request.setCharacterEncoding("utf-8");
	
	String hid=request.getParameter("hid");
	DBBean db=new DBBean();
	//查询作业名称 内容 创建及截止时间 课程号
	String sql="select hname,hinfo,hendtime from homework where hid='"+hid+"'";
	ResultSet rs=db.executeQuery(sql);
 	if(rs.next())
 	{
 		%>
	<div class="divbottom">
		<div class="divcenter">
			<table>
				<tr>
					<th scope="row">作业名称</th>
					<td><input placeholder="最多50字" type="text" name="hname" class="input"
						id="hname" width="500px" value="<%=rs.getString("hname")%>" onkeyup="textnum()"/>
						还可输入<label id="num">50</label>字</td>
				</tr>
				<tr>
					<th scope="row">作业内容</th>
					<td><textarea name="hinfo" id="hinfo" rows="25" class="textarea1"
							style="max-height: 500px;width: 100%;resize: none;"><%=rs.getString("hinfo")%></textarea>
					</td>
				</tr>
				<tr>
					<th scope="row">截止日期</th>
					<td>
						<div class="demo2">
							<input placeholder="选择日期" class="laydate-icon" id="hendtime"
								name="hendtime" value="<%=rs.getString("hendtime") %>"
								onClick="laydate(start)" readonly>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button onclick="edit('<%=hid%>')" class="btn">确认</button></td>
				</tr>
			</table>
		</div>
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

<script src='js/autosize.js'></script>
<script>
	autosize(document.querySelectorAll('textarea'));
</script>

</html>
