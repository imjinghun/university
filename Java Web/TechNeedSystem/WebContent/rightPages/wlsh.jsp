<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <style type="text/css">
            table tr {
                height: 35px;
            }
            .btn{
            margin-left:2%;
            margin-top:1%;
            vertical-align:middle;
            width:80px;
            height:30px;
            font-size:16px;
            border:none;
            color:white;
            background-color:rgba(99, 86, 255, 1);
            }
            .btn:hover{
            background-color:#282ff7;
            }
        </style>
        <script type="text/javascript">
        function jqquery()
        {
        	form1.cxfs.value="jq";
        	//alert(form1.cxfs.value);
        }
        function mhquery()
        {
        	form1.cxfs.value="mh";
        	//alert(form1.cxfs.value);
        }
        </script>
    </head>

    <body>
        <jsp:useBean id="db" class="bean.DBBean" scope="page" />
        <div id="up" style="width:100%;border:1px solid #a39e9e;overflow:auto;">
            <form action="" method="post" name="form1">
                <table  align="center" style="width:99%;margin:5px;" style="background-color:none;">
                    <tr>
                        <td width="">需求名称</td>
                        <td width="">
                            <input name='xqmc' id="xc" style="width:98.2%;height:100%;font-size:16px;"/>
                        </td>
                        <td width="">机构名称</td>
                        <td width=""><input name='jgmc' id="jm" style="width:98.2%;height:100%;font-size:16px;" />
                        </td>
                        <td>归口管理单位</td>
                        <td>
                            <select name="gkbm" id="gk" style="height:100%;width:100%;font-size:16px;">
                        		<option value="select"></option>
								<%
									request.setCharacterEncoding("UTF-8");
	                        		String sql="select * from guikou$";
	                        		ResultSet rs = db.executeQuery(sql);
	                    			while(rs.next())
	                    			{
	                    				%>
	                    				<option value="<%=rs.getString(1)+rs.getString(2)%>"><%=rs.getString(2) %></option>
	                    				<%
	                    			}
	                        	%>
							</select>
                        </td>
                    </tr>
                    <tr>
                        <td>所在地域</td>
                        <td>
                            <select name="szdy" id="dy" style="height:100%;width:100%;font-size:16px;">
	                        	<option value="select"></option>
	                        	<option value="130100 石家庄市">石家庄市</option>
	                        	<option value="130200 唐山市">唐山市</option>
	                        	<option value="130300 秦皇岛市">秦皇岛市</option>
	                        	<option value="130400 邯郸市">邯郸市</option>
	                        	<option value="130500 邢台市">邢台市</option>
	                        	<option value="130600 保定市">保定市</option>
	                        	<option value="130700 张家口市">张家口市</option>
	                        	<option value="130800 承德市">承德市</option>
	                        	<option value="130900 沧州市">沧州市</option>
	                        	<option value="131000 廊坊市">廊坊市</option>
	                        	<option value="131100 衡水市">衡水市</option>
	                        	<option value="130682 定州市（直管县）">定州市（直管县）</option>
	                        	<option value="130181 辛集市（直管县）">辛集市（直管县）</option>
	                        	<option value="120000 其他（河北工大）">其他（河北工大）</option>
							</select>
                        </td>
                       
                        <td >机构属性</td>
                        <td>
                            <select name="jgsx" id="jgsx" style="height:100%;width:100%;font-size:16px;">
	                        	<option value="select"></option>
	                        	<option value="企业">企业</option>
	                        	<option value="高等院校">高等院校</option>
	                        	<option value="研究机构">研究机构</option>
	                        	<option value="其他">其他</option>
						</select>
                        </td>
                        <td >科技活动类型</td>
                        <td>
                           <select name="hdlx" id="hdlx" style="height:100%;width:100%;font-size:16px;">
	                        	<option value="select"></option>
	                        	<option value="基础研究">基础研究</option>
	                        	<option value="应用研究">应用研究</option>
	                        	<option value="试验发展">试验发展</option>
	                        	<option value="研究与试验发展成果应用">研究与试验发展成果应用</option>
	                        	<option value="技术推广与科技服务">技术推广与科技服务</option>
	                        	<option value="生产性活动">生产性活动</option>
							</select>
                        </td>
                    </tr>
                    <tr>
                    	<td colspan="6">
                    	<input type="hidden" name="cxfs"/>
                <input type="submit" value="精确查询" class="btn" onclick="jqquery()" name="submit"/>
                <input type="submit" value="模糊查询" class="btn" onclick="mhquery()" name="submit"/>
                <input type="reset" value="重置" class="btn"/>
                <input type="submit" value="已审核" class="btn" name="submit"/>
                <input type="submit" value="未审核" class="btn" name="submit"/>
                    	</td>
                    </tr>
                </table>
                
            </form>
        </div>
        
        <div style="width:100%;margin-top:20px;"> 
        <jsp:include page="wlshquery.jsp" flush="true"></jsp:include>
        </div>
    </body>

    </html>