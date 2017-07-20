<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>EMP增删改查</title>
	<style type="text/css">
		
	    	table tr {
                height: 33px;
            }
            a {
                color: blue;
                cursor: pointer;
            }
            
            a:hover {
                color: rgb(26, 152, 190);
            }
	</style>
</head>
<body bgcolor="#e2f7f5">
	<jsp:useBean id="db" class="bean.ConnDB"></jsp:useBean>
		<div style="text-align:center;">
			<hr style="border:none;border-top:1px solid #a39e9e;" />
			<font style="font-size:30px;font-family:楷体;font-weight:bold;">员工信息表</font>
			<hr style="border:none;border-top:1px solid #a39e9e;" />
			<table frame="border" rules="all" align="center" width="80%">
				<tr style="font-weight:bold;background-color:#969696;">
					<td>员工号</td>
					<td>姓名</td>
					<td>工作性质</td>
					<td>所属领导编号</td>
					<td>入职时间</td>
					<td>薪资</td>
					<td>奖金</td>
					<td>部门编号</td>
					<td>操作</td>
				</tr>
			<%
				request.setCharacterEncoding("utf-8");
				String submit="",txtquery="";
				String sql="select * from emp";
				submit=request.getParameter("submit");
				txtquery=request.getParameter("txtquery");
				if(submit!=null)
				{
					if(!txtquery.equals(""))
					{
						sql="select * from emp where empno="+txtquery;
					}
				}
				ResultSet rs=db.executeQuery(sql);
				while(rs.next())
				{
					%>
					<tr>
							<td><%=rs.getInt(1) %></td>
							<td><%=rs.getString(2) %></td>
							<td><%=rs.getString(3) %></td>
							<td><%=rs.getInt(4) %></td>
							<td><%=rs.getDate(5) %></td>
							<td><%=rs.getInt(6) %></td>
							<td><%=rs.getInt(7) %></td>
							<td><%=rs.getInt(8) %></td>
							<td>
								<a href="editEmp.jsp?id=<%=rs.getInt(1)%>">修改</a>
								<a href="delEmp.jsp?id=<%=rs.getInt(1)%>">删除</a>
							</td>
						</tr>
						<% 
				}
			%>
			</table>
		</div>
</body>
</html>