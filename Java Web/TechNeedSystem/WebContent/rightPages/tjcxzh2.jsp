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
		    #btnback{
		    background-color: rgba(99, 86, 255, 1);
		    color:white;
		    border:none;
		    height:30px;
		    width:60px;
		    font-size:16px;
		    }
		    #btnback:hover{
		    background-color: #282ff7;
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
    	<a href="javascript:history.go(-1);">
    		<button id="btnback" >返回</button>
    	</a>
        <jsp:useBean id="db" class="bean.DBBean" scope="page" />
        <div style="text-align:center;margin-top:10px;">
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
        String submit="",xqmc="",jgmc="",zjze="",gjz="",frdb="",lxr="",xkfl="",jshy="",
        		gkbm="",szdy="",jgsx="",jjfs="",jsly="",hdlx="",glbm="",xsstates="",bmstates="";
        
        submit=request.getParameter("submit");
        
        xqmc=request.getParameter("xqmc");
        jgmc=request.getParameter("jgmc");
        zjze=request.getParameter("zjze");
        gjz=request.getParameter("gjz");
        frdb=request.getParameter("frdb");
        lxr=request.getParameter("lxr");
        xkfl=request.getParameter("xkfl");
        jshy=request.getParameter("jshy");
        glbm=request.getParameter("glbm");
        
        gkbm=request.getParameter("gkbm");
        szdy=request.getParameter("szdy");
        jgsx=request.getParameter("jgsx");
        jjfs=request.getParameter("jjfs");
        jsly=request.getParameter("jsly");
        hdlx=request.getParameter("hdlx");
        xsstates=request.getParameter("xssftg");
        bmstates=request.getParameter("bmsftg");
        
        //System.out.println(glbm+xsstates+bmstates);
        if(xqmc!=null)
        {
        	xqmc=xqmc.trim();
        }
        if(jgmc!=null)
        {
        	jgmc=jgmc.trim();
        }
        if(zjze!=null)
        {
        	zjze=zjze.trim();
        }
        if(gjz!=null)
        {
        	gjz=gjz.trim();
        }
        if(frdb!=null)
        {
        	frdb=frdb.trim();
        }
        if(lxr!=null)
        {
        	lxr=lxr.trim();
        }
        if(xkfl!=null)
        {
        	xkfl=xkfl.trim();
        }
        if(jshy!=null)
        {
        	jshy=jshy.trim();
        }
        
        //System.out.println(submit+","+xqmc+","+jgmc+","+zjze+","+gjz+","+frdb+","+lxr+","+xkfl+","+jshy+","+gkbm+","+szdy+","+jgsx+","+jjfs+","+jsly+","+hdlx);  

        String sql="select id,needname,Organname,LocationArea,organattr,states from needtable where states!='3'";
        if(submit.equals("精确查询"))
        {
        	if(xqmc!="")
            {
            	sql+=" and needname='"+xqmc+"'";
            }
            if(jgmc!="")
            {
            	sql+=" and Organname='"+jgmc+"'";
            }
            if(zjze!="")
            {
            	sql+=" and totalmoney="+zjze+"";
            }
            if(gjz!="")
            {
            	sql+=" and needkey like '%"+gjz+"%'";
            }
            if(frdb!="")
            {
            	sql+=" and Legalperson='"+frdb+"'";
            }
            if(lxr!="")
            {
            	sql+=" and Contacts='"+lxr+"'";
            }
            if(xkfl!="")
            {
            	sql+=" and subtype like '%"+xkfl+"%'";
            }
            if(jshy!="")
            {
            	sql+=" and needindustry like '%"+jshy+"%'";
            }
            if(!glbm.equals("select"))
            {
            	sql+=" and glbm='"+glbm+"'";
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
            if(!jjfs.equals("select"))
            {
            	sql+=" and needmodel='"+jjfs+"'";
            }
            if(!jsly.equals("select"))
            {
            	sql+=" and organattr like '%"+jsly+"%'";
            }
            if(!hdlx.equals("select"))
            {
            	sql+=" and restype='"+hdlx+"'";
            }
            //形式 部门是否通过
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
        	if(xqmc!="")
            {
            	sql+=" and needname like '%"+xqmc+"%'";
            }
            if(jgmc!="")
            {
            	sql+=" and Organname like '%"+jgmc+"%'";
            }
            if(zjze!="")
            {
            	sql+=" and totalmoney="+zjze+"";
            }
            if(gjz!="")
            {
            	sql+=" and needkey like '%"+gjz+"%'";
            }
            if(frdb!="")
            {
            	sql+=" and Legalperson like '%"+frdb+"%'";
            }
            if(lxr!="")
            {
            	sql+=" and Contacts like '%"+lxr+"%'";
            }
            if(xkfl!="")
            {
            	sql+=" and subtype like '%"+xkfl+"%'";
            }
            if(jshy!="")
            {
            	sql+=" and needindustry like '%"+jshy+"%'";
            }
            if(!glbm.equals("select"))
            {
            	sql+=" and glbm='"+glbm+"'";
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
            if(!jjfs.equals("select"))
            {
            	sql+=" and needmodel='"+jjfs+"'";
            }
            if(!jsly.equals("select"))
            {
            	sql+=" and organattr like '%"+jsly+"%'";
            }
            if(!hdlx.equals("select"))
            {
            	sql+=" and restype='"+hdlx+"'";
            }
            
          //形式 部门是否通过
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
			String dy=rs.getString(4);
			int id=rs.getInt(1);
			i++;
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
       %>
       	</table>
        </div>
    </body>

    </html>