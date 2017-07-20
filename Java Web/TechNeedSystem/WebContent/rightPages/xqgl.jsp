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
		    
		    #newxq{
		    /*	background-color:#FFEC8B;*/
			    color:red;
			    float:right;
			  /*  height:30px;
			    font-size:16px;
			    width:100px;
			    border:none;
			    */
		    }
		    #newxq:hover
		    {
		    	/*background-color:#FFFF00;*/
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
		    	height:33px;
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
	
        <%
	       request.setCharacterEncoding("UTF-8");
	       String uname=(String)session.getAttribute("username");
	       String sql="select Organname from userinfo where username='"+uname+"'";
	       ResultSet rs=db.executeQuery(sql);
	       String jgmc="";
	       if(rs.next())
	       {
	    	   jgmc=rs.getString(1);
	       }
	    %>
	    <a href="xqzj.jsp" id="newxq">添加技术需求</a>
	    <form action="xqgl.jsp" name="form1" method="post">
	    <strong>技术需求名称:</strong>
    	<input type="text" name="txtquery" id="txtquery" style="height:25px;font-size:16px;"/> 
    	<input type="submit" name="submit" value="查询" class="btn"/>&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="submit" name="submit" value="已审核" style="width:80px;" class="btn"/>&nbsp;
    	<input type="submit" name="submit" value="未审核" style="width:80px;"  class="btn"/>
    	<br/><br/>
    	</form>
	<div style="text-align:center;">
		<table  width="100%" align="center"> 
        <tr style="font-weight:bold;background-color:#969696;">
            <td width="" >机构全称</td>
            <td width="" >联系人</td>
            <td width="" >技术需求名称</td>
            <td width="" >状态</td>
            <td width="10%" >操作</td>
        </tr>
        
        <%
        String nname=request.getParameter("txtquery");
        String submit=request.getParameter("submit");
        //System.out.println(submit);
       // System.out.println(nname);
       if(submit==null)
       {
    	   sql="select id,Contacts,needname,states from needtable where Organname='"+jgmc+"'";
           rs=db.executeQuery(sql);
           while(rs.next())
           {
           	%>
           	<tr>
   	        	<td ><%=jgmc%></td>
   	            <td><%=rs.getString(2) %></td>
   	            <td ><%=rs.getString(3) %></td>
   	            <td >
   	            <%
   	       		//形式或部门未通过 
   	   			if(rs.getString(4).equals("0")||rs.getString(4).equals("10"))
   	   			{
   	   				out.print("<font style='color:red;'>审核未通过</font>");
   	   			}
   	   			//部门审核通过
   	   			if(rs.getString(4).equals("11"))
   	   			{
   	   				out.print("<font style='color:green;'>审核通过</font>");
   	   			}
   	   			//未审核或形式审核通过，部门未审核 
   	   			if(rs.getString(4).equals("2")||rs.getString(4).equals("1"))
   	   			{
   	   				out.print("<font style='color:#FF7F00;'>待审核</font>");
   	   			}
   	            if(rs.getString(4).equals("3"))
   	            {
   	            	out.print("未提交");
   	            }
   	            %>
   	            </td>
   	            <td align="left">
   	            <%
   	            //未提交 修改
   	            if(rs.getString(4).equals("3"))
   	            {
   	            	out.print("<a href='xqgledit.jsp?id="+rs.getInt(1)+"&states=3'>修改</a>");
   	            	%>
   	            	&nbsp;<a href='xqgldel.jsp?id=<%=rs.getInt(1)%>' onclick='javascript:return confirm("确认删除?");' >删除</a>
   	            	<%
   	            }
   	            //审核完成 详情
   	            if(!rs.getString(4).equals("3"))
   	            {
   	            	out.print("<a href='wlshshow2.jsp?id="+rs.getInt(1)+"'>详情</a>");
   	            	if(rs.getString(4).equals("0")||rs.getString(4).equals("10"))
	            	{
   	            		%>
   	   	            	&nbsp;<a href='xqgldel.jsp?id=<%=rs.getInt(1)%>' onclick='javascript:return confirm("确认删除?");' >删除</a>
   	   	            	<%
	            	}
   	            }
   	            %>
   	            </td>
           	</tr>
           	<%
           }  
           db.close();
       }
       else if(submit.equals("查询"))
       {
        if(nname==null)
        {
        	sql="select id,Contacts,needname,states from needtable where Organname='"+jgmc+"'";
            rs=db.executeQuery(sql);
            while(rs.next())
            {
            	%>
            	<tr>
    	        	<td ><%=jgmc%></td>
    	            <td><%=rs.getString(2) %></td>
    	            <td ><%=rs.getString(3) %></td>
    	            <td >
    	            <%
    	          	//形式或部门未通过 
       	   			if(rs.getString(4).equals("0")||rs.getString(4).equals("10"))
       	   			{
       	   				out.print("<font style='color:red;'>审核未通过</font>");
       	   			}
       	   			//部门审核通过
       	   			if(rs.getString(4).equals("11"))
       	   			{
       	   				out.print("<font style='color:green;'>审核通过</font>");
       	   			}
       	   			//未审核或形式审核通过，部门未审核 
       	   			if(rs.getString(4).equals("2")||rs.getString(4).equals("1"))
       	   			{
       	   				out.print("<font style='color:#FF7F00;'>待审核</font>");
       	   			}
       	            if(rs.getString(4).equals("3"))
       	            {
       	            	out.print("未提交");
       	            }
    	            %>
    	            </td>
    	            <td align="left">
    	            <%
    	            //未提交 修改
    	            if(rs.getString(4).equals("3"))
    	            {
    	            	out.print("<a href='xqgledit.jsp?id="+rs.getInt(1)+"&states=3'>修改</a>");
    	            	%>
   	            	&nbsp;<a href='xqgldel.jsp?id=<%=rs.getInt(1)%>' onclick='javascript:return confirm("确认删除?");' >删除</a>
   	            	<%
    	            }
    	            //已提交 详情
    	            else
    	            {
    	            	out.print("<a href='wlshshow2.jsp?id="+rs.getInt(1)+"'>详情</a>");
    	            	if(rs.getString(4).equals("0")||rs.getString(4).equals("10"))
    	            	{
    	            		%>
    	   	            	&nbsp;<a href='xqgldel.jsp?id=<%=rs.getInt(1)%>' onclick='javascript:return confirm("确认删除?");' >删除</a>
    	   	            	<%
    	            	}
    	            }
    	            %>
    	            </td>
            	</tr>
            	<%
            }  
            db.close();
        }
        else
        {
        	sql="select id,Contacts,needname,states from needtable where Organname='"+jgmc+"' and needname like '%"+nname+"%'";
            rs=db.executeQuery(sql);
            
            while(rs.next())
            {
            	%>
            	<tr>
    	        	<td ><%=jgmc%></td>
    	            <td><%=rs.getString(2) %></td>
    	            <td ><%=rs.getString(3) %></td>
    	            <td >
    	            <%
    	          //形式或部门未通过 
       	   			if(rs.getString(4).equals("0")||rs.getString(4).equals("10"))
       	   			{
       	   				out.print("<font style='color:red;'>审核未通过</font>");
       	   			}
       	   			//部门审核通过
       	   			if(rs.getString(4).equals("11"))
       	   			{
       	   				out.print("<font style='color:green;'>审核通过</font>");
       	   			}
       	   			//未审核或形式审核通过，部门未审核 
       	   			if(rs.getString(4).equals("2")||rs.getString(4).equals("1"))
       	   			{
       	   				out.print("<font style='color:#FF7F00;'>待审核</font>");
       	   			}
       	            if(rs.getString(4).equals("3"))
       	            {
       	            	out.print("未提交");
       	            }
    	            %>
    	            </td>
    	            <td align="left">
    	            <%
    	            //未提交 修改
    	            if(rs.getString(4).equals("3"))
    	            {
    	            	out.print("<a href='xqgledit.jsp?id="+rs.getInt(1)+"&states=3'>修改</a>");
    	            	%>
       	            	&nbsp;<a href='xqgldel.jsp?id=<%=rs.getInt(1)%>' onclick='javascript:return confirm("确认删除?");' >删除</a>
       	            	<%
    	            }
    	            //已提交 详情
    	            else
    	            {
    	            	out.print("<a href='wlshshow2.jsp?id="+rs.getInt(1)+"'>详情</a>");
    	            	if(rs.getString(4).equals("0")||rs.getString(4).equals("10"))
    	            	{
    	            		%>
    	   	            	&nbsp;<a href='xqgldel.jsp?id=<%=rs.getInt(1)%>' onclick='javascript:return confirm("确认删除?");' >删除</a>
    	   	            	<%
    	            	}
    	            }
    	            %>
    	            </td>
            	</tr>
            	<%
            } 
            db.close();
        }
       }
       else if(submit.equals("已审核"))
       {
    	   sql="select id,Contacts,needname,states from needtable where Organname='"+jgmc+"' and (states='0' or states='10' or states='11')";
           //System.out.println(sql);
    	   rs=db.executeQuery(sql);
           while(rs.next())
           {
           	%>
           	<tr>
   	        	<td ><%=jgmc%></td>
   	            <td><%=rs.getString(2) %></td>
   	            <td ><%=rs.getString(3) %></td>
   	            <td align="left">
   	            <%
   	       		//形式或部门未通过 
   	   			if(rs.getString(4).equals("0")||rs.getString(4).equals("10"))
   	   			{
   	   				out.print("<font style='color:red;'>审核未通过</font>");
   	   			}
   	   			//部门审核通过
   	   			if(rs.getString(4).equals("11"))
   	   			{
   	   				out.print("<font style='color:green;'>审核通过</font>");
   	   			}
   	            %>
   	            </td>
   	            <td>
   	            <%
   	         	out.print("<a href='wlshshow2.jsp?id="+rs.getInt(1)+"'>详情</a>");
   	         	if(rs.getString(4).equals("0")||rs.getString(4).equals("10"))
         		{
   	         	%>
	            	&nbsp;<a href='xqgldel.jsp?id=<%=rs.getInt(1)%>' onclick='javascript:return confirm("确认删除?");' >删除</a>
	            	<%
	         	}
	   	        %>
   	            </td>
           	</tr>
           	<%
           }  
           db.close();
       }
       else if(submit.equals("未审核"))
       {
    	   sql="select id,Contacts,needname,states from needtable where Organname='"+jgmc+"' and (states='2' or states='1')";
    	   rs=db.executeQuery(sql);
           while(rs.next())
           {
           	%>
           	<tr>
   	        	<td ><%=jgmc%></td>
   	            <td><%=rs.getString(2) %></td>
   	            <td ><%=rs.getString(3) %></td>
   	            <td >
   	            <font style='color:#FF7F00;'>未审核</font>
   	            </td>
   	            <td>
   	           	<%out.print("<a href='wlshshow2.jsp?id="+rs.getInt(1)+"'>详情</a>"); %>
   	            </td>
           	</tr>
           	<%
           }  
           db.close();
       }
        %>
        </table>	
	</div>
	
	</body>
	</html>