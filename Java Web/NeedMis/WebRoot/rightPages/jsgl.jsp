<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<style type="text/css">
		    table {
		    border-collapse:collapse;
		    }
		    table tr td{ border-bottom:1px solid #dedede;}
		    table tr{
		    height:25px;
		    }
        </style>
        <style> 
			.even{background:#D9D9D9;} 
			.odd{background:#FFFFEE;} 
			.selected{background:#FF9900;} 
		</style> 
		<script type="text/javascript"> 
			$(function(){  
				$("table tr:even").addClass("even"); 
			}); 
		</script>
</head>
<body>
<div>
 <div style="text-align:center;"> 
 	<font style="font-weight:bold;font-size:25px;">角色权限管理</font> 
 	<hr style="border:none;border-top:1px solid #838B8B;"/>
 	<div>
 <strong>请选择角色:</strong>
 <select id="xzjs" name="xzjs">
 	<option id="tbyh">填报需求员</option>
 	<option id="xsshy">形式审核员</option>
 	<option id="bmshy">部门审核员</option>
 </select>
 </div>
 </div>
 <div style="margin-top:20px;">
 <jsp:include page="qxxqtby.jsp"></jsp:include>
 </div>
 
</div>
</body>
</html>