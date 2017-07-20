<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
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
        </style>
        <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
        <!-- 引入layer组件弹窗 -->
        <script src="../layer/layer.js"></script>
 		<script>
 		$(function(){
 			var uname = document.getElementsByName("u");
 			var xsyhm = document.getElementsByName("xs");
 			var bmyhm = document.getElementsByName("bm");
 			
 			$("a").click(function(){
                //得到当前点击的a的name并截取 确定为第几行 
                var i = $(this).attr("name").substring(1, 2); //表示第i行
                var pd=$(this).attr("name").substring(0, 1);//判断是哪种角色
                //alert($(this).attr("name"));
                if(pd=="a")
 				{
                	layer.open({
                        title: '删除提示',
                        content: '确认删除?',
                        skin: 'layui-layer-lan',
                        closeBtn: 0,
                        btn: ['确定', '取消'],
                        btn1: function(index) {
                            //传递此行对应的name并传到yhgldel.jsp进行删除
                            window.location.href = "yhgldel.jsp?username=" + uname[i].value;
                            layer.close(index);
                        },
                        btn2: function(index) {
                            layer.close(index);
                        },
                    });
 				}
                if(pd=="x")
 				{
                	layer.open({
                        title: '删除提示',
                        content: '确认删除?',
                        skin: 'layui-layer-lan',
                        closeBtn: 0,
                        btn: ['确定', '取消'],
                        btn1: function(index) {
                            //传递此行对应的name并传到yhgldel.jsp进行删除
                            window.location.href = "yhgldelxs.jsp?username=" + xsyhm[i].value;
                            layer.close(index);
                        },
                        btn2: function(index) {
                            layer.close(index);
                        },
                    });
 				}
                if(pd=="b")
 				{
                	layer.open({
                        title: '删除提示',
                        content: '确认删除?',
                        skin: 'layui-layer-lan',
                        closeBtn: 0,
                        btn: ['确定', '取消'],
                        btn1: function(index) {
                            //传递此行对应的name并传到yhgldel.jsp进行删除
                            window.location.href = "yhgldelbm.jsp?username=" + bmyhm[i].value;
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
        <script>
            function qcheck() {
                if (form1.txtquery.value.trim() == "") {
                    return false;
                }
                return true;
            }
            function xscheck()
            {
            	if(form2.xsyhm.value.trim()=="")
            	{
            		layer.msg("用户名不可为空",{time:1200});
            		form2.xsyhm.focus();
            		return false;
            	}
            	if(form2.xsyhm.value.length<6)
            	{
            		layer.msg("用户名长度不能低于6位",{time:1200});
            		form2.xsyhm.focus();
            		return false;
            	}
            	if(form2.xsmm.value.trim()=="")
            	{
            		layer.msg("密码不可为空",{time:1200});
            		form2.xsmm.focus();
            		return false;
            	}
            	if(form2.xsmm.value.length<6)
            	{
            		layer.msg("密码长度不能低于6位",{time:1200});
            		form2.xsmm.focus();
            		return false;
            	}
            	return true;
            }
            function bmcheck()
            {
            	if(form3.bmyhm.value=="")
            	{
            		layer.msg("用户名不可为空",{time:1200});
            		form3.bmyhm.focus();
            		return false;
            	}
            	if(form3.bmyhm.value.length<6)
            	{
            		layer.msg("用户名长度不能低于6位",{time:1200});
            		form3.bmyhm.focus();
            		return false;
            	}
            	if(form3.bmmm.value.trim()=="")
            	{
            		layer.msg("密码不可为空",{time:1200});
            		form3.bmmm.focus();
            		return false;
            	}
            	if(form3.bmmm.value.length<6)
            	{
            		layer.msg("密码长度不能低于6位",{time:1200});
            		form3.bmmm.focus();
            		return false;
            	}
            	if(form3.glbm.value=="select")
            	{
            		layer.msg("请选择管理处室",{time:1200});
            		form3.glbm.focus();
            		return false;
            	}
            	return true;
            }
        </script>
        <style>
            .even {
                background: #D9D9D9;
            }
        </style>
        <script type="text/javascript">
            $(function() {
                $("tr:even").addClass("even");
			
                //添加形式 部门审核员 div显示
                $("#btnaddxs").click(function(){
                	$("#addxs").show();
                	$("#xsyhm").val("");
                	$("#xsmm").val("");
                }); 
                $("#btnaddbm").click(function(){
                	$("#addbm").show();
                	$("#bmyhm").val("");
                	$("#bmmm").val("");
                	$("#glbm").val("select");
                });
               //添加形式 部门审核员 div隐藏
                $("#xscancel").click(function(){
                	$("#addxs").hide();
                });
                $("#bmcancel").click(function(){
                	$("#addbm").hide();
                });
                //需求填报员 形式 部门审核员显示与隐藏
                $("#btnxqtby").click(function(){
                	$("#xqtby").show();
                	$("#xsshy").hide();
                	$("#bmshy").hide();
                });
                $("#btnxsshy").click(function(){
                	$("#xqtby").hide();
                	$("#xsshy").show();
                	$("#bmshy").hide();
                });
                $("#btnbmshy").click(function(){
                	$("#xqtby").hide();
                	$("#xsshy").hide();
                	$("#bmshy").show();
                });
            });
        </script>
    </head>

    <body>
        <jsp:useBean id="db" class="bean.DBBean" scope="page" />
        <div>
            <div style="float:left;">
                <form action="yhglquery.jsp" name="form1" method="post" onsubmit="return qcheck()">
                    <strong>用户名:</strong>
                    <input type="text" name="txtquery" id="txtquery" style="height:25px;font-size:16px;" />
                    <input type="submit" id="btnquery" class="btn1" name="submit" value="查询" />
                </form>
            </div>
            <div style="float:right;">
            	<button id="btnxqtby" class="btn21">需求填报员</button>
            	<button id="btnxsshy" class="btn21">形式审核员</button>
            	<button id="btnbmshy" class="btn21">部门审核员</button>
                <button id="btnaddxs" class="btn2">添加<font style="color:#EE9A00;">形式</font>审核员</button>
                <button id="btnaddbm" class="btn2">添加<font style="color:#EE9A00;">部门</font>审核员</button>
            </div>
        </div>
        <br/><br/><br/>
        <hr style="height:1px;border:none;border-top:1px solid #a39e9e;clear:both;" />
       
            <div id="xqtby" style="text-align:center;">
                <p style="font-weight:bold;color:#969696;">--------------需求填报员--------------</p>
                <table width="100%">
                    <tr style="font-weight:bold;background-color:#969696;">
                    	<td>序号</td>
                        <td width="" align="center">用户名</td>
                        <td width="" align="center">机构代码</td>
                        <td width="" align="center">机构名称</td>
                        <td width="" align="center">通讯地址</td>
                        <td width="" align="center">操作</td>
                    </tr>
                    <%
        		String sql="select username,Organcode,Organname,Contactaddr from userInfo";
	        	ResultSet rs=db.executeQuery(sql);
	        	int i=0,j=0;
	        	while(rs.next())
	        	{
	        		j++;
	        		%>
                        <tr>
                        	<td><%=j %></td>
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
                                <input type="hidden" id="u<%=i %>" name="u" value="<%=rs.getString(1)%>" />
                                <a name="a<%=i%>"> 删除</a>
                            </td>
                        </tr>
                        <% 
	        		i++;
	        	}
        %>
                </table>
            </div>
            
            <div id="xsshy" style="display:none;">
                <p style="font-weight:bold;color:#79CDCD;">--------------形式审核员--------------</p>
                <table width="30%">
                    <tr style="font-weight:bold;background-color:#79CDCD;">
                    	<td>序号</td>
                        <td width="" align="center">用户名</td>
                        <td width="" align="center">操作</td>
                    </tr>

                    <%
        		sql="select username from assessorInfo";
	        	rs=db.executeQuery(sql);
	        	i=0;j=0;
	        	while(rs.next())
	        	{
	        		j++;
	        		%>
                        <tr>
                        	<td><%=j %></td>
                            <td>
                                <%=rs.getString(1)%>
                            </td>
                            <td align="center">
                                <input type="hidden" id="xs<%=i %>" name="xs" value="<%=rs.getString(1)%>" />
                                <a name="x<%=i%>" onclick=""> 删除</a>
                            </td>
                        </tr>
                        <% 
	        		i++;
	        	}
        %>
                </table>
            </div>
            
            <div id="bmshy" style="display:none;">
                <p style="font-weight:bold;color:#4876FF;">--------------部门审核员--------------</p>
                <table width="50%">
                    <tr style="font-weight:bold;background-color:#4876FF;">
                    	<td>序号</td>
                        <td width="" align="center">用户名</td>
                        <td width="" align="center">所属部门</td>
                        <td width="" align="center">操作</td>
                    </tr>

                    <%
        		sql="select username,glbm from mgtInfo";
	        	rs=db.executeQuery(sql);
	        	i=0;j=0;
	        	while(rs.next())
	        	{
	        		j++;
	        		%>
                        <tr>
                        	<td><%=j %></td>
                            <td>
                                <%=rs.getString(1)%>
                            </td>
                            <td>
                                <%=rs.getString(2)%>
                            </td>
                            <td align="center">
                                <input type="hidden" id="bm<%=i %>" name="bm" value="<%=rs.getString(1)%>" />
                                <a name="b<%=i%>"> 删除</a>
                            </td>
                        </tr>
                        <% 
	        		i++;
	        	}
        %>
                </table>
            </div>
        
        <div id="addxs" style="display:none;position:absolute;top:5px;background-color:#E0FFFF;height:40px;width:100%;">
        	<form action="addxsshy.jsp" name="form2" method="post" style="margin:10px;" onsubmit="return xscheck()">
        		用户名：<input type="text" id="xsyhm" name="xsyhm"/>
        		密码：<input type="password" id="xsmm" name="xsmm"/>
        		<input type="submit" id="xsok" name="xsok" value="确定" class="btn3"/>
        		<input type="button" id="xscancel" name="xscancel" value="取消" class="btn3"/>
        		&nbsp;&nbsp;<font style="font-size:14px;color:gray;">用户名/密码长度6-20位</font>
        	</form>
        </div>
        <div id="addbm" style="display:none;position:absolute;top:5px;background-color:#E0FFFF;height:40px;width:100%;">
        	<form action="addbmshy.jsp" name="form3" method="post" style="margin:10px;" onsubmit="return bmcheck()">
        		用户名：<input type="text" id="bmyhm" name="bmyhm"/>
        		密码：<input type="password" id="bmmm" name="bmmm"/>
        		管理处室：<select name="glbm" id="glbm" >
						        	<option value="select">请选择</option>
						        	<option value="001办公室">001办公室</option>
						        	<option value="002人事处">002人事处</option>
						        	<option value="003机关党委">003机关党委</option>
						        	<option value="004政策法规处">004政策法规处</option>
						        	<option value="005计划财务处">005计划财务处</option>
						        	<option value="006平台与基础处">006平台与基础处</option>
						        	<option value="007国际合作处">007国际合作处</option>
						        	<option value="008高新技术处">008高新技术处</option>
						        	<option value="009农村科技处">009农村科技处</option>
						        	<option value="010社会发展处">010社会发展处</option>
						        	<option value="011成果与市场处">011成果与市场处</option>
						        	<option value="012监察室">012监察室</option>
						        	<option value="013离退休干部处">013离退休干部处</option>
						        	<option value="014知识产权局">014知识产权局</option>
						        	<option value="015半干旱中心">015半干旱中心</option>
						        	<option value="016山办">016山办</option>
						        	<option value="017机关服务中心">017机关服务中心</option>
						        	<option value="020科技研发中心">020科技研发中心</option>
						        	<option value="021科技情报研究院">021科技情报研究院</option>
						        	<option value="022器材公司">022器材公司</option>
						        	<option value="023基金办">023基金办</option>
						        	<option value="024档案馆">024档案馆</option>
						        	<option value="025科技管理信息中心">025科技管理信息中心</option>
						        	<option value="026科技投资中心">026科技投资中心</option>
						        	<option value="027成果转换中心">027成果转换中心</option>
						        	<option value="028中小企业创新资金管理中心">028中小企业创新资金管理中心</option>
						        	<option value="029对外交流中心">029对外交流中心</option>
				        		</select>
        		<input type="submit" id="bmok" name="bmok" value="确定" class="btn3"/>
        		<input type="button" id="bmcancel" name="bmcancel" value="取消" class="btn3"/>
        		&nbsp;&nbsp;<font style="font-size:14px;color:gray;">用户名/密码长度6-20位</font>
        	</form>
        </div>
    </body>

    </html>