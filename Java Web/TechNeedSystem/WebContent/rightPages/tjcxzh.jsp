<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <style type="text/css">
            table tr {
                height: 50px;
                text-align: center;
            }
            
            table tr th {
                text-align: right;
            }
            
            .btn {
                margin-left: 2%;
                margin-top: 1%;
                vertical-align: middle;
                width: 80px;
                height: 28px;
                font-size: 16px;
                border: none;
                color: white;
                background-color: rgba(99, 86, 255, 1);
            }
            
            .btn:hover {
                background-color: #282ff7;
            }
            
            .left {
                float: left;
            }
            
            .leftclear {
                float: left;
                clear: left;
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
        <script type="text/javascript">
            function jqquery() {
                form1.cxfs.value = "jq";
                //alert(form1.cxfs.value);
            }

            function mhquery() {
                form1.cxfs.value = "mh";
                //alert(form1.cxfs.value);
            }
        </script>
    </head>

    <body>
        <jsp:useBean id="db" class="bean.DBBean" scope="page" />
        <div id="up" style="width:100%;border:1px solid #a39e9e;overflow:auto;">
        	<font style="position:relative;font-style:italic;font-size:25px;font-family:华文行楷;color:red;top:20px;left:20px;">综合检索</font>
            <form action="tjcxzh2.jsp" method="post" name="form1">
                <div style="width:60%;float:left;margin-top:15px;">
                    <table width="100%">
                        <tr>
                            <th width="25%">需求名称:</th>
                            <td width="50%"><input name='xqmc' id="xc" style="width:100%;height:20px;font-size:16px;" />
                            </td>
                        </tr>
                        <tr>
                            <th>机构名称:</th>
                            <td><input name='jgmc' id="jm" style="width:100%;height:20px;font-size:16px;" />
                            </td>
                        </tr>
                        <tr>
                            <th>资金总额:</th>
                            <td><input name='zjze' id="zj" style="width:100%;height:20px;font-size:16px;" /></td>
                            <td align="left">&nbsp;万元</td>
                        </tr>
                        <tr>
                            <th>关键字:</th>
                            <td><input name='gjz' id="gjz" style="width:100%;height:20px;font-size:16px;" /></td>
                        </tr>
                        <tr>
                            <th>法人代表:</th>
                            <td><input name='frdb' id="fr" style="width:100%;height:20px;font-size:16px;" /></td>
                        </tr>
                        <tr>
                            <th>联系人:</th>
                            <td><input name='lxr' id="lx" style="width:100%;height:20px;font-size:16px;" /></td>
                        </tr>
                        <tr>
                            <th>学科分类:</th>
                            <td><input name='xkfl' id="xf" style="width:100%;height:20px;font-size:16px;" /></td>
                            <td align="left">&nbsp;(名称/代码)</td>
                        </tr>
                        <tr>
                            <th>需求技术应用行业:</th>
                            <td><input name='jshy' id="jshy" style="width:100%;height:20px;font-size:16px;" /></td>
                            <td align="left">&nbsp;(名称/代码)</td>
                        </tr>
                        <tr>
                            <th>管理处室:</th>
                            <td>
	                            <select name="glbm" id="glbm" style="width:100%;height:25px;font-size:14px;">
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
                            </td>
                        </tr>
                    </table>
                </div>
                <div style="float:left;width:40%;margin-top:15px;">
                    <table>
                        <tr>
                            <th>归口管理单位:</th>
                            <td>
                                <select name="gkbm" id="gk" style="height:25px;width:100%;font-size:14px;">
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
                            <th>所在地域:</th>
                            <td><select name="szdy" id="dy" style="height:25px;width:100%;font-size:14px;">
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
                        </tr>
                        <tr>
                            <th>机构属性:</th>
                            <td>
                                <select name="jgsx" id="jgsx" style="height:25px;width:100%;font-size:14px;">
	                        	<option value="select"></option>
	                        	<option value="企业">企业</option>
	                        	<option value="高等院校">高等院校</option>
	                        	<option value="研究机构">研究机构</option>
	                        	<option value="其他">其他</option>
						</select>
                            </td>
                        </tr>
                        <tr>
                            <th>技术需求解决方式:</th>
                            <td>
                                <select name="jjfs" id="jjfs" style="height:25px;width:100%;font-size:14px;">
	                        	<option value="select"></option>
	                        	<option value="独立研发">独立研发</option>
	                        	<option value="委托研发">委托研发</option>
	                        	<option value="合作研发">合作研发</option>
	                        	<option value="其他">其他</option>
						</select>
                            </td>
                        </tr>
                        <tr>
                            <th>需求技术所属领域:</th>
                            <td><select name="jsly" id="jsly" style="height:25px;width:100%;font-size:14px;">
	                        	<option value="select"></option>
	                        	<option value="电子信息">电子信息</option>
	                        	<option value="光机电一体化">光机电一体化</option>
	                        	<option value="生物技术与制药">生物技术与制药</option>
	                        	<option value="新材料及应用">新材料及应用</option>
	                        	<option value="现代农业">现代农业</option>
	                        	<option value="新能源与高效节能">新能源与高效节能</option>
	                        	<option value="资源与环境">资源与环境</option>
	                        	<option value="高技术服务业">高技术服务业</option>
	                        	<option value="海洋">海洋</option>
	                        	<option value="社会公共事业">社会公共事业</option>
	                        	<option value="医疗卫生">医疗卫生</option>
	                        	<option value="其他">其他</option>
							</select></td>
                        </tr>
                        <tr>
                            <th>科技活动类型:</th>
                            <td>
                                <select name="hdlx" id="hdlx" style="height:25px;width:100%;font-size:14px;">
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
                            <th>形式审核是否通过:</th>
                            <td align="left">
                                <label for="yes">是</label>
				            	<input type="checkbox" id="yes" value="1" name="xssftg" />
				            	<label for="no">否</label>
				            	<input type="checkbox" id="no" value="0" name="xssftg" />
                            </td>
                        </tr>
                        <tr>
                            <th>部门审核是否通过:</th>
                            <td align="left">
                                <label for="yesb">是</label>
				            	<input type="checkbox" id="yesb" value="11" name="bmsftg" />
				            	<label for="nob">否</label>
				            	<input type="checkbox" id="nob" value="10" name="bmsftg" />
                            </td>
                        </tr>
                        <tr>
	                        <td colspan="3" align="center">
	                        	<input type="submit" value="精确查询" class="btn" name="submit" />
	            				<input type="submit" value="模糊查询" class="btn" name="submit" />
	            				<input type="reset" value="重置" class="btn"/>
	                        </td>
	                    </tr>
                    </table>
                </div>
            </form>
        </div>

        <!--  div style="width:100%;overflow:auto;">
            <p>
                <strong>检索提示:</strong>
                <strong>学科分类、需求技术应用行业</strong>需要输入对应的<strong>代码或名称</strong>进行查询。
            </p>
        </div>-->
    </body>

    </html>