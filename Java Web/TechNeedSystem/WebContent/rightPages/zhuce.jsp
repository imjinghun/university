<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="../css/mycss/register.css" /> 
        <script src="../js/myjs/register.js"></script>
        
        <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
        <!-- 引入layer组件弹窗 -->
        <script src="../layer/layer.js"></script>
        <script>
        function yhml()
        {
        	if (form1.uname.value.length<6) {
                form1.uname.focus();
                layer.msg('用户名长度不能低于6位',{time:1200});
                return false;
            }
        	return true;
        }
        function mml()
        {
        	if (form1.pw.value.length<6) {
                form1.pw.focus();
                layer.msg('密码长度不能低于6位',{time:1200});
                return false;
            }
        	return true;
        }
        function jm()
        {
        	if (form1.pw1.value != form1.pw.value) {
                form1.pw1.focus();
                layer.msg('两次密码不一致',{time:1200});
                return false;
            }
        	return true;
        }
        </script>
    </head>

    <body>
     <jsp:useBean id="db" class="bean.DBBean" scope="page" />
        <div class="div1">
            
            <hr style="height:1px;border:none;border-top:1px solid #a39e9e;" />
            	<span style="font-size: 25px;font-weight:bold;text-align:left;">注意：(带<font color="red"> * </font>为必填项)</span>
            <hr style="height:1px;border:none;border-top:1px solid #a39e9e;" />
            
            <form name="form1" action="../register2.jsp" method="post" onsubmit="return check()">
                <table >
                
                    <tr height="10px">
                        <td width=20%></td>
                        <td width=35%></td>
                        <td width=45%></td>
                    </tr>
                    <tr height="10px"></tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>用户名</td>
                        <td>
                        	<input type="text" name="uname" id="uname" class="inputcon" maxlength="20" onchange="return yhml()">
                        </td>
                        <td align='left'>
                        	<font class="font1">6-20位</font>
                        </td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>密码</td>
                        <td >
                        	<input type="password" name="pw" id="pwd" class="inputcon" maxlength="20" onchange="return mml()">
                        </td>
                        <td align='left'>
                        	<font class="font1">6-20位</font>
                        </td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>确认密码</td>
                        <td>
                        	<input type="password" name="pw1" id="pwd1" class="inputcon" maxlength="20" onchange="jm()">
                        </td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>机构代码</td>
                        <td >
                        	<input type="text" name="jgdm" id="jgdm" class="inputcon" maxlength="20">
                        </td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>机构全称</td>
                        <td >
                        	<input type="text" name="jgmc" id="jgmc" class="inputcon" maxlength="50">
                        </td>
                        <td align='left'>
                    		<font class="font1">填写完整名称,例:石家庄铁道大学</font>
                    	</td>
                    </tr>
                    <tr>
                     	<td align='right'>归口管理部门</td>
                    	<td >
                        	<select name="gkbm" id="gk"  class="inputcon">
                        		<option value="select" selected="selected">请选择</option>
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
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>通讯地址</td>
                        <td >
                        	<input type="text" name="txdz" id="txdz" class="inputcon" maxlength="50">
                        </td>
                        <td align="left">
                    		<font class="font1">通讯地址格式:省市县(区)到号,例:河北省石家庄市桥东区北二环东路17号</font>
                    	</td>
                    </tr>
                    <tr height="35px">
                        <td align='right'>单位网址</td>
                        <td >
                        <input type="text" name="dwwz" id="dwwz" class="inputcon" maxlength="255"></td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>电子信箱</td>
                        <td >
                        	<input type="text" name="dzxx" id="dzxx" class="inputcon" maxlength="50" onblur="emailcheck()">
                        </td>
                        <td align="left">
                        	<font class="font1">电子信箱格式如:123456789@qq.com</font>
                    	</td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>法人代表</td>
                        <td >
                        <input type="text" name="frdb" id="frdb" class="inputcon" maxlength="20"></td>
                    </tr>
                    <tr height="35px">
                        <td align='right'>邮政编码</td>
                        <td >
                        <input type="text" name="yzbm" id="yzbm" class="inputcon" maxlength="6" onblur="ybcheck()"></td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>联系人</td>
                        <td >
                        <input type="text" name="lxr" id="lxr" class="inputcon" maxlength="20"></td>
                    </tr>
                    <tr height="35px">
                        <td align='right'>固话</td>
                        <td >
                        	<input type="text" name="gh" id="gh" class="inputcon" maxlength="12" onblur="ghcheck()">
                        </td>
                        <td align="left">
							<font class="font1">固话格式:区号加号码,例:031187936524</font>
						</td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>手机</td>
                        <td >
                        	<input type="text" name="sj" id="sj" class="inputcon" maxlength="11" onblur="sjcheck()">
                        </td>
                        <td align="left">
                        <font class="font1">手机格式:11位,例:15226666666</font>
                        </td>
                    </tr>
                    <tr height="35px">
                        <td align='right'>传真</td>
                        <td >
                        <input type="text" name="cz" id="cz" class="inputcon" maxlength="12"></td>
                    </tr>
                    <tr height="10px">
                        <td></td>
                        <td></td>
                    </tr>
                    <tr height="35px">
                        <td colspan="2" align="center"><input type="submit" name="submit" value="确定" class="txtcon submit"><span style=" width:15px;;display: inline-block;"></span>
                            <input type="reset" value="重置" class="txtcon submit"></td>
                    </tr>
                    <tr height="15px">
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </form>
            <table>
            	<tr height="40px">
                        <td></td>
                        <td></td>
                    </tr>
            </table>
        </div>
    </body>

    </html>
