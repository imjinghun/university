<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <%@taglib uri="/struts-tags" prefix="s"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
        <style type="text/css">
            .btn{
            margin-left:2%;
            margin-top:1%;
            vertical-align:middle;
            width:80px;
            height:30px;
            font-size:16px;
            border:none;
            color:white;
            background-color:rgba(99, 86, 255, 1);
            }
            .btn:hover{
            background-color:#282ff7;
            }
         table {
		    border-collapse:collapse;
		    height: 35px;
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
			//	$("#del").click(function(){return confirm('确认删除吗');});
			}); 
		</script> 
    </head>

    <body>
        <div id="up" style="width:100%;border:1px solid #a39e9e;overflow:auto;">
           <table  width="100%" align="center"> 
        <tr style="font-weight:bold;background-color:#969696;">
        
            <td width="10%" >编号</td>
            <td width="20%" >机构全称</td>
            <td width="40%" >技术需求名称</td>
            <td width="" >状态</td>
            <td width="10%" >操作</td>
        </tr>
        <s:if test="#request.listNeed != null">
  	 		<s:iterator var="need" value="#request.listNeed" status="st">
  	 			<tr>
  	 				<td> <s:property value="#st.count"/> </td>
  	 				<td> <s:property value="#need.organname"/> </td>
  	 				<td> <s:property value="#need.needname"/> </td>
  	 				<td> <s:property value="#need.states"/> </td>
  	 				<td> 
  	 					<s:if test="#need.states == '形式审核通过' || #need.states == '形式审核未通过'">
  	 						<s:a href="need_viewUpdate?id=%{#need.id}">审核</s:a>
  	 					</s:if>
  	 					<s:else>
  	 						<s:a href="need_view?id=%{#need.id}">详情</s:a>
  	 					</s:else>
  	 				</td>
  	 			</tr>
  	 		</s:iterator>
  	 	</s:if>
        </table>	
        </div>
    </body>

    </html>