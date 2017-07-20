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
<%
	request.setCharacterEncoding("UTF-8");
	String id=request.getParameter("id");
	String reason=request.getParameter("reason");
	String glbm=request.getParameter("glbm");
	String submit=request.getParameter("submit");
	//System.out.println(submit+","+reason+","+glbm);
	if(submit.equals("通过"))
	{
		String sql="update needtable set states='1',xsshyj='"+reason+"',glbm='"+glbm+"' where id="+id;
		int i=db.executeUpdate(sql);
		if (i == 1) {
			out.println("<script language='javaScript'>"+
					"layer.open({title:'提示',content:'形式审核操作成功 ',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){window.location.href='wlsh.jsp'}});"
					+"</script>");
		} 
		else {
			out.println("<script language='javaScript'> alert('形式审核操作失败，点击确定再次审核！');history.back();</script>");
		}
		db.close();
	}
	if(submit.equals("不通过"))
	{
		String sql="update needtable set states='0',xsshyj='"+reason+"' where id="+id;
		int i=db.executeUpdate(sql);
		if (i == 1) {
			out.println("<script language='javaScript'>"+
						"layer.open({title:'提示',content:'形式审核操作成功 ',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){window.location.href='wlsh.jsp'}});"
						+"</script>");
		} 
		else {
			out.println("<script language='javaScript'> alert('形式审核操作失败，点击确定再次审核！');history.back();</script>");
		}
		db.close();
	}
	
%>
</body>
</html>