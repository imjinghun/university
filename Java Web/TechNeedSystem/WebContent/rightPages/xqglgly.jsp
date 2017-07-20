<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
        <style type="text/css">
		    .btn{
			    background-color:#4169E1;
			    color:white;
			    height:30px;
			    font-size:16px;
			    width:50px;
			    border:2px;
		    }
		    .btn:hover{
		    	background-color:#282ff7 ;
		    }
        	a{
		    color:blue;
		    text-decoration:none;
		    }
		    a:hover{
		    text-decoration:underline;
		    }
		    table {
		    border-collapse:collapse;
		    }
		    table tr td{ border-bottom:1px solid #dedede;}
	        table tr{
	        	height:30px;
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
	</head>
	<body>
	<jsp:useBean id="db" class="bean.DBBean" scope="page" />
        <%
	       request.setCharacterEncoding("UTF-8");
	       String uname=(String)session.getAttribute("username");
	       /*
	       String sql="select Organname from userinfo where username='"+uname+"'";
	       ResultSet rs=db.executeQuery(sql);
	       String jgmc="";
	       if(rs.next())
	       {
	    	   jgmc=rs.getString(1);
	       }*/
	    %>
	    <form action="xqglgly.jsp" name="form1" method="post">
	    <strong>技术需求名称:</strong>
    	<input type="text" name="txtquery" id="txtquery" style="height:25px;font-size:16px;"/> 
    	<input type="submit" name="submit" value="查询" class="btn"/>&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="submit" name="submit" value="已审核" style="width:80px;" class="btn"/>&nbsp;
    	<input type="submit" name="submit" value="未审核" style="width:80px;"  class="btn"/>
    	<br/><br/>
    	</form>
	<div style="text-align:center;">
	
		<table width="100%" align="center"> 
        <tr style="font-weight:bold;background-color:#969696;">
            <td width="25%" >机构全称</td>
            <td width="15%" >联系人</td>
            <td width="30%" >技术需求名称</td>
            <td width="15%" >审核状态</td>
        </tr>
        <%
        String nname=request.getParameter("txtquery");
        String submit=request.getParameter("submit");
        //System.out.println(submit);
        if(submit==null)
        {
        	String sql="select id,Organname,Contacts,needname,states from needtable where states!='3'";
            ResultSet rs=db.executeQuery(sql);
            while(rs.next())
            {
            	%>
            	<tr>
    	        	<td ><%=rs.getString(2)%></td>
    	            <td><%=rs.getString(3) %></td>
    	            <td ><%out.print("<a href='wlshshow2.jsp?id="+rs.getInt(1)+"'>"+rs.getString(4)+"</a>");%></td>
    	            <td >
    	            <%
    	            if(rs.getString(5).equals("0"))
    	   			{
    	   				out.print("<font style='color:red;'>形式审核未通过</font>");
    	   			}
    	   			if(rs.getString(5).equals("1"))
    	   			{
    	   				out.print("<font style='color:green;'>形式审核通过</font>");
    	   			}
    	   			if(rs.getString(5).equals("10"))
    	   			{
    	   				out.print("<font style='color:red;'>部门审核未通过</font>");
    	   			}
    	   			if(rs.getString(5).equals("11"))
    	   			{
    	   				out.print("<font style='color:green;'>部门审核通过</font>");
    	   			}
    	   			if(rs.getString(5).equals("2"))
    	   			{
    	   				out.print("<font style='color:#FF7F00;'>未审核</font>");
    	   			}
    	            %>
    	            </td>
            	</tr>
            <%
            }
        }
        else if(submit.equals("查询"))
        {
        	if(nname==null)
            {
        		String sql="select id,Organname,Contacts,needname,states from needtable where states!='3'";
                ResultSet rs=db.executeQuery(sql);
                while(rs.next())
                {
                	%>
                	<tr>
        	        	<td ><%=rs.getString(2)%></td>
        	            <td><%=rs.getString(3) %></td>
        	            <td ><%out.print("<a href='wlshshow2.jsp?id="+rs.getInt(1)+"'>"+rs.getString(4)+"</a>");%></td>
        	            <td >
        	            <%
    	            if(rs.getString(5).equals("0"))
    	   			{
    	   				out.print("<font style='color:red;'>形式审核未通过</font>");
    	   			}
    	   			if(rs.getString(5).equals("1"))
    	   			{
    	   				out.print("<font style='color:green;'>形式审核通过</font>");
    	   			}
    	   			if(rs.getString(5).equals("10"))
    	   			{
    	   				out.print("<font style='color:red;'>部门审核未通过</font>");
    	   			}
    	   			if(rs.getString(5).equals("11"))
    	   			{
    	   				out.print("<font style='color:green;'>部门审核通过</font>");
    	   			}
    	   			if(rs.getString(5).equals("2"))
    	   			{
    	   				out.print("<font style='color:#FF7F00;'>未审核</font>");
    	   			}
        	            %>
        	            </td>
                	</tr>
                <%
                }
            }
        	else
        	{
        		String sql="select id,Organname,Contacts,needname,states from needtable where states!='3' and needname like '%"+nname+"%'";
                ResultSet rs=db.executeQuery(sql);
                while(rs.next())
                {
                	%>
                	<tr>
        	        	<td ><%=rs.getString(2)%></td>
        	            <td><%=rs.getString(3) %></td>
        	            <td ><%out.print("<a href='wlshshow2.jsp?id="+rs.getInt(1)+"'>"+rs.getString(4)+"</a>");%></td>
        	            <td >
        	            <%
        	            if(rs.getString(5).equals("0"))
        	   			{
        	   				out.print("<font style='color:red;'>形式审核未通过</font>");
        	   			}
        	   			if(rs.getString(5).equals("1"))
        	   			{
        	   				out.print("<font style='color:green;'>形式审核通过</font>");
        	   			}
        	   			if(rs.getString(5).equals("10"))
        	   			{
        	   				out.print("<font style='color:red;'>部门审核未通过</font>");
        	   			}
        	   			if(rs.getString(5).equals("11"))
        	   			{
        	   				out.print("<font style='color:green;'>部门审核通过</font>");
        	   			}
        	   			if(rs.getString(5).equals("2"))
        	   			{
        	   				out.print("<font style='color:#FF7F00;'>未审核</font>");
        	   			}
        	            %>
        	            </td>
                	</tr>
                <%
                }
        	}
        }
        else if(submit.equals("已审核"))
        {
        	String sql="select id,Organname,Contacts,needname,states from needtable where states!='2' and states!='3'";
            ResultSet rs=db.executeQuery(sql);
            while(rs.next())
            {
            	%>
            	<tr>
    	        	<td ><%=rs.getString(2)%></td>
    	            <td><%=rs.getString(3) %></td>
    	            <td ><%out.print("<a href='wlshshow2.jsp?id="+rs.getInt(1)+"'>"+rs.getString(4)+"</a>");%></td>
    	            <td >
    	            <%
    	            if(rs.getString(5).equals("0"))
    	   			{
    	   				out.print("<font style='color:red;'>形式审核未通过</font>");
    	   			}
    	   			if(rs.getString(5).equals("1"))
    	   			{
    	   				out.print("<font style='color:green;'>形式审核通过</font>");
    	   			}
    	   			if(rs.getString(5).equals("10"))
    	   			{
    	   				out.print("<font style='color:red;'>部门审核未通过</font>");
    	   			}
    	   			if(rs.getString(5).equals("11"))
    	   			{
    	   				out.print("<font style='color:green;'>部门审核通过</font>");
    	   			}
    	            %>
    	            </td>
            	</tr>
            <%
            }
        }
        else if(submit.equals("未审核"))
        {
        	String sql="select id,Organname,Contacts,needname,states from needtable where states='2'";
            ResultSet rs=db.executeQuery(sql);
            while(rs.next())
            {
            	%>
            	<tr>
    	        	<td ><%=rs.getString(2)%></td>
    	            <td><%=rs.getString(3) %></td>
    	            <td ><%out.print("<a href='wlshshow2.jsp?id="+rs.getInt(1)+"'>"+rs.getString(4)+"</a>");%></td>
    	            <td >
    	             	<font style='color:#FF7F00;'>未审核</font>
    	            </td>
            	</tr>
            <%
            }
        }
        db.close();
        %>
        </table>	
	</div>
	</body>
	</html>