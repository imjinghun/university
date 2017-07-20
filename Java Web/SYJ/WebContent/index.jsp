<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>EMP增删改查</title>
	<style type="text/css">
		.btn {
	         background-color: #282ff7;
	         color: white;
	         height: 30px;
	         font-size: 16px;
	         width: 90px;
	         border: 2px;
	         margin-left: 25%;
	         float:left;
	    }  
	    .btn:hover {
	         background-color: #0000CD;
	    }
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
	    table tr {
                height: 33px;
            }
            a {
                color: blue;
                cursor: pointer;
            }
            
            a:hover {
                color: rgb(26, 152, 190);
            }
	</style>
</head>
<body bgcolor="#e2f7f5">
	<jsp:useBean id="db" class="bean.ConnDB"></jsp:useBean>
		<div style="text-align:center;">
			<a href="addEmp.jsp"><button class="btn">添加员工</button></a>
				<form action="" method="post" name="form1">
                    <strong>员工号:</strong>
                    <input type="text" name="txtquery" id="txtquery" style="height:25px;font-size:16px;" />
                    <input type="submit" style="width:50px;" class="btn1" name="submit" value="查询" />
                </form>
		</div>
		<div>
		<jsp:include page="queryEmp.jsp" flush="true"></jsp:include>
		</div>
</body>
</html>