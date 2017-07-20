<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        
        <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
         <style type="text/css">
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
			.odd{background:#FFFFEE;} 
			.selected{background:#FF9900;} 
		</style> 
		<script type="text/javascript"> 
			$(function(){ 
				$("tr:even").addClass("even"); 
			}); 
		</script> 
    </head>

    <body>
    
        <jsp:useBean id="db" class="bean.DBBean" scope="page" />
        <div style="text-align:center;">
        <table width="100%" align="center"> 
        <tr style="font-weight:bold;background-color:#969696;">
        	<td>序号</td>
        	<td width="" >技术需求名称</td>
            <td width="" >机构全称</td>
            <td width="" >所在地域</td>
            <td width="" >机构属性</td>
            <td width="" >审核状态</td>
            
        </tr>
        <%
        request.setCharacterEncoding("UTF-8");
        String submit="",type="",value="",xsstates="",bmstates="";
        submit=request.getParameter("submit");
        
        type=request.getParameter("qtype");
        value=request.getParameter("txt");
        xsstates=request.getParameter("xssftg");
        bmstates=request.getParameter("bmsftg");
      // System.out.println(xsstates+bmstates);
       if(submit==null||submit=="")
       {
    	   String sql="select id,needname,Organname,LocationArea,organattr,states from needtable where states!='3'";
    	   ResultSet rs = db.executeQuery(sql);
    	   int i=0;
   		while(rs.next())
   		{
   			i++;
   			String dy=rs.getString(4);
   			int id=rs.getInt(1);
   			%>
   			<tr>
   			<td><%=i%></td>
   			<td>
			<%out.print("<a href='wlshshow2.jsp?id="+id+"'>"+rs.getString(2)+"</a>");
			%>
			</td>
   			<td><%=rs.getString(3)%></td>
   			<td><%if(!dy.equals("")) out.print(dy.substring(7));%></td>
   			<td><%=rs.getString(5)%></td>
   			<td><%
   			if(rs.getString(6).equals("0"))
   			{
   				out.print("<font style='color:red;'>形式审核未通过</font>");
   			}
   			if(rs.getString(6).equals("1"))
   			{
   				out.print("<font style='color:green;'>形式审核通过</font>");
   			}
   			if(rs.getString(6).equals("10"))
   			{
   				out.print("<font style='color:red;'>部门审核未通过</font>");
   			}
   			if(rs.getString(6).equals("11"))
   			{
   				out.print("<font style='color:green;'>部门审核通过</font>");
   			}
   			if(rs.getString(6).equals("2"))
   			{
   				out.print("<font style='color:#FF7F00;'>未审核</font>");
   			}
   			%></td>
   			</tr>
   			<%
   		}	
   		db.close();
       }
       else
       {
        String sql="select id,needname,Organname,LocationArea,organattr,states from needtable where states!='3'";
        if(submit.equals("精确查询"))
        {
        	if(!type.equals("select")&&value!="")
            {
        		if(type.equals("needfield")||type.equals("needindustry")||type.equals("subtype")||type.equals("glbm"))
        		{
        			sql+=" and "+type+" like '%"+value+"%'";
        		}
        		else
        		{
        			sql+=" and "+type+"='"+value+"'";
        		}
            }
        	if(xsstates!=null)
        	{
        		if(bmstates!=null)
        		{
        			sql+=" and states='"+bmstates+"'";
        		}
        		else
        		{
        			sql+=" and states='"+xsstates+"'";
        		}
        	}
        	else
        	{
        		if(bmstates!=null)
        		{
        			sql+=" and states='"+bmstates+"'";
        		}
        	}
        }
        if(submit.equals("模糊查询"))
        {
        	if(!type.equals("select")&&value!="")
            {
            	sql+=" and "+type+" like '%"+value+"%'";
            }
        	if(xsstates!=null)
        	{
        		if(bmstates!=null)
        		{
        			sql+=" and states='"+bmstates+"'";
        		}
        		else
        		{
        			sql+=" and states='"+xsstates+"'";
        		}
        	}
        	else
        	{
        		if(bmstates!=null)
        		{
        			sql+=" and states='"+bmstates+"'";
        		}
        	}
        }
       
        //System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		int i=0;
		while(rs.next())
		{
			i++;
			String dy=rs.getString(4);
			int id=rs.getInt(1);
			%>
			<tr>
			<td><%=i%></td>
			<td>
			<%out.print("<a href='wlshshow2.jsp?id="+id+"'>"+rs.getString(2)+"</a>");
			%>
			</td>
			<td><%=rs.getString(3)%></td>
			<td><%if(!dy.equals("")) out.print(dy.substring(7));%></td>
			<td><%=rs.getString(5)%></td>
			<td><%
			if(rs.getString(6).equals("0"))
   			{
   				out.print("<font style='color:red;'>形式审核未通过</font>");
   			}
   			if(rs.getString(6).equals("1"))
   			{
   				out.print("<font style='color:green;'>形式审核通过</font>");
   			}
   			if(rs.getString(6).equals("10"))
   			{
   				out.print("<font style='color:red;'>部门审核未通过</font>");
   			}
   			if(rs.getString(6).equals("11"))
   			{
   				out.print("<font style='color:green;'>部门审核通过</font>");
   			}
   			if(rs.getString(6).equals("2"))
   			{
   				out.print("<font style='color:#FF7F00;'>未审核</font>");
   			}
			%></td>
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