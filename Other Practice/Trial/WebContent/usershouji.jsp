<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>河北省重大技术征集系统--需求征集</title>
</head>
<body>
<form name="form1" action="addCourse.jsp" method="post" onsubmit="return check()">
		<table width="80%" border="1" align="center">
			<caption>河北省重大技术需求征集表</caption>
			<tr>
				<td width="30%">技术需求名称</td>
				<td width="70%"><textarea style="width:100%;height:100%;border:none;overflow:hidden"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><textarea  style="width:100%;height:100%;border:none;overflow:hidden">
				重大科技需求概述（主要内容，技术指标、预期经济和社会效益等，限500字）</textarea></td>
			</tr>
		</table>
		<p align="center">
		<input type="submit" name="sure" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
		</p>
	</form>
</body>
</html>