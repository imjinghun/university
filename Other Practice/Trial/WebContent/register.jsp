<%@ page language="java" contentType="text/html; charset=utf-8" language="java"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>河北省重大技术征集系统--注册</title>
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
	//密码为*
	function change(){
		var value = document.getElementById('pwd').value;
		var ins = "";
		for(var i=0;i<value.length;i++){
		ins+="*";
		}
		document.getElementById('pwd').value=ins;
		}
	function change1(){
		var value = document.getElementById('pwd1').value;
		var ins = "";
		for(var i=0;i<value.length;i++){
		ins+="*";
		}
		document.getElementById('pwd1').value=ins;
	}
</script>
</head>
<body>
<form name="form1" action="register.jsp" method="post" onsubmit="return check()">
<p>
	<font class="w3">用户名</font>&nbsp;<input type="text" name="uname" class="inputcon">&nbsp;不可空，不超10位
</p>
<p>
	<font class="w2">密码</font>&nbsp;<input type="text" name="pw" id="pwd" class="inputcon" onkeyup="change()">&nbsp;不可空，不超9位
</p>
<p>
	<font class="w4">验证密码</font>&nbsp;<input type="text" name="pw1" id="pwd1" class="inputcon" onkeyup="change1()">&nbsp;应和密码一致
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
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String office = request.getParameter("office");
			String exsit=db.userExist(uname);
			if(exsit.equals(uname))
			{
				out.println("<script language='javaScript'> alert('用户已存在！');</script>");
			}
			else
			{
			//对密码加密
			pw+=".";
			String sql = "insert into user values('" + uname + "','" + pw + "','" + name + "','" + tel + "','"+office+"'"+ ")";
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