<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EMP删除员工</title>
</head>
<body bgcolor="#e2f7f5">
	<div>
		<jsp:useBean id="db" class="bean.ConnDB"></jsp:useBean>
		<%
			request.setCharacterEncoding("utf-8");
			String id="";
			id=request.getParameter("id");
			String sql="delete from emp where empno="+id;
				
				//System.out.println(sql);
				int i=db.executeUpdate(sql);
				if(i==1)
				{
					out.println("<script language='javaScript'> alert('删除成功！');</script>");
					response.setHeader("refresh", "0.1;url=index.jsp");
				}
				else
				{
					out.println("<script language='javaScript'> alert('删除失败！');history.back();</script>");
				}
			
		%>
	</div>

</body>
</html>