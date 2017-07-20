<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.div {
	border: 1px solid grey;
	border-bottom: 1px solid transparent;
	font-size: 14px;
}

.div2 {
	border: 1px solid grey;
	border-top: 1px solid transparent;
	font-size: 14px;
}

select {
	height: 24px;
	font-size: 14px;
}

input {
	height: 18px;
	font-size: 14px;
}

.btn {
	margin-left: 5px;
	vertical-align: middle;
	width: 60px;
	height: 26px;
	font-size: 14px;
	border: none;
	border-radius: 5px;
	color: white;
	background-color: rgba(99, 86, 255, 1);
}

.btn:hover {
	background-color: #282ff7;
}
</style>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>

<script>
	function addtr() {
		var rows = $("#mytable").find("tr").length;
		if (rows < 15) {
			$("#mytable").append("<tr><td>"
									+ "<select style='margin:auto 5px;' name='sel0'>"
									+ "<option value='and'>并且</option>"
									+ "<option value='or'>或者</option>"
									+ "</select></td><td>"
									+ "<select style='margin:auto 5px;' name='sel2'>"
									+ "<option value='needname'>需求名称</option>"
									+ "<option value='organname'>机构名称</option>"
									+ "<option value='totalmoney'>资金总额</option> "
									+ "<option value='needkey'>关键字</option>"
									+ "<option value='legalperson'>法人代表</option>"
									+ "<option value='contacts'>联系人</option>"
									+ "<option value='subtype'>学科分类</option>"
									+ "<option value='needindustry'>需求技术应用行业</option>"
									+ "<option value='glbm'>管理处室</option>"
									+ "<option value='parentmgt'>归口管理单位</option>"
									+ "<option value='LocationArea'>所在地域</option>"
									+ "<option value='organattr'>机构属性</option>"
									+ "<option value='needmodel'>技术需求解决方式</option>"
									+ "<option value='needfield'>需求技术所属领域</option>"
									+ "<option value='restype'>科技活动类型</option>"
									+ "</select>"
									+ "<input style='margin:auto 5px;' name='inputvalue'/>"
									+ "<select style='margin:auto 5px;' name='sel3'>"
									+ "<option value='jingque'>精确</option>"
									+ "<option value='mohu'>模糊</option>"
									+ "</select></td></tr>");
		}
	}
	function deltr() {
		var rows = $("#mytable").find("tr").length;
		if (rows > 1) {
			$("#mytable tr:last-child").remove();
		}
	}

	function submit() {
		var s0 = document.getElementsByName("sel0");
		var s2 = document.getElementsByName("sel2");
		var s3 = document.getElementsByName("sel3");
		var sel4 = document.getElementById("sel4").value;
		var iv = document.getElementsByName("inputvalue");

		var sel0 = new Array();
		var sel2 = new Array();
		var sel3 = new Array();
		var inputvalue = new Array();
		for ( var i = 0; i < s0.length; i++) {
			sel0[i] = s0[i].value;
		}
		for ( var i = 0; i < s2.length; i++) {
			sel2[i] = s2[i].value;
		}
		for ( var i = 0; i < s3.length; i++) {
			sel3[i] = s3[i].value;
		}
		for ( var i = 0; i < iv.length; i++) {
			inputvalue[i] = iv[i].value;
		}

		var s0=JSON.stringify(sel0);
		var s2=JSON.stringify(sel2);
		var s3=JSON.stringify(sel3);
		var iv=JSON.stringify(inputvalue);
		
		
		$.ajax({
			type : "post",
			url : "../ajax/zhjs",
			data : {
			"sel0" : s0,//JSON.stringify(sel0),
			"sel2" : s2,//JSON.stringify(sel2),
			"sel3" : s3,//JSON.stringify(sel3),
			"sel4" : sel4,
			"inputvalue" : iv//JSON.stringify(inputvalue)
			},
			dataType : "json",
			success : function(data) {
				$("#divshow").html(data);
			},
			error : function(msg) {
			//为什么是错误返回
				$("#divshow").html(msg.responseText);
				console.log(msg.responseText);
			}
		});
	}
</script>
<!-- 动态增减 查询条件 -->
<script>
	$(function() {
		$("#add").click(addtr);
		$("#del").click(deltr);
		$("#submit").click(submit);
	});
</script>
</head>

<body>
	<div class="div">
		<p style="margin-left:5px;font-size:14px;">输入检索条件：</p>
		<table width="100%" id="mytable">
			<tr>
				<td width="8%">
					<button id="add" style="width:16px;height:16px;margin-left:6px;">
						<font style="margin:auto -5px;">+</font>
					</button>
					<button id="del" style="width:16px;height:16px;margin-left:6px;">
						<font style="margin:auto -5px;">-</font>
					</button></td>
				<td><select style="margin-left:5px;" name="sel2">
						<option value="needname">需求名称</option>
						<option value="organname">机构名称</option>
						<option value="totalmoney">资金总额</option>
						<option value="needkey">关键字</option>
						<option value="legalperson">法人代表</option>
						<option value="contacts">联系人</option>
						<option value="subtype">学科分类</option>
						<option value="needindustry">需求技术应用行业</option>
						<option value="glbm">管理处室</option>
						<option value="parentmgt">归口管理单位</option>
						<option value="LocationArea">所在地域</option>
						<option value="organattr">机构属性</option>
						<option value="needmodel">技术需求解决方式</option>
						<option value="needfield">需求技术所属领域</option>
						<option value="restype">科技活动类型</option>
				</select> 
				<input style="margin-left:3px;" name="inputvalue" id="a" /> 
				<select style="margin-left:3px;" name="sel3">
						<option value="jingque">精确</option>
						<option value="mohu">模糊</option>
				</select></td>
			</tr>
		</table>
	</div>
	<div class="div2">

		<div style="margin:5px;">
			<font style="font-size:14px;">审核情况：</font> <select
				style="margin-left:3px;" name="sel4" id="sel4">
				<option value=""></option>
				<option value="通过">通过</option>
				<option value="未通过">未通过</option>
			</select> <input type="submit" value="检索" class="btn" id="submit" />
		</div>
	</div>
	<div style="margin-top:10px;" id="divshow">
		<%-- <jsp:include page="tjcxzh2.jsp"></jsp:include> --%>
	</div>
</body>

</html>