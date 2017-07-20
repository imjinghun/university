<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>河北省重大技术征集系统--修改个人信息</title>
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
		if(form1.name.value=="")
		{
			form1.name.focus();
			alert("姓名不能为空");
			return false;
		}
		if(form1.tel.value=="")
		{
			form1.tel.focus();
			alert("电话不能为空");
			return false;
		}
		if(form1.office.value=="")
		{
			form1.office.focus();
			alert("工作单位不能为空");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form name="form1" action="userinfo.jsp" method="post" onsubmit="return check()">
<p>
	<font class="w3">用户名</font>&nbsp;<input type="text" name="uname" class="inputcon">
</p>
<p>
	<font class="w2">姓名</font>&nbsp;<input type="text" name="name" class="inputcon">
</p>
<p>
	<font class="w2">电话</font>&nbsp;<input type="text" name="tel" class="inputcon">
</p>
<p>
	<font class="w4">工作单位</font>&nbsp;<input type="text" name="office" class="inputcon">
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
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String office = request.getParameter("office");
			String exsit=db.userExist(uname);
			if(!exsit.equals(uname))
			{
				out.println("<script language='javaScript'> alert('用户不存在！');</script>");
			}
			else
			{
			String sql = "update user set name='" + name + "',tel='" + tel + "',office='" + office + "' where username=" + uname;
			int i = db.executeUpdate(sql);
			if (i == 1) {
				out.println("<script language='javaScript'> alert('修改成功,点击确定转到用户界面!');</script>");
				response.setHeader("refresh", "1;url=user.jsp");
			} else {
				out.println("<script language='javaScript'> alert('修改失败，点击确定返回当前页面！');</script>");
				response.setHeader("refresh", "1;url=userinfo.jsp");
			}
			}
			db.close();
		}
	%>
</body>
</html>