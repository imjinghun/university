<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>

<style type="text/css">

    .font1{align:center} /* 设置对齐方式  */

    .inputcon{width:150px; height:15px;} /*设置输入框长度和高度*/
    
    .txtcon{width:198px; height:25px;} /*设置按钮长度和高度*/

    .w3{
      letter-spacing:0.5em; /*如果需要y个字两端对齐，则为(x-y)/(y-1),这里是（4-3）/(3-1)=0.5em */
      margin-right:-0.5em; /*同上*/
      }

</style>
</head>
<body>
<form name="log" method="post" action="login2.jsp">
<p>
	<font class="w3">帐号</font>&nbsp;<input type="text" name="user" class="inputcon">
</p>
<p>
	<font class="w3">密码</font>&nbsp;<input type="password" name="password" class="inputcon">
</p>
<p>
	<input type="submit" value="登录" class="txtcon">
</p>
<p>
	<a href="regist.jsp">没有帐号？注册</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="findpw.jsp">忘记密码</a>
</p>
</form>
</body>
</html>