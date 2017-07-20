<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
        <!-- 引入layer组件弹窗 -->
        <script src="../layer/layer.js"></script>
</head>
<body>
<jsp:useBean id="db" class="bean.DBBean" scope="page" />
<jsp:useBean id="md5" class="bean.MD5JM" scope="page" />
<%
	request.setCharacterEncoding("UTF-8");
	String username=request.getParameter("username");
	//加密
	String pw=md5.transMD5("123456");
	if(username!=""&&username!=null)
	{
		String sql="update userInfo set password='"+pw+"' where username='"+username+"'";
		int i=db.executeUpdate(sql);
		if (i == 1) {
			out.println("<script language='javaScript'>"+
					"layer.open({title:'提示',content:'重置密码为： 123456 ',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){window.location.href='yhmmcz.jsp'}});"
					+"</script>");
		} 
		else {
			out.println("<script language='javaScript'> alert('重置密码失败，点击确定重置密码！');history.back();</script>");
			//response.setHeader("refresh", "0.1;url=fooddel.jsp");
		}
		db.close();
	}

%>
</body>
</html>