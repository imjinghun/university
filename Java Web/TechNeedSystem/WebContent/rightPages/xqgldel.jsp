<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<jsp:useBean id="db" class="bean.DBBean" scope="page" />
<%
	request.setCharacterEncoding("UTF-8");
	String id=request.getParameter("id");
	//System.out.println(username);
	if(id!=""&&id!=null)
	{
		String sql="delete from needtable where id="+id+"";
		int i=db.executeUpdate(sql);
		if (i == 1) {
			response.setHeader("refresh", "0.1;url=xqgl.jsp");
		} 
		else {
			out.println("<script language='javaScript'> alert('删除失败，点击确定重新删除！');history.back();</script>");
		}
		db.close();
	}

%>
</body>
</html>