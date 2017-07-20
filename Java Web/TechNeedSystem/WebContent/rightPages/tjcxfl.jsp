<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
                background-color: rgba(99, 86, 255, 1);
            }
            .btn:hover {
                background-color: #282ff7;
            }
            .common{
            float:left;
            margin:10px 5px;
            }
        </style>
         <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript">
        var xs=document.getElementsByName("xssftg");
        var bm=document.getElementsByName("bmsftg");
        $(function(){
        	$("#yes").click(function(){
        		if(xs[1].checked==true)
        		{
        			xs[1].checked=false;
        		}
        	});
        	$("#no").click(function(){
        		if(xs[0].checked==true)
        		{
        			xs[0].checked=false;
        		}
        		bm[0].checked=false;
    			bm[1].checked=false;
        	});
        	$("#yesb").click(function(){
        		if(xs[1].checked==true)
        		{
        			bm[0].checked=false;
        			bm[1].checked=false;
        		}
        		if(bm[1].checked==true)
        		{
        			bm[1].checked=false;
        		}
        	});
        	$("#nob").click(function(){
        		if(xs[1].checked==true)
        		{
        			bm[0].checked=false;
        			bm[1].checked=false;
        		}
        		if(bm[0].checked==true)
        		{
        			bm[0].checked=false;
        		}
        	});
        });
        </script>
</head>

<body>
    <div style="border:1px solid #a39e9e;overflow:auto;margin-top:5px;">
    <div>
    	<font style="position:relative;font-style:italic;font-size:25px;font-family:华文行楷;color:red;top:5px;left:10px;clear:right;">分类检索</font>
    </div>
    <div>
	     <form name="form1" action="" method="post">
            <strong class="common" style="margin-left:20px;">选择检索类别:</strong>
	        <select id="qtype" name="qtype" style="font-size:14px;height:22px;" class="common">
		        <option value="select" >请选择</option>
		        <option value="Organname">机构全称</option>
		        <option value="Legalperson">法人代表</option>
		        <option value="Contacts">联系人</option>
		        <option value="needname">技术需求名称</option>
		        <option value="needkey">关键字</option>
		        <option value="totalmoney">拟投入资金总额</option>
		        <option value="needmodel">技术需求解决方式</option>
		        <option value="parentmgt">归口管理单位</option>
		        <option value="LocationArea">所在地域</option>
		        <option value="organattr">机构属性</option>
		        <option value="restype">科技活动类型</option>
		        <option value="subtype">学科分类</option>
		        <option value="needfield">需求技术所属领域</option>
		        <option value="needindustry">需求技术应用行业</option>
		        <option value="glbm">管理处室</option>
			</select>
			<input id="txt" name="txt" style="font-size:14px;" class="common"/>
			<input type="submit" value="精确查询" class="btn common" name="submit" />
            <input type="submit" value="模糊查询" class="btn common" name="submit" />
            <span class="common">管理处室、学科分类和技术应用行业请输入<strong>代码或名称</strong>进行查询</span>
            
            <div class="common" style="width:98%;margin-left:20px;">
            	<strong>形式审核是否通过:</strong>
            	<label for="yes">是</label>
            	<input type="checkbox" id="yes" value="1" name="xssftg" />
            	<label for="no">否</label>
            	<input type="checkbox" id="no" value="0" name="xssftg" />
            	<span style="display:inline-block;width:50px;"></span>
            	<strong>部门审核是否通过:</strong>
            	<label for="yesb">是</label>
            	<input type="checkbox" id="yesb" value="11" name="bmsftg"/>
            	<label for="nob">否</label>
            	<input type="checkbox" id="nob" value="10" name="bmsftg"/>
            </div>
		</form>
		</div>
    </div>
    
    <div style="margin-top:20px;">
    <jsp:include page="tjcxfl2.jsp" flush="true"></jsp:include>
    </div>
    
</body>

</html>