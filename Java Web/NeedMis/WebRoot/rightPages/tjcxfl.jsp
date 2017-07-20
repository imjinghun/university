<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/jquery.treeview.css" />

<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.treeview.js"></script>
<script type="text/javascript" src="../js/myjs/fljs.js"></script>
<script>
	$(function(){
		getYiji();
		getMenlei();
	});
</script>

</head>

<body>
<div style="margin:5px;float:left;width:30%;height:600px;border:1px solid black;overflow:auto;">
	<ul id="tree">
        <li><span>学科分类</span>
            <ul id="yiji"></ul>
        </li>
        <li><span>国民经济行业</span>
            <ul id="menlei"></ul>
        </li>
    </ul>
    <script type="text/javascript">
			$("#tree").treeview({
                persist: "location",
                collapsed: true,
                unique: true
             });
             //阻止事件冒泡
             function stopmaopao(e){
				window.event? window.event.cancelBubble = true : e.stopPropagation();
			 }
    </script>
    <script type="text/javascript">
   function submit(type,code,rank) {
   		stopmaopao(this);
		var cs="type="+type+"&code="+code+"&rank="+rank;
		loadAjax2(cs);
	}
	function loadAjax2(cs) {
		var divs=document.getElementById("divshow");
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var result=xmlhttp.responseText;
				divs.innerHTML=result;
			}
			else{
				var result=xmlhttp.responseText;
				divs.innerHTML=result;
			}
		};
		
		xmlhttp.open("POST", "../ajax/fljs", true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send(cs);
	}
   </script>
</div>
<div style="margin:5px;float:right;width:60%;height:600px;border:1px solid black;" id="divshow"></div>
</body>

</html>