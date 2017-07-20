<%//@page import="com.sun.javafx.scene.layout.region.Margins.Converter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="./css/mycss/index.css" />
        <style type="text/css">
        .button2 {
		    background-color: rgba(99, 86, 255, 1);
		    height: 35px;
		    width: 60px;
		    border-radius:4px;
		    border: none;
		    color:white;
		    font-family: 宋体;
		    font-size: 16px;
		}

		.button2:hover {
		    background-color: #282ff7;
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
	    <script src="./js/jquery-1.4.js"></script>
	    <script type="text/javascript" src="./js/jquery-3.1.1.min.js"></script>
        <!-- 引入layer组件弹窗 -->
        <script src="./layer/layer.js"></script>
    	<script>
    	function btnagree()
    	{
			document.getElementById("states").value="部门审核通过";
    		return true;
    	}
    	function btndisagree()
    	{
    		document.getElementById("states").value="部门审核未通过";
    		if(form1.bmshyj.value.trim()=="")
    		{
    			layer.msg("请填写审核意见",{time:1200});
    			form1.bmshyj.focus(); 
    			return false;
    		}
    		return true;
    	}
   	 	</script>
   	 	
	</head>
	<body>
         <a href="javascript:history.go(-1);">
    		<button id="btnback" >返回</button>
    	</a>
        <div style="text-align: center;margin-top:10px;">
            <form id="form1" name="form1" method="post" action="need_update">
            
        <input type="hidden" name="id" value="${nt.id}"/>
        <input type="hidden" name="organname" value="${nt.organname}"/>
        <input type="hidden" name="parentmgt" value="${nt.parentmgt}"/>
        <input type="hidden" name="contactaddr" value="${nt.contactaddr}"/>
        <input type="hidden" name="locationArea" value="${nt.locationArea}"/>
        <input type="hidden" name="unitweb" value="${nt.unitweb}"/>
        <input type="hidden" name="email" value="${nt.email}"/>
        <input type="hidden" name="legalperson" value="${nt.legalperson}"/>
        <input type="hidden" name="postcode" value="${nt.postcode}"/>
        <input type="hidden" name="contacts" value="${nt.contacts}"/>
        <input type="hidden" name="tel" value="${nt.tel}"/>
        <input type="hidden" name="phone" value="${nt.phone}"/>
        <input type="hidden" name="fax" value="${nt.fax}"/>
        <input type="hidden" name="organattr" value="${nt.organattr}"/>
        <input type="hidden" name="organInfo" value="${nt.organInfo}"/>
        <input type="hidden" name="needname" value="${nt.needname}"/>
        <input type="hidden" name="needsyear" value="${nt.needsyear}"/>
        <input type="hidden" name="needeyear" value="${nt.needeyear}"/>
        <input type="hidden" name="needoverview1" value="${nt.needoverview1}"/>
        <input type="hidden" name="needoverview2" value="${nt.needoverview2}"/>
        <input type="hidden" name="needoverview3" value="${nt.needoverview3}"/>
        <input type="hidden" name="needkey" value="${nt.needkey}"/>
        <input type="hidden" name="totalmoney" value="${nt.totalmoney}"/>
        <input type="hidden" name="needmodel" value="${nt.needmodel}"/>
        <input type="hidden" name="coopunit" value="${nt.coopunit}"/>
        <input type="hidden" name="restype" value="${nt.restype}"/>
        <input type="hidden" name="subtype" value="${nt.subtype}"/>
        <input type="hidden" name="needfield" value="${nt.needfield}"/>
        <input type="hidden" name="needindustry" value="${nt.needindustry}"/>
        <input type="hidden" name="xsshyj" value="${nt.xsshyj}"/>
        <input type="hidden" name="glbm" value="${nt.glbm}"/>
        <input type="hidden" name="states" id="states"/>
        
        
            <table frame="border" rules="all" align="center" width="95%">
                <tr>
                    <td scope="row" width="12%"><font color="red">*</font>机构全称</td>
                    
                    <td align="left">
                    	${nt.organname}
                    </td>
                    <td colspan="3" width="12%">归口管理部门</td>
                    <td align="left" colspan="2">
						${nt.parentmgt}
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>通讯地址</td>
                    <td align="left">
                    	${nt.contactaddr}
                    </td>
                    <td colspan="3"><font color="red">*</font>所在地域</td>
                    <td align="left" colspan="2">
                    	${nt.locationArea}
                    </td>
                </tr>
                <tr>
                    <td scope="row">网&nbsp;址</td>
                    <td align="left">
                        ${nt.unitweb}
                    </td>
                    <td colspan="3"><font color="red" >*</font>电子信箱</td>
                    <td colspan="2" align="left">
                        ${nt.email}
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>法人代表</td>
                    <td align="left">
                       ${nt.legalperson}
                    </td>
                    <td colspan="3" >邮政编码</td>
                    
                    <td colspan="2" align="left" >
                        ${nt.postcode}
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>联系人</td>
                    <td align="left">
                        ${nt.contacts}
                    </td>
                    <td colspan="3">固定电话</td>
                    <td align="left">
                     ${nt.tel}
                    </td>
                    
                    
                </tr>
                <tr>
               	 	<td ><font color="red">*</font>手机</td>
                	<td align="left">
                       	${nt.phone}
                    </td>
                    <td colspan="2">传真</td>
                    <td colspan="4" align="left">
                       ${nt.fax}
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>机构属性</td>
                    <td colspan="6" align="left">
                       ${nt.organattr}
                    </td>
                </tr>
                <tr>
                 <td scope="row">
                    <font color="red">*</font>机构简介
                    <td colspan="6" align="left">
                    	${nt.organInfo}
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>技术需求名称</td>
                    <td align="left">
                       ${nt.needname}
                    </td>
                    <td colspan="2"><font color="red">*</font>需求时限</td>
                    <td  align="left" colspan="3">
                        ${nt.needsyear} 年至
                       ${nt.needeyear} 年
                    </td>
                </tr>
                <tr>
                    <td scope="row" style="height:100px;"><font color="red">*</font>技术需求概述</td>
                    <td height="63" colspan="6" align="left">
                    	<p class="tip1">1、主要问题（需要解决的重大技术问题，限500字以内）</p>
                        ${nt.needoverview2}
                        <p class="tip1">2、技术关键（所需的关键技术、主要指标，限500字以内）</p>
                        ${nt.needoverview1}
                        <p class="tip1">3、预期目标（技术创新性、经济社会效益，限500字以内）</p>
                        ${nt.needoverview3}
                    </td>

                </tr>
                <tr>
                    <td>
                        <font color="red">*</font>关键字<font style="font-size:14px;color:red;">（1-5个）</font>
                    </td>
                    <td colspan="7" align="left">
                        ${nt.needkey}
                    </td>

                </tr>
                <tr>
                    <td scope="row">资金需求总额</td>
                    <td align="left">
                        ${nt.totalmoney}
                    </td>
                    <td colspan="5" align="left">&nbsp;万元</td>
                </tr>
                <tr>
                    <td rowspan="2" scope="row"><font color="red">*</font>技术需求解决方式</td>
                    <td colspan="6" align="left">
                    	${nt.needmodel}
                    </td>
                </tr>
                <tr>
                    <td>合作意向单位
                    	<font style="font-size:14px;color:red;">(非必填)</font>
                    </td>
                    <td colspan="6" align="left">
                    ${nt.coopunit}
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>科技活动类型</td>
                    <td colspan="6" align="left">
                    ${nt.restype}
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>学科分类</td>
                    <td colspan="6" align="left">
                    ${nt.subtype}
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>需求技术所属领域</td>
                    <td colspan="6" align="left">
                    ${nt.needfield}
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>需求技术应用行业</td>
                    <td colspan="6" align="left">
                    ${nt.needindustry}
                    </td>
                </tr>
            </table>
       
	        <table width="95%" align="center" border="1px" frame="box" rules="none">
		        <tr>
		        	<td align="left"> 填写审核意见(200字以内)</td>
		        </tr>
		        <tr>
		        	<td><textarea maxlength="200" cols="45" rows="5" name="bmshyj" style="height:60px;width:99.4%;font-size:16px;resize: none;"></textarea></td>
		        </tr>
	        </table>
            <p>
                <input type="submit" name="submit" id="agree" value="通过" class="button2" onclick="return btnagree()" />
                <span style="display:inline-block;width:20px;"></span>
                <input type="submit" name="submit" id="disagree" value="不通过" class="button2" onclick="return btndisagree()" style="width:80px" />
         	</p>
        </form>
        </div>
	</body>
	</html>