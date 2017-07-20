<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="SHORTCUT ICON" href="images/xt.ico" />
    <!--  title>河北省重大技术需求征集系统</title -->
    <link rel="stylesheet" href="./css/mycss/index.css" />
    <script src="./js/jquery-1.4.js"></script>
    <script src="./js/myjs/xqedit.js"></script>
    <script src="./js/myjs/xqSel.js"></script>
    <script type="text/javascript" src="./js/jquery-3.1.1.min.js"></script>
    <!-- 引入layer组件弹窗 -->
    <script src="./layer/layer.js"></script>
    <script>
    function btnsave(){
    	form1.states.value="未提交";
    }
    function btnsubmit(){
    	form1.states.value="未审核";
    	if(!check())
    	{
    		return false;
    	}
    	return confirm('提交审核后信息不能修改！ 确定提交吗');
    }
    </script>
</head>

<body>
    <div style="text-align: center;">

    <jsp:useBean id="db" class="bean.DBBean" scope="page" />
    <%
	request.setCharacterEncoding("UTF-8");
	%>
		 <hr style="border:none;border-top:1px solid #a39e9e;" />
            <span style="font-size: 25px;font-weight:bold;">河北省重大技术需求征集表<font class="tip">注意：(带<font color="red"> * </font>为必填项)</font></span>
         <hr style="border:none;border-top:1px solid #a39e9e;" />
            
         <form id="form1" name="form1" method="post" action="need_update" onsubmit="return check()">
         <input type="hidden" name="id" value="${nt.id}"/>
            <table frame="border" rules="all" >
                <tr>
                    <td scope="row" width="12%"><font color="red">*</font>机构全称</td>
                    <td width="28%">
                    	<input type="text" name="organname" value="${nt.organname}" class="input1" maxlength="100" />
                    </td>
                    <td colspan="3" align="left">
                    	<font class="tip">填写完整名称,例:石家庄铁道大学</font>
                    </td>
                    <td width="12%">归口管理部门</td>
                    <td width="18%">
                    <input type="hidden" name="parentmgt1" id="parentmgt1" value="${nt.parentmgt}"/>
                        <select name="parentmgt" id="parentmgt" style="height:100%;width:100%;font-size:16px;">
                        <option value="select"></option>
							<%
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
                    <td scope="row"><font color="red">*</font>通讯地址</td>
                    <td>
                        <input type="text" name="contactaddr" id="contactaddr" value="${nt.contactaddr}" class="input1" maxlength="100" />
                    </td>
                    <td colspan="3" align="left">
                    	<font class="tip">省市县(区)等到号,例:河北省石家庄市桥东区北二环东路17号</font>
                    </td>
                    <td ><font color="red">*</font>所在地域</td>
                    <td>
                    	<select name="locationArea" id="locationArea" style="height:100%;width:100%;font-size:16px;">
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
                        <input type="text" name="unitweb" id="unitweb" value="${nt.unitweb}" class="input1" maxlength="255" />
                    </td>
                    <td colspan="2"><font color="red" >*</font>电子信箱</td>
                    <td>
                        <input type="text" name="email" id="email" value="${nt.email}" class="input1" maxlength="50" onblur="emailcheck()"/>
                    </td>
                    <td colspan="2" align="left">
                        <font class="tip">格式如：123456789@qq.com</font>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>法人代表</td>
                    <td>
                        <input type="text" name="legalperson" id="legalperson" value="${nt.legalperson}" class="input1" maxlength="20" />
                    </td>
                    <td colspan="2" width="8%">邮政编码</td>
                    <td >
                        <input type="text" name="postcode" id="postcode" value="${nt.postcode}" class="input1" maxlength="6" onblur="ybcheck()"/>
                    </td>
                    <td colspan="2" align="left">
                        <font class="tip">格式如：050043</font>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>联系人</td>
                    <td >
                        <input type="text" name="contacts" id="contacts" value="${nt.contacts}" class="input1"  maxlength="20" />
                    </td>
                    <td colspan="2">固定电话</td>	
                    <td >
                        <input type="text" name="tel" id="tel" value="${nt.tel}" class="input1" maxlength="12" onblur="ghcheck()"/>
                    </td>
                   <td colspan="2" align="left"> 
                   <font class="tip">格式如：031187936524</font>
                   </td>
                </tr>
                <tr>
                	<td ><font color="red">*</font>手机</td>
                    <td >
                        <input type="text" name="phone" id="phone" value="${nt.phone}" class="input1" maxlength="11" onblur="sjcheck()"/>
                    </td>
                    <td colspan="2">传真</td>
                    <td >
                        <input type="text" name="fax" id="fax" value="${nt.fax}" class="input1" maxlength="12" />
                    </td>
                    <td colspan="3" align="left">
                        <font class="tip">格式同固定电话</font>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>机构属性</td>
                    <td colspan="6" align="left">
                        <input type="radio" name="organattr" id="qy" value="企业" />
                        <label for="qy">企业</label>
                        <input type="radio" name="organattr" id="gdyx" value="高等院校" />
                        <label for="gdyx">高等院校</label>
                        <input type="radio" name="organattr" id="yjjg" value="研究机构" />
                        <label for="yjjg">研究机构</label>
                        <input type="radio" name="organattr" id="qtjg" value="其他" />
                        <label for="qtjg">其他</label>
                    </td>
                </tr>
                <tr>
                 <td scope="row">
                    <font color="red">*</font>机构简介
                    <td colspan="6" align="left">
                    	<p class="tip1">（主要包括基本情况、现有研究基础等，限500字以内）</p>
                    	<textarea name="organInfo" id="organInfo" cols="45" rows="5" class="textarea1" maxlength="500">${nt.organInfo}</textarea>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>技术需求名称</td>
                    <td>
                        <input type="text" name="needname" id="needname" value="${nt.needname}" class="input1" maxlength="100" style="height:100%;"/>
                    </td>
                    <td colspan="2"><font color="red">*</font>需求时限</td>
                    <td  align="left">
                        <input type="text" name="needsyear" value="${nt.needsyear}" style="width:80px;height:100%" maxlength="4" onblur="xqsx()"/> 年至
                        <input type="text" name="needeyear" value="${nt.needeyear}" style="width:80px;height:100%" maxlength="4" onblur="xqsx2()"/> 年
                    </td>
                    <td colspan="2" align="left">
                    	<font class="tip">例:2016年填写2016 截止年限大于开始年限，开始年至少为当年</font>
                    </td>
                </tr>
                <tr>
                    <td scope="row" style="height:100px;"><font color="red">*</font>技术需求概述</td>
                    <td height="63" colspan="6" align="left">
                    	<p class="tip1">1、主要问题（需要解决的重大技术问题，限500字以内）</p>
                        <textarea name="needoverview1" id="needoverview1" cols="45" rows="5" class="textarea1" maxlength="500">${nt.needoverview1}</textarea>
                        <p class="tip1">2、技术关键（所需的关键技术、主要指标，限500字以内）</p>
                        <textarea name="needoverview2" id="needoverview2" cols="45" rows="5" class="textarea1" maxlength="500">${nt.needoverview2}</textarea>
                        <p class="tip1">3、预期目标（技术创新性、经济社会效益，限500字以内）</p>
                        <textarea name="needoverview3" id="needoverview3" cols="45" rows="5" class="textarea1" maxlength="500">${nt.needoverview3}</textarea>
                    </td>

                </tr>
                <tr>
                    <td>
                        <font color="red">*</font>关键字<font style="font-size:14px;color:red;">（1-5个）</font>
                        <input type="hidden" name="needkey" id="needkey" value="${nt.needkey}"/>
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
                        <input type="text" name="totalmoney" id="totalmoney" value="${nt.totalmoney}" class="input1" onblur="zjzecheck()" />
                    </td>
                    <td colspan="5" align="left">&nbsp;万元</td>
                </tr>
                <tr>
                    <td rowspan="2" scope="row"><font color="red">*</font>技术需求解决方式</td>
                    <td colspan="6" align="left">
                        <input type="radio" name="needmodel" id="dlyf" value="独立研发" onclick="selLimit2()" />
                        <label for="dlyf">独立研发</label>
                        <input type="radio" name="needmodel" id="wtyf" value="委托研发" onclick="selLimit2()"/>
                        <label for="wtyf">委托研发</label>
                        <input type="radio" name="needmodel" id="hzyf" value="合作研发" onclick="selLimit2()" />
                        <label for="hzyf">合作研发 </label>
                        <input type="radio" name="needmodel" id="qtfs" value="其他" onclick="selLimit2()"/>
                        <label for="qtfs">其他</label>	
                    </td>
                </tr>
                <tr>
                    <td>合作意向单位
                    	<font style="font-size:14px;color:red;">(非必填)</font>
                    </td>
                    <td colspan="6" align="left">
                        <input type="text" name="coopunit" id="coopunit" value="${nt.coopunit}" class="input1" style="height:28px;" maxlength="100" />
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>科技活动类型</td>
                    <td colspan="6" align="left">
                        <input type="radio" name="restype" id="jc" value="基础研究" onclick="selLimit()" />
                        <label for="jc">基础研究</label>
                        <input type="radio" name="restype" id="yy" value="应用研究" onclick="selLimit()" />
                        <label for="yy">应用研究</label>
                        <input type="radio" name="restype" id="sy" value="试验发展" onclick="selLimit()" />
                        <label for="sy">试验发展</label>
                        <input type="radio" name="restype" id="fzyy" value="研究与试验发展成果应用" onclick="selLimit()" />
                        <label for="fzyy">研究与试验发展成果应用</label>
                        <input type="radio" name="restype" id="tgfw" value="技术推广与科技服务" onclick="selLimit()" />
                        <label for="tgfw">技术推广与科技服务</label>
                        <input type="radio" name="restype" id="schd" value="生产性活动" onclick="selLimit()" />
                        <label for="schd">生产性活动</label>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>学科分类<br/><br/>
                        <font style="font-size:14px;color:#000aff;">（限基础研究填写） </font>
                        <input type="hidden" name="subtype" id="subtype"/>
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
                        <input type="hidden" name="needfield" id="needfield" /></td>
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
                        <input type="hidden" name="needindustry" id="needindustry"/>
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