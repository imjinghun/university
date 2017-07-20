<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>校园留言管理系统--修改个人密码</title>
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
			alert("修改密码不能为空");
		}
		if(form1.pw1.value.length>9)
		{
			form1.pw1.focus();
			alert("修改密码不合要求");
			return false;
		}
		if(form1.pw2.value!=form1.pw1.value)
		{
			form1.pw2.focus();
			alert("和修改密码不一致");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form name="form1" action="userpw.jsp" method="post" onsubmit="return check()">
<p>
	<font class="w3">用户名</font>&nbsp;<input type="text" name="uname" class="inputcon">
</p>
<p>
	<font class="w4">当前密码</font>&nbsp;<input type="password" name="pw"  class="inputcon" >
</p>
<p>
	<font class="w4">修改密码</font>&nbsp;<input type="password" name="pw1"  class="inputcon" >&nbsp;不可空，不超9位
</p>
<p>
	<font class="w4">验证密码</font>&nbsp;<input type="password" name="pw2"  class="inputcon" >&nbsp;应和修改密码一致
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
			String pw1 = request.getParameter("pw1");
			
			String exsit=db.userExist(uname);
			if(!exsit.equals(uname))
			{
				out.println("<script language='javaScript'> alert('用户不存在！');</script>");
			}
			else
			{
			pw1+=".";
			String sql = "update user set password='"  + pw1 + "' where username=" + uname;
			int i = db.executeUpdate(sql);
			if (i == 1) {
				out.println("<script language='javaScript'> alert('修改成功,点击确定转到用户界面!');</script>");
				response.setHeader("refresh", "1;url=user.jsp");
			} else {
				out.println("<script language='javaScript'> alert('修改失败，点击确定返回当前页面！');</script>");
				response.setHeader("refresh", "1;url=userpw.jsp");
			}
			}
			db.close();
		}
	%>
</body>
</body>
</html>