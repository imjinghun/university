<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>校园留言管理系统--登录</title>
<style type="text/css">

    .font1{align:center} /* 设置对齐方式  */

    .inputcon{width:150px; height:15px;} /*设置输入框长度和高度*/
    
    .txtcon{width:198px; height:25px;} /*设置按钮长度和高度*/
	.w2{
      letter-spacing:1.4em; 
      margin-right:0.1em; 
      }
    .w3{
      letter-spacing:0.2em; 
      margin-right:1.2em; 
      }

</style>
<script>
	function check()
	{
		if(form0.user.value=="")
		{
			form1.user.focus();
			alert("用户名不能为空");
			return false;
		}
		if(form0.pw.value=="")
		{
			form1.pw.focus();
			alert("密码不能为空");
			return false;
		}
		return true;
	}
	
</script>
</head>
<body>
<form name="form0" action="login.jsp" method="post" onsubmit="return check()">
<p>
	<font class="w3">用户名</font>&nbsp;<input type="text" name="user" class="inputcon">
</p>
<p>
	<font class="w2">密码</font>&nbsp;<input type="password" name="pw"  class="inputcon" >
</p>
<p>
	<input type="submit" name="sure" value="登录" class="txtcon">
</p>
<p>
<a href="register.jsp">注册用户</a>
</p>
</form>

	<jsp:useBean id="db" class="bean.DBBean" scope="page" />
	<%
	request.setCharacterEncoding("UTF-8");
	String submit = request.getParameter("sure");
	if (submit != null && !submit.equals("")) {
		String user = request.getParameter("user");
		String pw = request.getParameter("pw");
		String exsit=db.userExist(user);
		if(exsit.equals(user))
		{
			String sql="select password from user where username="+user;
			ResultSet rs = db.executeQuery(sql);
			rs.next();
			String str=rs.getString(1);
			if(pw.equals(str))
			{
				if(user.equals("123"))
				{
					response.setHeader("refresh","1;url=user.jsp");
				}
				if(user.equals("456"))
				{
					response.setHeader("refresh","1;url=manager.jsp");
				}
			}
			else
			{
				out.println("<script language='javaScript'> alert('密码不正确!');</script>");
			}
		}
		else
		{
			out.println("<script language='javaScript'> alert('用户不存在！请注册');</script>");
		}
		db.close();
	}
	%>
</body>
</html>