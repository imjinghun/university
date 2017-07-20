<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EMP添加员工</title>
<style type="text/css">
.btn1 {
                background-color: #282ff7;
                color: white;
                height: 25px;
                font-size: 16px;
                width: 55px;
                border: 2px;
                margin-left:20px;
            }
            
            .btn1:hover {
                background-color: #0000CD;
            }
            table tr {
                height: 33px;
            }
</style>
</head>
<body bgcolor="#e2f7f5">
<jsp:useBean id="db" class="bean.ConnDB"></jsp:useBean>
		<%
			request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String sql="select * from emp where empno="+id;
		
		ResultSet rs=db.executeQuery(sql);
		if(rs.next())
		{
		%>
	<div style="text-align:center;margin-top:40px;">
	<font style="font-family:华文行楷;font-style:italic;color:blue;font-size:50px;">EMP员工信息修改</font>
	<hr style="border:none;border-top:1px solid #a39e9e;" />
	<form action="" method="post" name="form1">
		<table align="center">
			<tr>
				 <td>员工号</td><td><input name="empno" type="text" value="<%=rs.getInt(1)%>" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>姓名</td><td><input name="ename" type="text" value="<%=rs.getString(2)%>"/></td>
			</tr>
			<tr>
				<td>工作性质</td><td><input name="job" type="text" value="<%=rs.getString(3)%>"/></td>
			</tr>
			<tr>
				<td>所属领导编号</td><td><input name="mgr" type="text" value="<%=rs.getInt(4)%>"/></td>
			</tr>
			<tr>
				<td>入职时间</td><td><input name="hiredate" type="text" value="<%=rs.getDate(5)%>"/></td>
			</tr>
			<tr>
				<td>薪资</td><td><input name="sal" type="text" value="<%=rs.getInt(6)%>"/></td>
			</tr>
			<tr>
				<td>奖金</td><td><input name="comm" type="text" value="<%=rs.getInt(7)%>"/></td>
			</tr>
			<tr>
				<td>部门编号</td><td><input name="deptno" type="text" value="<%=rs.getInt(8)%>"/></td>
			</tr>
			<tr>
			 	<td colspan="2">
					<input name="submit" type="submit" value="确定" class="btn1"/>
				</td>
			</tr>
		</table>
		</form>
		<hr style="border:none;border-top:1px solid #a39e9e;" />
	</div>
	<div>
		<%
		}
			String submit="",empno="",ename="",job="",mgr="",hiredate="",sal="",comm="",deptno="";
			submit=request.getParameter("submit");
			if(submit!=null)
			{
				empno=request.getParameter("empno");
				ename=request.getParameter("ename");
				job=request.getParameter("job");
				mgr=request.getParameter("mgr");
				hiredate=request.getParameter("hiredate");
				sal=request.getParameter("sal");
				comm=request.getParameter("comm");
				deptno=request.getParameter("deptno");
				
				sql="update emp set ename='"+ename+"',job='"+job+"',mgr="+mgr+",hiredate=to_date('"+hiredate+"','yyyy-mm-dd'),sal="+sal+
						",comm="+comm+",deptno="+deptno+" where empno="+empno;
				
				//System.out.println(sql);
				int i=db.executeUpdate(sql);
				if(i==1)
				{
					out.println("<script language='javaScript'> alert('修改成功！');</script>");
					response.setHeader("refresh", "0.1;url=index.jsp");
				}
				else
				{
					out.println("<script language='javaScript'> alert('修改失败！');history.back();</script>");
				}
			}
		%>
	</div>

</body>
</html>