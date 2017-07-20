<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <%@taglib uri="/struts-tags" prefix="s"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        
        <style>
            .btn1 {
                background-color: #282ff7;
                color: white;
                height: 30px;
                font-size: 16px;
                width: 50px;
                border: 2px;
            }
            
            .btn1:hover {
                background-color: #0000CD;
            }
            
            .btn2 {
                background-color: #282ff7;
                color: white;
                height: 30px;
                font-size: 16px;
                width: 150px;
                border: 2px;
                margin-left: 20px;
            }
            
            .btn2:hover {
                background-color: #0000CD;
            }
            .btn21 {
                background-color: #4876FF;
                color: white;
                height: 30px;
                font-size: 16px;
                width: 120px;
                border: 2px;
                margin-left: 15px;
            }
            
            .btn21:hover {
                background-color: #0000CD;
            }
            .btn3{
                background-color: #282ff7;
                color: white;
                height: 20px;
                font-size: 14px;
                width: 50px;
                border: 2px;
            }
            
            .btn3:hover {
                background-color: #0000CD;
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
       <div style="text-align:center; margin-top:10px;">
       <p style="font-weight:bold;color:#969696;">--------------需求填报员--------------</p>
		<table  width="60%" align="center"> 
        <tr style="font-weight:bold;background-color:#969696;">
        
            <td width="10%" >编号</td>
            <td width="25%" >用户名</td>
            <td width="35%" >所在机构</td>
            <td width="20%" >法人代表</td>
            <td width="10%" >操作</td>
        </tr>
        <s:if test="#request.listUser != null">
  	 		<s:iterator var="list" value="#request.listUser" status="st">
  	 			<tr>
  	 				<td> <s:property value="#st.count"/> </td>
  	 				<td> <s:property value="#list.username"/> </td>
  	 				<td> <s:property value="#list.organname"/> </td>
  	 				<td> <s:property value="#list.legalperson"/> </td>
  	 				<td> 
  	 					<s:a href="user_deleteUser?username=%{#list.username}"><label onclick="javascript:return confirm('确认要删除?');">删除</label></s:a>
  	 				</td>
  	 			</tr>
  	 		</s:iterator>
  	 	</s:if>
        </table>	
        
       <p style="font-weight:bold;color:#969696;">--------------形式审核员--------------</p>
		<table  width="40%" align="center"> 
        <tr style="font-weight:bold;background-color:#969696;">
        
            <td width="" >编号</td>
            <td width="" >用户名</td>
            <td width="" >操作</td>
        </tr>
        <s:if test="#request.listAssessor != null">
  	 		<s:iterator var="list" value="#request.listAssessor" status="st">
  	 			<tr>
  	 				<td> <s:property value="#st.count"/> </td>
  	 				<td> <s:property value="#list.username"/> </td>
  	 				<td> 
  	 					<s:a href="user_deleteUser?username=%{#list.username}"><label onclick="javascript:return confirm('确认要删除?');">删除</label></s:a>
  	 				</td>
  	 			</tr>
  	 		</s:iterator>
  	 	</s:if>
        </table>
        	
       <p style="font-weight:bold;color:#969696;">--------------部门审核员--------------</p>
		<table  width="40%" align="center"> 
        <tr style="font-weight:bold;background-color:#969696;">
        
            <td width="" >编号</td>
            <td width="" >用户名</td>
            <td width="" >所在部门</td>
            <td width="" >操作</td>
        </tr>
        <s:if test="#request.listMgt != null">
  	 		<s:iterator var="list" value="#request.listMgt" status="st">
  	 			<tr>
  	 				<td> <s:property value="#st.count"/> </td>
  	 				<td> <s:property value="#list.username"/> </td>
  	 				<td> <s:property value="#list.glbm"/> </td>
  	 				<td> 
  	 					<s:a href="user_deleteUser?username=%{#list.username}"><label onclick="javascript:return confirm('确认要删除?');">删除</label></s:a>
  	 				</td>
  	 			</tr>
  	 		</s:iterator>
  	 	</s:if>
        </table>	
	</div>
    </body>

    </html>