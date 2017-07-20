<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
    <style>
    .btn1{
    background-color:#282ff7 ;
    color:white;
    height:30px;
    font-size:16px;
    width:50px;
    border:2px;
    }
    .btn1:hover {
    background-color: #0000CD;
		}
		table {
		text-align:center;
		    border-collapse:collapse;
		    }
		    table tr td{ border-bottom:1px solid #dedede;}
    table tr{
    height:30px;
    }
    a{
    color:blue;
    text-decoration:none;
    }
    a:hover{
    text-decoration:underline;
    }
    </style>
    <style> 
			.even{background:#D9D9D9;} 
		</style> 
		<script type="text/javascript"> 
			$(function(){ 
				$("tr:even").addClass("even");
			}); 
		</script> 
    <script>
    function qcheck()
    {
    	if(form1.txtquery.value=="")
    	{
    		return false;
    	}
    	return true;
    }
    </script>
</head>

<body>
    <jsp:useBean id="db" class="bean.DBBean" scope="page" />
    <form action="yhmmcz.jsp" name="form1" method="post">
    <strong>用户名:</strong>
    <input type="text" name="txtquery" id="txtquery" style="height:25px;font-size:16px;"/> 
    <button type="submit" id="btnquery" class="btn1">查询</button>
    <br/><br/>
     <div id="t1">
    	<table width="100%"> 
        <tr style="font-weight:bold;background-color:#969696;">
            <td width="15%" align="center">用户名</td>
            <td width="20%" align="center">机构代码</td>
            <td width="25%" align="center">机构名称</td>
            <td width="28%" align="center">通讯地址</td>
            <td width="12%" align="center">操作</td>
        </tr>
       
        <%
            String uname=request.getParameter("txtquery");
        	//System.out.println(uname);
        	if(uname==""||uname==null)
        	{
        		String sql="select username,Organcode,Organname,Contactaddr from userInfo";
	        	ResultSet rs=db.executeQuery(sql);
	        	while(rs.next())
	        	{
	        		String n=rs.getString(1);
	        		%>
	        		 <tr>
			            <td><%=rs.getString(1)%></td>
			            <td><%=rs.getString(2)%></td>
			            <td><%=rs.getString(3)%></td>
			            <td><%=rs.getString(4)%></td>
			            <td align="center">
			            <a href="yhmmcz2.jsp?username=<%=n%>" >重置密码</a>
			            </td>
	        		</tr>
	        		<% 
	        	}
        	}
        	else
        	{
        		String sql="select username,Organcode,Organname,Contactaddr from userInfo where username='"+uname+"'";
        		ResultSet rs=db.executeQuery(sql);
            	while(rs.next())
            	{
            		String n=rs.getString(1);
            		%>
            		 <tr>
		                <td><%=rs.getString(1)%></td>
		                <td><%=rs.getString(2)%></td>
		                <td><%=rs.getString(3)%></td>
		                <td><%=rs.getString(4)%></td>
		                <td align="center">
		                <a href="yhmmcz2.jsp?username=<%=n%>">重置密码</a>
		                </td>
		            </tr>
            		<%
            	}
        	}
        %>
    </table>
    
    </div>
    </form>
</body>

</html>