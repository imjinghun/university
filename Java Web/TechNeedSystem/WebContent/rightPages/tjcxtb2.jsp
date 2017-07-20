<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="../js/ichart.1.2.min.js"></script>
    <script type="text/javascript">
    
			$(function(){
				var name=document.getElementById("name").value;
			    var namecount=document.getElementById("namecount").value;
			    var n=name.split("$");
			    var nc=namecount.split("$");
			    
			    var data=[];
			    for(var i=0;i<n.length-1;i++)
			    {
			    	var a={};
			    	a.name=n[i];
			    	a.value=nc[i];
			    	a.color="#6A5ACD";
			    	data.push(a);
			    }
				new iChart.Pie2D({
					render : 'canvasDiv',
					data: data,
					title : '统计图(有空项可能该字段为非必填项)',
					legend : {
						enable : true
					},
					sub_option : {
						label : {
							background_color:null,
							sign:false,//设置禁用label的小图标
							padding:'0 4',
							border:{
								enable:false,
								color:'#666666'
							},
							fontsize:11,
							fontweight:600,
							color : '#4572a7'
						},
						border : {
							width : 2,
							color : '#ffffff'
						}
					},
					animation:true,
					showpercent:true,
					decimalsnum:2,
					width : 800,
					height : 400,
					radius:140
				}).draw();
			});
		</script>
		
</head>
<body>
<jsp:useBean id="db" class="bean.DBBean" scope="page" />
<%
	request.setCharacterEncoding("UTF-8");
	String submit="",qtype="";
	String namecount="";
	String name="";
	submit=request.getParameter("submit");
	//System.out.println(submit+","+qtype+"");
	if(submit!=null)
	{
		qtype=request.getParameter("qtype");
		
		String sql="select "+qtype+",count(*) from needtable where states='11' group by "+qtype+"";
		
		ResultSet rs=db.executeQuery(sql);
		while(rs.next())
		{
			name+=rs.getString(1)+"$";
			namecount+=rs.getString(2)+"$";
		}
	
	}
//	System.out.println(name);
//	System.out.println(namecount);
%>

<input type="hidden" value="<%=name%>" id="name"/>
<input type="hidden" value="<%=namecount%>" id="namecount"/>
<input type="hidden" value="<%=qtype %>" id="qtype"/>
<div id='canvasDiv'></div>
</body>
</html>