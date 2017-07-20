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
            table {
                border-collapse: collapse;
                text-align: center;
            }
            
            table tr td {
                border-bottom: 1px solid #dedede;
            }
            
            table tr {
                height: 33px;
            }
            
            a {
                color: blue;
                text-decoration: none;
                cursor: pointer;
            }
            
            a:hover {
                text-decoration: underline;
            }
            #btnback{
			    background-color: rgba(99, 86, 255, 1);
			    color:white;
			    border:none;
			    height:30px;
			    width:60px;
			    font-size:16px;
		    }
		    #btnback:hover{
		    	background-color: #282ff7;
		    }
        </style>
        <script>
 		$(function(){
 			$("a").click(function(){
                var pd=$(this).attr("name");//判断是哪种角色
                
                if(pd=="a")
 				{
                	var uname = document.getElementById("u").value;
                	//alert(uname);
                	layer.open({
                        title: '删除提示',
                        content: '确认删除?',
                        skin: 'layui-layer-lan',
                        closeBtn: 0,
                        btn: ['确定', '取消'],
                        btn1: function(index) {
                            //传递此行对应的name并传到yhgldel.jsp进行删除
                            window.location.href = "yhgldel.jsp?username=" + uname;
                            layer.close(index);
                        },
                        btn2: function(index) {
                            layer.close(index);
                        },
                    });
 				}
                if(pd=="x")
 				{
                	var xsyhm = document.getElementById("xs").value;
                	layer.open({
                        title: '删除提示',
                        content: '确认删除?',
                        skin: 'layui-layer-lan',
                        closeBtn: 0,
                        btn: ['确定', '取消'],
                        btn1: function(index) {
                            //传递此行对应的name并传到yhgldel.jsp进行删除
                            window.location.href = "yhgldelxs.jsp?username=" + xsyhm;
                            layer.close(index);
                        },
                        btn2: function(index) {
                            layer.close(index);
                        },
                    });
 				}
                if(pd=="b")
 				{
                	var bmyhm = document.getElementById("bm").value;
                	layer.open({
                        title: '删除提示',
                        content: '确认删除?',
                        skin: 'layui-layer-lan',
                        closeBtn: 0,
                        btn: ['确定', '取消'],
                        btn1: function(index) {
                            //传递此行对应的name并传到yhgldel.jsp进行删除
                            window.location.href = "yhgldelbm.jsp?username=" + bmyhm;
                            layer.close(index);
                        },
                        btn2: function(index) {
                            layer.close(index);
                        },
                    });
 				}
                
 			});
 		});
 		</script>
        <style>
            .even {
                background: #D9D9D9;
            }
        </style>
        <script type="text/javascript">
            $(function() {
                $("tr:even").addClass("even");
            });
        </script>
    </head>

    <body>
        <a href="javascript:history.go(-1);">
            <button id="btnback">返回</button>
        </a>
        <jsp:useBean id="db" class="bean.DBBean" scope="page" />

        <%
	request.setCharacterEncoding("UTF-8");
	String uname=request.getParameter("txtquery");
	String submit=request.getParameter("submit");
	String exist2=db.userExist(uname);
	String exist3=db.assessorExist(uname);
	String exist4=db.mgtExist(uname);
	//System.out.println(uname+submit);
	if(submit!=null||!submit.equals(""))
	{
		//需求填报员
		if(exist2.equals(uname))
		{
			String sql="select username,Organcode,Organname,Contactaddr from userInfo where username='"+uname+"'";
    		ResultSet rs=db.executeQuery(sql);
        	if(rs.next())
        	{
        		%>
            <p style="font-weight:bold;color:#969696;">--------------需求填报员--------------</p>
            <table width="100%">
                <tr style="font-weight:bold;background-color:#969696;">
                    <td width="" align="center">用户名</td>
                    <td width="" align="center">机构代码</td>
                    <td width="" align="center">机构名称</td>
                    <td width="" align="center">通讯地址</td>
                    <td width="" align="center">操作</td>
                </tr>
                <tr>
                    <td>
                        <%=rs.getString(1)%>
                    </td>
                    <td>
                        <%=rs.getString(2)%>
                    </td>
                    <td>
                        <%=rs.getString(3)%>
                    </td>
                    <td>
                        <%=rs.getString(4)%>
                    </td>
                    <td align="center">
                        <input type="hidden" id="u" name="u" value="<%=rs.getString(1)%>" />
                        <a name="a"> 删除</a>
                    </td>
                </tr>
            </table>
            <%
		}
            	}
		//形式审核员
		else if(exist3.equals(uname))
		{
			String sql="select username from assessorInfo where username='"+uname+"'";
    		ResultSet rs=db.executeQuery(sql);
        	if(rs.next())
        	{
        		%>
                <p style="font-weight:bold;color:#79CDCD;">--------------形式审核员--------------</p>
                <table width="30%">
                    <tr style="font-weight:bold;background-color:#79CDCD;">
                        <td width="" align="center">用户名</td>
                        <td width="" align="center">操作</td>
                    </tr>
                    <tr>
                        <td>
                            <%=rs.getString(1)%>
                        </td>
                        <td align="center">
                            <input type="hidden" id="xs" name="xs" value="<%=rs.getString(1)%>" />
                            <a name="x"> 删除</a>
                        </td>
                    </tr>
                </table>
                <%
        		
        	}
		}
		//部门审核员
				else if(exist4.equals(uname))
				{
					String sql="select username,glbm from mgtInfo where username='"+uname+"'";
		    		ResultSet rs=db.executeQuery(sql);
		        	if(rs.next())
		        	{
		        		%>
                    <p style="font-weight:bold;color:#4876FF;">--------------部门审核员--------------</p>
                    <table width="30%">
                        <tr style="font-weight:bold;background-color:#4876FF;">
                            <td width="" align="center">用户名</td>
                            <td width="" align="center">所属部门</td>
                            <td width="" align="center">操作</td>
                        </tr>
                        <tr>
                            <td>
                                <%=rs.getString(1)%>
                            </td>
                            <td>
                                <%=rs.getString(2)%>
                            </td>
                            <td align="center">
                                <input type="hidden" id="bm" name="bm" value="<%=rs.getString(1)%>" />
                                <a name="b"> 删除</a>
                            </td>
                        </tr>
                    </table>
                    <%
		        		
		        	}
				}
				else
				{
					%>
                        <h1>无此用户</h1>
                        <% 
				}
		}
	%>
    </body>

    </html>