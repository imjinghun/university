<%@ page language="java" import="java.util.*,java.sql.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	input {
	font-size:16px;
	width:
}
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
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./layer/layer.js"></script>
<script type="text/javascript">
function revise(){
		var pwd=$.trim($("#pwd").val());
		var pwd2=$.trim($("#pwd2").val());
		if(pwd==""||pwd.length<6||pwd.length>20)
		{
			layer.tips("密码输入有误","#pwd");
			$("#pwd").focus();
			return;
		}
		if(pwd!=pwd2)
		{
			layer.tips("确认密码输入有误","#pwd2");
			$("#pwd2").focus();
			return;
		}
		
		$.ajax({
				type:"post",
				url:"./servlet/RevisePwd",
				data:{
					"pwd":pwd
				},
				success:function(retData){
					if(retData=="成功")
					{
						layer.msg("修改密码成功，1秒后自动关闭",{time:1000});
						
						setTimeout(function(){parent.location.reload();},1000);
					}
					else{
						layer.msg("修改密码异常，1秒后重试",{time:1000});
					}
				}
			});
	}
</script>

  </head>
  
  <body>
    <%
    	request.setCharacterEncoding("utf-8");
    	String role=(String)request.getSession().getAttribute("role");
		String username=(String)request.getSession().getAttribute("username");
     %>
     <table frame="box" rules="all" align="center" id="table0">
			<tr>
				<td align="right">新密码</td>
				<td><input type="password" id="pwd" name="pwd" placeholder="6-20位"/></td>
			</tr>
			<tr>
				<td align="right">确认密码</td>
				<td><input type="password" id="pwd2" name="pwd2" placeholder="同密码一致"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" id="sure" value="确定" onclick="return revise()" class="btn"/>
				</td>
			</tr>
	</table>
  </body>
</html>
