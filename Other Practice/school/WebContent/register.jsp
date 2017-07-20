<%@ page language="java" contentType="text/html; charset=utf-8" language="java"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>校园留言管理系统--注册</title>
<style type="text/css">
.txtcon{width:100px; height:25px;}
.inputcon{width:150px; height:15px;}
.w2{
      letter-spacing:2.2em; 
      margin-right:0em; 
      }
      .w3{
      letter-spacing:0.7em; 
      margin-right:1.2em; 
      }
      .w4{
      letter-spacing:0.1em; 
      margin-right:2.0em; 
      }
      div {
	text-align: center;
}
</style>
<script>
	function check()
	{
		if(form1.uname.value=="")
		{
			form1.uname.focus();
			alert("用户名不能为空");
			return false;
		}
		if(form1.pw.value=="")
		{
			form1.pw.focus();
			alert("密码不能为空");
			return false;
		}
		if(form1.pw1.value=="")
		{
			form1.pw.focus();
			alert("验证密码不能为空");
			return false;
		}
		
		if(form1.uname.value.length>10)
		{
			form1.uname.focus();
			alert("用户名不符合要求");
			return false;
		}
		if(form1.pw.value.length>9)
		{
			form1.pw.focus();
			alert("密码不符合要求");
			return false;
		}
		if(form1.pw1.value!=form1.pw.value)
		{
			form1.pw1.focus();
			alert("两次密码不一致");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form name="form1" action="register.jsp" method="post" onsubmit="return check()">
<p>
	<font class="w3">用户名</font>&nbsp;<input type="text" name="uname" class="inputcon">&nbsp;不可空，不超10位
</p>
<p>
	<font class="w2">密码</font>&nbsp;<input type="password" name="pw" class="inputcon">&nbsp;不可空，不超9位
</p>
<p>
	<font class="w4">验证密码</font>&nbsp;<input type="password" name="pw1"  class="inputcon" >&nbsp;应和密码一致
</p>

<p>
	<input type="submit" name="sure" value="确定" class="txtcon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="重置" class="txtcon">
</p>

</form>

	<jsp:useBean id="db" class="bean.DBBean" scope="page" />
	
	<%
		request.setCharacterEncoding("UTF-8");
		String submit = request.getParameter("sure");
		if (submit != null && !submit.equals("")) {
			String uname = request.getParameter("uname");
			String pw = request.getParameter("pw");
			String exsit=db.userExist(uname);
			if(exsit.equals(uname))
			{
				out.println("<script language='javaScript'> alert('用户已存在！');</script>");
			}
			else
			{
			String sql = "insert into user values('" + uname + "','" + pw + "'" + ")";
			int i = db.executeUpdate(sql);
			if (i == 1) {
				out.println("<script language='javaScript'> alert('注册成功,点击确定转到登录界面!');</script>");
				response.setHeader("refresh", "1;url=login.jsp");
			} else {
				out.println("<script language='javaScript'> alert('注册失败，点击确定返回注册页面！');</script>");
				response.setHeader("refresh", "1;url=register.jsp");
			}
			}
			db.close();
		}
	%>
</body>
</html>