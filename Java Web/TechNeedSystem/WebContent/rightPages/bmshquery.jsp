<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
        <link rel="SHORTCUT ICON" href="image/bt.ico" />
         <style type="text/css">
		    a{
		    color:blue;
		    text-decoration:none;
		    }
		    a:hover{
		    text-decoration:underline;
		    }
		    table#re {
		    border-collapse:collapse;
		    }
		    table#re tr td{ border-bottom:1px solid #dedede;}
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
				$("table#re tr:even").addClass("even"); 
			}); 
		</script> 
    </head>

    <body>
    
        <jsp:useBean id="db" class="bean.DBBean" scope="page" />
        <div style="text-align:center;">
        <table width="100%" align="center" id="re"> 
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
        String cxfs="",xqmc="",jgmc="",szdy="",gkbm="",jgsx="",hdlx="";
        cxfs=request.getParameter("cxfs");
        String uname=(String)session.getAttribute("username");
	    String sql="select glbm from mgtinfo where username='"+uname+"'";
	    ResultSet rs=db.executeQuery(sql);
	    String glbm="";
	    if(rs.next())
	    {
	    	glbm=rs.getString(1);
	    }
	    //System.out.println(glbm);
        xqmc=request.getParameter("xqmc");
        jgmc=request.getParameter("jgmc");
        if(xqmc!=null)
        {
        	xqmc=xqmc.trim();
        }
        if(jgmc!=null)
        {
        	jgmc=jgmc.trim();
        }
        gkbm=request.getParameter("gkbm");
        szdy=request.getParameter("szdy");
        jgsx=request.getParameter("jgsx");
        hdlx=request.getParameter("hdlx");
        //System.out.println(cxfs+" "+xqmc+" "+jgmc+" "+gkbm+" "+szdy+" "+jgsx+" "+hdlx);  
        String submit = request.getParameter("submit");
      // System.out.println(submit);
       if(submit==null||submit=="")
       {
    	   sql="select id,needname,Organname,LocationArea,organattr,states from needtable where glbm='"+glbm+"' and (states='1' or states='10' or states='11')";
    	   rs = db.executeQuery(sql);
    	   int i=0;
   		while(rs.next())
   		{
   			i++;
   			String dy=rs.getString(4);
   			int id=rs.getInt(1);
   			%>
   			<tr>
   			<td><%=i %></td>
   			<td>
			<%if(rs.getString(6).equals("1")) out.print("<a href='bmshshow.jsp?id="+id+"'>"+rs.getString(2)+"</a>");
			else out.print("<a href='wlshshow2.jsp?id="+id+"'>"+rs.getString(2)+"</a>");
			%>
			</td>
   			<td><%=rs.getString(3)%></td>
   			<td><%if(!dy.equals("")) out.print(dy.substring(7));%></td>
   			<td><%=rs.getString(5)%></td>
   			<td><%
   			if(rs.getString(6).equals("10"))
   			{
   				out.print("<font style='color:red;'>部门审核未通过</font>");
   			}
   			if(rs.getString(6).equals("11"))
   			{
   				out.print("<font style='color:green;'>部门审核通过</font>");
   			}
   			if(rs.getString(6).equals("1"))
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
        sql="select id,needname,Organname,LocationArea,organattr,states from needtable where glbm='"+glbm+"' and (states='1' or states='10' or states='11')";
        if(cxfs.equals("jq"))
        {
        	if(xqmc!="")
            {
            	sql+=" and needname='"+xqmc+"'";
            }
            if(jgmc!="")
            {
            	sql+=" and Organname='"+jgmc+"'";
            }
            if(!gkbm.equals("select"))
            {
            	sql+=" and parentmgt='"+gkbm+"'";
            }
            if(!szdy.equals("select"))
            {
            	sql+=" and LocationArea='"+szdy+"'";
            }
            if(!jgsx.equals("select"))
            {
            	sql+=" and organattr='"+jgsx+"'";
            }
            if(!hdlx.equals("select"))
            {
            	sql+=" and restype='"+hdlx+"'";
            }
        }
        if(cxfs.equals("mh"))
        {
        	if(xqmc!="")
            {
            	sql+=" and needname like '%"+xqmc+"%'";
            }
            if(jgmc!="")
            {
            	sql+=" and Organname like '%"+jgmc+"%'";
            }
            if(!gkbm.equals("select"))
            {
            	sql+=" and parentmgt like '%"+gkbm+"%'";
            }
            if(!szdy.equals("select"))
            {
            	sql+=" and LocationArea like '%"+szdy+"%'";
            }
            if(!jgsx.equals("select"))
            {
            	sql+=" and organattr like '%"+jgsx+"%'";
            }
            if(!hdlx.equals("select"))
            {
            	sql+=" and restype like '%"+hdlx+"%'";
            }
        }
        if(submit.equals("已审核"))
        {
        	sql="select id,needname,Organname,LocationArea,organattr,states from needtable where glbm='"+glbm+"' and (states='10' or states='11')";
        }
        if(submit.equals("未审核"))
        {
        	sql="select id,needname,Organname,LocationArea,organattr,states from needtable where glbm='"+glbm+"' and states='1'";
        }
       
       // System.out.println(sql);
		rs = db.executeQuery(sql);
		int i=0;
		while(rs.next())
		{
			i++;
			String dy=rs.getString(4);
			int id=rs.getInt(1);
			%>
			<tr>
			<td><%=i %></td>
			<td>
			<%if(rs.getString(6).equals("1")) out.print("<a href='bmshshow.jsp?id="+id+"'>"+rs.getString(2)+"</a>");
			else out.print("<a href='wlshshow2.jsp?id="+id+"'>"+rs.getString(2)+"</a>");
			%>
			</td>
			<td><%=rs.getString(3)%></td>
			<td><%if(!dy.equals("")) out.print(dy.substring(7));%></td>
			<td><%=rs.getString(5)%></td>
			<td><%
			if(rs.getString(6).equals("10"))
   			{
   				out.print("<font style='color:red;'>部门审核未通过</font>");
   			}
   			if(rs.getString(6).equals("11"))
   			{
   				out.print("<font style='color:green;'>部门审核通过</font>");
   			}
   			if(rs.getString(6).equals("1"))
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