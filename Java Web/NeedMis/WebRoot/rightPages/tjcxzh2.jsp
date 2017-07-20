<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <%@taglib uri="/struts-tags" prefix="s"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        
        <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
         <style type="text/css">
		    #two {
		    border-collapse:collapse;
		    }
		    #two tr td{ border-bottom:1px solid #dedede;}
		    #two tr{
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
				$("#two tr:even").addClass("even"); 
			}); 
		</script> 
    </head>

    <body>
    <table width="100%" align="center" id="two"> 
        <tr style="font-weight:bold;background-color:#969696;">
        	<td width="10%" >编号</td>
            <td width="20%" >机构全称</td>
            <td width="30%" >技术需求名称</td>
            <td width="" >状态</td>
            <td width="10%" >操作</td>
        </tr>
        <s:if test="#request.listZh != null">
  	 		<s:iterator var="need" value="#request.listZh" status="st">
  	 			<tr>
  	 				<td> <s:property value="#st.count"/> </td>
  	 				<td> <s:property value="#need.organname"/> </td>
  	 				<td> <s:property value="#need.needname"/> </td>
  	 				<td> <s:property value="#need.states"/> </td>
  	 				<td> 
  	 					<s:a href="need_view?id=%{#need.id}">详情</s:a>
  	 				</td>
  	 			</tr>
  	 		</s:iterator>
  	 	</s:if>
    </table>

    </body>

    </html>