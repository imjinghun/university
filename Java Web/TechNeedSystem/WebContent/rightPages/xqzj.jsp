<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="SHORTCUT ICON" href="images/xt.ico" />
    <!--  title>河北省重大技术需求征集系统</title -->
    <link rel="stylesheet" href="../css/mycss/index.css" />
    <script src="../js/jquery-1.4.js"></script>
    <script src="../js/myjs/index.js"></script>
    <script src="../js/myjs/indexSel.js"></script>
    <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
        <!-- 引入layer组件弹窗 -->
        <script src="../layer/layer.js"></script>
    <script>
    function btnsave(){
    	form1.states.value="3";
    	/*	alert(form1.states.value);
    	document.form1.action="index2.jsp";
    	document.form1.submit();*/
    }
    function btnsubmit(){
    	form1.states.value="2";
    	if(!check())
    	{
    		return false;
    	}
    	return confirm('提交审核后信息不能修改！ 确定提交吗');
    	/*	alert(form1.states.value);
    document.form1.action="index2.jsp";
    	document.form1.submit();*/
    }
    </script>
</head>

<body>
    <div style="text-align: center;">

    <jsp:useBean id="db" class="bean.DBBean" scope="page" />
    <%
	request.setCharacterEncoding("UTF-8");
	String username=(String)session.getAttribute("username");
	String jgmc="",gkbm="",txdz="",frdb="",yzbm="",dwwz="",dzxx="",lxr="",gh="",sj="",cz="";
	if(!username.equals("")||!username.equals(null))
	{
		String sql="select * from userinfo where username='"+username+"'";
		ResultSet rs = db.executeQuery(sql);
		if(rs.next())
		{
			jgmc=rs.getString(4);
			gkbm=rs.getString(5);
			txdz=rs.getString(6);
			dwwz=rs.getString(7);
			dzxx=rs.getString(8);
			frdb=rs.getString(9);
			yzbm=rs.getString(10);
			lxr=rs.getString(11);
			gh=rs.getString(12);
			sj=rs.getString(13);
			cz=rs.getString(14);
		}
	}
	%>
		 <hr style="border:none;border-top:1px solid #a39e9e;" />
            <span style="font-size: 25px;font-weight:bold;">河北省重大技术需求征集表<font class="tip">注意：(带<font color="red"> * </font>为必填项)</font></span>
         <hr style="border:none;border-top:1px solid #a39e9e;" />
            
         <form id="form1" name="form1" method="post" action="xqzj2.jsp" onsubmit="return check()">
            <table frame="border" rules="all" >
                <tr>
                    <td scope="row" width="12%"><font color="red">*</font>机构全称</td>
                    <td width="28%">
                    	<input type="text" name="jgmc" value="<%=jgmc%>" class="input1" maxlength="100" />
                    </td>
                    <td colspan="3" align="left">
                    	<font class="tip">填写完整名称,例:石家庄铁道大学</font>
                    </td>
                    <td width="12%">归口管理部门</td>
                    <td width="18%">
                        <select name="gkbm" id="gk" style="height:100%;width:100%;font-size:16px;">
                        <option value="select"></option>
							<%
                        		String sql="select * from guikou$";
                        		ResultSet rs = db.executeQuery(sql);
                    			while(rs.next())
                    			{
                    				if((rs.getString(1)+rs.getString(2)).equals(gkbm))
                    				{
                    					%>
                    					<option value="<%=rs.getString(1)+rs.getString(2)%>" selected="selected"><%=rs.getString(2) %></option>
                    					<%
                    					continue;
                    				}
                    				%>
                    				<option value="<%=rs.getString(1)+rs.getString(2)%>"><%=rs.getString(2) %></option>
                    				<%
                    			}
                        	%>
						</select>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>通讯地址</td>
                    <td>
                        <input type="text" name="txdz" id="txdz" value="<%=txdz%>" class="input1" maxlength="100" />
                    </td>
                    <td colspan="3" align="left">
                    	<font class="tip">省市县(区)等到号,例:河北省石家庄市桥东区北二环东路17号</font>
                    </td>
                    <td ><font color="red">*</font>所在地域</td>
                    <td>
                    	<select name="szdy" id="dy" style="height:100%;width:100%;font-size:16px;">
                        	<option value="select">请选择</option>
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
                    <td scope="row">网&nbsp;址</td>
                    <td>
                        <input type="text" name="dwwz" id="dwwz" value="<%=dwwz%>" class="input1" maxlength="255" />
                    </td>
                    <td colspan="2"><font color="red" >*</font>电子信箱</td>
                    <td>
                        <input type="text" name="dzxx" id="dzxx" value="<%=dzxx%>" class="input1" maxlength="50" onblur="emailcheck()"/>
                    </td>
                    <td colspan="2" align="left">
                        <font class="tip">格式如：123456789@qq.com</font>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>法人代表</td>
                    <td>
                        <input type="text" name="frdb" id="frdb" value="<%=frdb%>" class="input1" maxlength="20" />
                    </td>
                    <td colspan="2" width="8%">邮政编码</td>
                    <td >
                        <input type="text" name="yzbm" id="yzbm" value="<%=yzbm%>" class="input1" maxlength="6" onblur="ybcheck()"/>
                    </td>
                    <td colspan="2" align="left">
                        <font class="tip">格式如：050043</font>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>联系人</td>
                    <td >
                        <input type="text" name="lxr" id="lxr" value="<%=lxr%>" class="input1"  maxlength="20" />
                    </td>
                    <td colspan="2">固定电话</td>	
                    <td >
                        <input type="text" name="gd" id="gd" value="<%=gh%>" class="input1" maxlength="12" onblur="ghcheck()"/>
                    </td>
                   <td colspan="2" align="left"> 
                   <font class="tip">格式如：031187936524</font>
                   </td>
                    
                    
                </tr>
                <tr>
                	<td ><font color="red">*</font>手机</td>
                    <td >
                        <input type="text" name="sj" id="sj" value="<%=sj%>" class="input1" maxlength="11" onblur="sjcheck()"/>
                    </td>
                    <td colspan="2">传真</td>
                    <td >
                        <input type="text" name="cz" id="cz" value="<%=cz%>" class="input1" maxlength="12" />
                    </td>
                    <td colspan="3" align="left">
                        <font class="tip">格式同固定电话</font>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>机构属性</td>
                    <td colspan="6" align="left">
                        <input type="radio" name="jgsx" id="qy" value="企业" />
                        <label for="qy">企业</label>
                        <input type="radio" name="jgsx" id="gdyx" value="高等院校" />
                        <label for="gdyx">高等院校</label>
                        <input type="radio" name="jgsx" id="yjjg" value="研究机构" />
                        <label for="yjjg">研究机构</label>
                        <input type="radio" name="jgsx" id="qtjg" value="其他" />
                        <label for="qtjg">其他</label>
                    </td>
                </tr>
                <tr>
                 <td scope="row">
                    <font color="red">*</font>机构简介
                    <td colspan="6" align="left">
                    	<p class="tip1">（主要包括基本情况、现有研究基础等，限500字以内）</p>
                    	<textarea name="jgjj" id="jgjj" cols="45" rows="5" class="textarea1" maxlength="500"></textarea>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>技术需求名称</td>
                    <td>
                        <input type="text" name="xqmc" id="xqmc" class="input1" maxlength="100" style="height:100%;"/>
                    </td>
                    <td colspan="2"><font color="red">*</font>需求时限</td>
                    <td  align="left">
                        <input type="text" name="syear" style="width:80px;height:100%" maxlength="4" onblur="xqsx()"/> 年至
                        <input type="text" name="eyear" style="width:80px;height:100%" maxlength="4" onblur="xqsx2()"/> 年
                    </td>
                    <td colspan="2" align="left">
                    	<font class="tip">例:2016年填写2016 截止年限大于开始年限，开始年至少为当年</font>
                    </td>
                </tr>
                <tr>
                    <td scope="row" style="height:100px;"><font color="red">*</font>技术需求概述</td>
                    <td height="63" colspan="6" align="left">
                    	<p class="tip1">1、主要问题（需要解决的重大技术问题，限500字以内）</p>
                        <textarea name="xqgs1" id="xqgs1" cols="45" rows="5" class="textarea1" maxlength="500"></textarea>
                        <p class="tip1">2、技术关键（所需的关键技术、主要指标，限500字以内）</p>
                        <textarea name="xqgs2" id="xqgs2" cols="45" rows="5" class="textarea1" maxlength="500"></textarea>
                        <p class="tip1">3、预期目标（技术创新性、经济社会效益，限500字以内）</p>
                        <textarea name="xqgs3" id="xqgs3" cols="45" rows="5" class="textarea1" maxlength="500"></textarea>
                    </td>

                </tr>
                <tr>
                    <td>
                        <font color="red">*</font>关键字<font style="font-size:14px;color:red;">（1-5个）</font>
                        <input type="hidden" name="gjz" id="gjz"/>
                    </td>
                    <td colspan="6" align="left">
                        <input type="text" name="gjz1" id="gjz1" class="input2" maxlength="20" onclick="readWrite()" onblur="gjzcheck()"/>
                        <input type="text" name="gjz1" id="gjz2" class="input2" maxlength="20" onclick="readWrite()" onblur="gjzcheck()"/>
                        <input type="text" name="gjz1" id="gjz3" class="input2" maxlength="20" onclick="readWrite()" onblur="gjzcheck()"/>
                        <input type="text" name="gjz1" id="gjz4" class="input2" maxlength="20" onclick="readWrite()" onblur="gjzcheck()"/>
                        <input type="text" name="gjz1" id="gjz5" class="input2" maxlength="20" onclick="readWrite()" onblur="gjzcheck()"/> 
                        <font class="tip">按照顺序填写,每个关键字长度不超过20</font>
                    </td>

                </tr>
                <tr>
                    <td scope="row">资金需求总额</td>
                    <td>
                        <input type="text" name="zjze" id="zjze" class="input1" onblur="zjzecheck()" />
                    </td>
                    <td colspan="5" align="left">&nbsp;万元</td>
                </tr>
                <tr>
                    <td rowspan="2" scope="row"><font color="red">*</font>技术需求解决方式<!--input type="hidden" name="jjfs" id="jjfs" /--></td>
                    <td colspan="6" align="left">
                        <input type="radio" name="jjfs" id="dlyf" value="独立研发" onclick="selLimit2()" />
                        <label for="dlyf">独立研发</label>
                        <input type="radio" name="jjfs" id="wtyf" value="委托研发" onclick="selLimit2()"/>
                        <label for="wtyf">委托研发</label>
                        <input type="radio" name="jjfs" id="hzyf" value="合作研发" onclick="selLimit2()" />
                        <label for="hzyf">合作研发 </label>
                        <input type="radio" name="jjfs" id="qtfs" value="其他" onclick="selLimit2()"/>
                        <label for="qtfs">其他</label>	
                    </td>
                </tr>
                <tr>
                    <td>合作意向单位
                    	<font style="font-size:14px;color:red;">(非必填)</font>
                    </td>
                    <td colspan="6" align="left">
                        <input type="text" name="hzyxdw" id="hzyxdw" class="input1" style="height:28px;" maxlength="100" />
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>科技活动类型</td>
                    <td colspan="6" align="left">
                        <input type="radio" name="hdlx" id="jc" value="基础研究" onclick="selLimit()" />
                        <label for="jc">基础研究</label>
                        <input type="radio" name="hdlx" id="yy" value="应用研究" onclick="selLimit()" />
                        <label for="yy">应用研究</label>
                        <input type="radio" name="hdlx" id="sy" value="试验发展" onclick="selLimit()" />
                        <label for="sy">试验发展</label>
                        <input type="radio" name="hdlx" id="fzyy" value="研究与试验发展成果应用" onclick="selLimit()" />
                        <label for="fzyy">研究与试验发展成果应用</label>
                        <input type="radio" name="hdlx" id="tgfw" value="技术推广与科技服务" onclick="selLimit()" />
                        <label for="tgfw">技术推广与科技服务</label>
                        <input type="radio" name="hdlx" id="schd" value="生产性活动" onclick="selLimit()" />
                        <label for="schd">生产性活动</label>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>学科分类<br/><br/>
                        <font style="font-size:14px;color:#000aff;">（限基础研究填写） </font>
                        <input type="hidden" name="xkfl" id="xkfl"/>
                    </td>
                    <td colspan="6" align="left">
                        <p id="xf">
							
							<font class="font2">&nbsp;一级学科 </font>
                            <select name="yiji" id="yiji" onchange="getErji()" style="height:25px;font-size:14px;width:235px"></select>
							
							<font class="font2">二级学科 </font>
                            <select name="erji" id="erji" onchange="getSanji()" style="height:25px;font-size:14px;width:235px"></select>
                            
							<font class="font2">三级学科 </font>
                            <select name="sanji" id="sanji" onchange="setXkDm()" style="height:25px;font-size:14px;width:235px"></select> 
                            
                            <br/><br/>
                            <span style="font-weight:bold;margin-left:10px;">学科代码<label id="xkdm"></label></span> 
                           
                        </p>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>需求技术所属领域<br/><br/>
                        <font style="font-size:14px;color:red;">（非基础研究填写）</font>
                        <input type="hidden" name="xqly" id="xqly" /></td>
                    <td colspan="6" align="left">
                        <p id="ly">
                            <input type="checkbox" name="xqly1" id="dzjs" value="电子信息" />
                            <label for="dzjs">电子信息</label>
                            <input type="checkbox" name="xqly1" id="gjd" value="光机电一体化" />
                            <label for="gjd">光机电一体化</label>
                            <input type="checkbox" name="xqly1" id="swzy" value="生物技术与制药" />
                            <label for="swzy">生物技术与制药</label>
                            <input type="checkbox" name="xqly1" id="xcl" value="新材料及应用" />
                            <label for="xcl">新材料及应用</label>
                            <input type="checkbox" name="xqly1" id="xdny" value="现代农业" />
                            <label for="xdny">现代农业</label>
                            <input type="checkbox" name="xqly1" id="xny" value="新能源与高效节能" />
                            <label for="xny">新能源与高效节能</label>
                            <br/><br/>
                            <input type="checkbox" name="xqly1" id="zyhj" value="资源与环境" />
                            <label for="zyhj">资源与环境</label>
                            <input type="checkbox" name="xqly1" id="gjsfwy" value="高技术服务业" />
                            <label for="gjsfwy">高技术服务业</label>
                            <input type="checkbox" name="xqly1" id="haiyanng" value="海洋" />
                            <label for="haiyanng">海洋</label>
                            <input type="checkbox" name="xqly1" id="shggsy" value="社会公共事业" />
                            <label for="shggsy">社会公共事业</label>
                            <input type="checkbox" name="xqly1" id="ylws" value="医疗卫生" />
                            <label for="ylws">医疗卫生</label>	
                            <input type="checkbox" name="xqly1" id="qtjs" value="其他（注明）" onclick="selLimit4()" />
                            <label for="qtjs">其他（注明）</label>
                            <br/><br/>
                            <input type="text" name="zm" id="zm" class="input1" style="height:25px;" maxlength="100" />
                        </p>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>需求技术应用行业<br/><br/>
                        <font style="font-size:14px;color:red;">（非基础研究填写）</font>
                        <input type="hidden" name="jsyyhy" id="jsyyhy"/>
                    </td>
                    <td colspan="6" align="left">
                        <p id="hy">
                            <font class="font2">&nbsp;门类 </font>
							<select name="menlei" id="menlei" style="height:25px;font-size:14px;width:250px" onchange="getDalei()"></select>
                        
                        	<font class="font2">&nbsp;大类 </font>
                            <select name="dalei" id="dalei" style="height:25px;font-size:14px;width:250px" onchange="getZhonglei()"></select>
                            
							<font class="font2">中类 </font>
							<select name="zhonglei" id="zhonglei" style="height:25px;font-size:14px;width:250px" onchange="setHyDm()"></select>
							
							<br/><br/>
							<span style="font-weight:bold;margin-left:10px;">行业代码<label id="hydm"></label></span> 
							
                        </p>
                    </td>
                </tr>
                
            </table>
            <p>
            	<input type="hidden" id="states" name="states" />
                <input type="submit" name="save" id="save" value="保存" class="button1" onclick="btnsave()"/>
                <span style="display:inline-block;width:20px;"></span>
                <input type="submit" name="submit" id="submit" value="保存并提交" class="button1" style="color:red;width:100px" onclick="return btnsubmit()"/>
          </p>
        </form>
    </div>
</body>

</html>