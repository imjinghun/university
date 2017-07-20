<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<%@taglib uri="/struts-tags" prefix="s"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
			    float:left;
			    margin-bottom:10px;
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
        <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript"> 
			$(function(){ 
				$("tr:even").addClass("even");
			}); 
		</script> 
	</head>
	<body>
	<div>
	    <a href="rightPages/xqzj.jsp" id="newxq">添加技术需求</a>
	 </div>   
	<div style="text-align:center; margin-top:10px;">
		<table  width="100%" align="center"> 
        <tr style="font-weight:bold;background-color:#969696;">
        
            <td width="10%" >编号</td>
            <td width="50%" >技术需求名称</td>
            <td width="" >状态</td>
            <td width="10%" >操作</td>
        </tr>
        <s:if test="#request.listNeed != null">
  	 		<s:iterator var="need" value="#request.listNeed" status="st">
  	 			<tr>
  	 				<td> <s:property value="#st.count"/> </td>
  	 				<td> <s:property value="#need.needname"/> </td>
  	 				<td> <s:property value="#need.states"/> </td>
  	 				<td> 
  	 					<s:if test="#need.states == '未提交'">
  	 						<s:a href="need_viewUpdate?id=%{#need.id}">修改</s:a>
  	 					</s:if>
  	 					<s:elseif test="#need.states == '形式审核未通过'">
  	 						<s:a href="need_view?id=%{#need.id}">详情</s:a>&nbsp;
  	 						<s:a href="need_delete?id=%{#need.id}">
							<label onclick="javascript:return confirm('确认要删除?');">删除</label>
							</s:a>
  	 					</s:elseif>
  	 					<s:elseif test="#need.states == '部门审核未通过'">
  	 						<s:a href="need_view?id=%{#need.id}">详情</s:a>&nbsp;
  	 						<s:a href="need_delete?id=%{#need.id}">
  	 						<label onclick="javascript:return confirm('确认要删除?');">删除</label>
							</s:a>
  	 					</s:elseif>
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