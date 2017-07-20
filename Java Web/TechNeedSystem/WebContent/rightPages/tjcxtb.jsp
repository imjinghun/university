<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
     <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
        <!-- 引入layer组件弹窗 -->
        <script src="../layer/layer.js"></script>
    <style type="text/css">
			.btn {
                margin-left: 2%;
                margin-top: 1%;
                vertical-align: middle;
                width: 80px;
                height: 24px;
                font-size: 16px;
                border: none;
                color: white;
                background-color: #1874CD;
            }
            .btn:hover {
                background-color: #0000EE;
            }
            .common{
            float:left;
            margin:10px 5px;
            }
        </style>
        <script>
        function check()
        {
        	var qtype=document.getElementById("qtype");
        	if(qtype.value=="select")
        	{
        		qtype.focus();
        		layer.msg('请选择统计类型',{time:1200});
        		return false;
        	}
        	/*
        	if(form1.txt.value=="")
        	{
        		form1.txt.focus();
        		layer.msg('请输入相应内容',{time:1200});
        		return false;
        	}*/
        	return true;
        }
        </script>
</head>
<body>
	<div style="border:1px solid #a39e9e;overflow:auto;margin-top:5px;">
    <div>
    	<font style="position:relative;font-style:italic;font-size:25px;font-family:华文行楷;color:red;top:5px;left:10px;clear:right;">统计图表</font>
    </div>
    <div>
	     <form name="form1" action="tjcxtb.jsp" method="post" onsubmit="return check()">
	     	<strong class="common" style="margin-left:20px;">选择统计字段:</strong>
	        <select id="qtype" name="qtype" style="font-size:14px;height:22px;" class="common">
		        <option value="select" >请选择</option>
		        <option value="organattr">机构属性</option>
		        <option value="restype">科技活动类型</option>
		        <option value="needmodel">技术需求解决方式</option>
		        
		        <option value="parentmgt">归口管理部门</option>
		        <option value="LocationArea">所在地域</option>
		        <option value="subtype">学科分类</option>
		        <option value="needindustry">需求技术应用行业</option>
		        <option value="glbm">管理处室</option>
			</select>
			
			<!-- input id="txt" name="txt" style="font-size:14px;" class="common"/> -->
			
			<strong class="common" style="margin-left:20px;">选择图表类型:</strong>
			<select id="qtype" name="qtype" style="font-size:14px;height:22px;" class="common">
		        <option value="bzt" >饼状图</option>
		        <!--option value="zzt">柱状图</option>
		        <option value="zxt">折线图</option> -->
			</select>
			
			<input type="submit" value="生成图表" class="btn common" name="submit" />
			
		</form>
		</div>
    </div>
    <div style="margin-top:5px;">
		<jsp:include page="tjcxtb2.jsp" flush="true"></jsp:include>
	</div>
</body>
</html>