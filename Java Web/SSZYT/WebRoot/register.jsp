<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>注册-欢迎使用师生作业通</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="css/register.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript" src="js/register.js"></script>

</head>

<body>
	<div class="login">
        <h2>欢迎使用-师生作业通</h2>
        <div class="login-top">
            <h1>欢迎注册</h1>
            <table width="100%" border="1">
                <tr>
                    <td>用户名：</td>
                    <td> <input placeholder="不可空，6-20位" type="text" name="username" id="username" /></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input placeholder="不可空，6-20位" type="password" name="password" id="password" /></td>
                </tr>
                <tr>
                    <td>确认密码：</td>
                    <td><input placeholder="应与密码一致" type="password" name="password2" id="password2" /></td>
                </tr>
                <tr>
                    <td>身份选择：</td>
                    <td>
                        <input type="radio" name="identity" value="老师" id="teacher" /> 
                        <label for="teacher">老师</label> 
                        <input type="radio" name="identity" value="学生" id="student" /> 
                        <label for="student">学生</label>
                    </td>
                </tr>
                <tr id="xuehao">
                    <td>学号：</td>
                    <td><input placeholder="不可空" type="text" name="sno" id="sno" /></td>
                </tr>
                <tr>
                    <td>姓名：</td>
                    <td><input placeholder="不可空" type="text" name="name" id="name" /></td>
                </tr>
                <tr>
                    <td>学校：</td>
                    <td><input placeholder="不可空" type="text" name="school" id="school" /></td>
                </tr>
            </table>
            <div class="forgot">
                <label id="alertregister"></label>
                <input type="submit" id="submit" name="submit" value="注 册">
            </div>
        </div>
        <div class="login-bottom">
            <h3>已有账号点击&nbsp;<a href="login.jsp">登录</a></h3>
        </div>
    </div>
    <div class="copyright">
        <p>Copyright &copy; 2017.FenNuTeam All rights reserved.</p>
    </div>
</body>
</html>
