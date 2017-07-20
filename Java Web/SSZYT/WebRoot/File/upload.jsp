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

<title>上传文件-师生作业通</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
.btn{
		width:60px;
		height:30px;
		background-color:#66CDAA;
		border:none;
		font-size:16px;
	}
	.btn:hover{
		background-color:#4EEE94;
	}
</style>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript">
function filecheck()
{
	var s=document.form1.file.value; 
	if(s==""){
       layer.tips("请选择文件","#file");
       document.form1.file.focus();
       return false;
    }
    return true;            
}
function upload(){
	if(filecheck()){
		var int=window.setInterval("re()",100);
		var formData=new FormData(document.getElementById("form1"));
		$.ajax({
			url:"servlet/upload",
			type:"post",
			cache: false,
			data:formData,
			async: true,//必须是异步 否则 进度条不显示
			processData:false,
	        contentType:false,
	        success:function(data){
	        	if(data=="成功")
	        	{
		        	window.clearInterval(int);
		        	$("#percent").text("100%");
		        	layer.msg("上传成功",{icon:6,time:1000});
		        	setTimeout(function(){location.reload();},1000);
	        	}
	        	else{
	        		layer.alert("上传失败："+data,{icon:5},function(){location.reload();});
	        	}
	        },
	        error:function(data){
	        	window.clearInterval(int);
	        	layer.alert("失败"+data,{icon:5},function(){location.reload();});
	        }
		});
	}
}
</script>
<script>
	function re(){
		$.ajax({
			url:"servlet/progress",
			type:"post",
			async:true,
			success:function(retData){
				$("#percent").text(retData+"%");
			},
			error:function(retData){
				console.log(retData.responseText);
			}
		});
	}
</script>
</head>

<body>
	<%
		request.setCharacterEncoding("utf-8");
		DBBean db = new DBBean();
		String cid = "", hid = "";
		cid = request.getParameter("cid");
		hid = request.getParameter("hid");
	%>
	<form  name="form1" id="form1">
		<!-- 传值 课程号 作业号 -->
		<input type="hidden" name="cid" value="<%=cid%>" /> <input
			type="hidden" name="hid" value="<%=hid%>" />

		<table width="400" height="247" border="0" align="center"
			cellpadding="0" cellspacing="0" background="images/upFile_bg.gif">
			<tr>
				<td height="40" align="center">&nbsp;</td>
			</tr>
			<tr>
				<td height="207" align="center">
					<table width="309" height="190" border="0" align="right"
						cellpadding="0" cellspacing="0">
						<tr>
							<td height="34">请选择上传的文件：</td>
						</tr>
						<tr>
							<td height="42"><input id="file" name="file" type="file" size="50">
							</td>
						</tr>
						<tr>
							<td height="50">注：文件大小请控制在1G以内。(为什么)</td>
						</tr>
						<tr>
							<td height="29" align="center">
							<label id="percent" style="color:green;font-weight:bold;"></label>
							<input type="button" value="提交" onclick="upload()" class="btn"/>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
