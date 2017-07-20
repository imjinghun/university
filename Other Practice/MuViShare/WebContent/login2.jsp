<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册页面</title>
		<style type="text/css">
body {
	background-image: url(/practice/0105.gif)
}

.aa {
	float: right;
}

.box {
	position: absolute;
	width: 800px;
	height: 500px;
	left: 50%;
	top: 50%;
	margin-left: -400px;
	margin-top: -250px;
	text-align: center;
	border: outset;
	border-color: #FFFFFF;
	background-color: #FBF5E6;
}

#boxhead1 {
	text-align: left;
}

#boxhead2 {
	text-align: left;
}

#boxhead3 {
	text-align: left;
}
</style>
	</head>
	<body>
		<div class="aa">
			<a href="1.html">返回登陆首页</a>
		</div>
		<div class="box">
			<div id="boxhead1">
				<hr>
				<h3>
					选择账号名称
				</h3>
			</div>
			<br>
			账号：
			<input type="text">
			6-12位之间，请用英文小写、数字，不能全部是数字。
			<br>
			<br>
			<div id="boxhead2">
				<hr>
				<h3>
					设置安全信息
				</h3>
			</div>
			设置登录密码：
			<input type="text">
			6-12位字符（字母、数字）
			<br>
			<br>
			再次输入密码：
			<input type="text">
			请保证与第一次输入的密码一致。
			<br>
			<br>
			<div id="boxhead3">
				<hr>
				<h3>
					填写验证码
				</h3>
			</div>
			<br>
			验证码：
			<input type="text">
			<br>
			<br>
			<input type="submit" value="提交" size="15">
		</div>
	</body>
</html>
