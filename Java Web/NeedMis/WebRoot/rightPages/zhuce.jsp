<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*,com.jing.entity.*" %>
    <%@taglib uri="/struts-tags" prefix="s" %>
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
        	if (form1.username.value.length<6) {
                form1.username.focus();
                layer.msg('用户名长度不能低于6位',{time:1200});
                return false;
            }
        	return true;
        }
        function mml()
        {
        	if (form1.password.value.length<6) {
                form1.password.focus();
                layer.msg('密码长度不能低于6位',{time:1200});
                return false;
            }
        	return true;
        }
        function mm2()
        {
        	if (form1.password.value != form1.password1.value) {
                form1.password1.focus();
                layer.msg('两次密码不一致',{time:1200});
                return false;
            }
        	return true;
        }
        </script>
        
<script type="text/javascript">
	$(function() {

		$("#username").blur(function() {
		var uname=$("#username").val();
		if(uname!="")
		{
			$.post({
				url : "../ajax/usercheck",
				data : {
					"username" : uname,
					"powers":"nothing"
				},
				dataType: "json", 
				success : function(data) {
					if(data.powers!="nothing")
					{
						$("#unamecheck").text("用户已存在");
					}
					else
					{
					$("#unamecheck").text("");
					}
				}
			}); 
		} 

		});

	});
</script>
        
    </head>

    <body>
     <jsp:useBean id="db" class="bean.DBBean" scope="page" /> 
        <div class="div1">
            
            <hr style="height:1px;border:none;border-top:1px solid #a39e9e;" />
            	<span style="font-size: 25px;font-weight:bold;text-align:left;">注意：(带<font color="red"> * </font>为必填项)</span>
            <hr style="height:1px;border:none;border-top:1px solid #a39e9e;" />
            
            <form name="form1" action="user_register" method="post" onsubmit="return check()">
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
                        	<input type="text" name="username" id="username" class="inputcon" maxlength="20" onchange="return yhml()">
                        </td>
                        <td align='left'>
                        	<font class="font1">6-20位</font>
                        	 <label style="color:red;" id="unamecheck"></label>
                        </td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>密码</td>
                        <td >
                        	<input type="password" name="password" id="password"  class="inputcon" maxlength="20" onchange="return mml()">
                        </td>
                        <td align='left'>
                        	<font class="font1">6-20位</font>
                        </td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>确认密码</td>
                        <td>
                        	<input type="password" name="password1" id="password1" class="inputcon" maxlength="20" onchange="mm2()">
                        </td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>机构代码</td>
                        <td >
                        	<input type="text" name="organcode" id="organcode"  class="inputcon" maxlength="20">
                        </td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>机构全称</td>
                        <td >
                        	<input type="text" name="organname" id="organname" class="inputcon" maxlength="50">
                        </td>
                        <td align='left'>
                    		<font class="font1">填写完整名称,例:石家庄铁道大学</font>
                    	</td>
                    </tr>
                    <tr>
                     	<td align='right'>归口管理部门</td>
                    	<td >
                        	<select name="parentmgt" id="parentmgt"  class="inputcon">
							</select>
                   	 	</td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>通讯地址</td>
                        <td >
                        	<input type="text" name="contactaddr" id="contactaddr" class="inputcon" maxlength="50">
                        </td>
                        <td align="left">
                    		<font class="font1">通讯地址格式:省市县(区)到号,例:河北省石家庄市桥东区北二环东路17号</font>
                    	</td>
                    </tr>
                    <tr height="35px">
                        <td align='right'>单位网址</td>
                        <td >
                        <input type="text" name="unitweb" id="unitweb"  class="inputcon" maxlength="255"></td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>电子信箱</td>
                        <td >
                        	<input type="text" name="email" id="email"  class="inputcon" maxlength="50" onblur="emailcheck()">
                        </td>
                        <td align="left">
                        	<font class="font1">电子信箱格式如:123456789@qq.com</font>
                    	</td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>法人代表</td>
                        <td >
                        <input type="text" name="legalperson" id="legalperson" class="inputcon" maxlength="20"></td>
                    </tr>
                    <tr height="35px">
                        <td align='right'>邮政编码</td>
                        <td >
                        <input type="text" name="postcode" id="postcode" class="inputcon" maxlength="6" onblur="ybcheck()"></td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>联系人</td>
                        <td >
                        <input type="text" name="contacts" id="contacts"  class="inputcon" maxlength="20"></td>
                    </tr>
                    <tr height="35px">
                        <td align='right'>固话</td>
                        <td >
                        	<input type="text" name="tel" id="tel"  class="inputcon" maxlength="12" onblur="ghcheck()">
                        </td>
                        <td align="left">
							<font class="font1">固话格式:区号加号码,例:031187936524</font>
						</td>
                    </tr>
                    <tr height="35px">
                        <td align='right'><font color="red">*</font>手机</td>
                        <td >
                        	<input type="text" name="phone" id="phone"  class="inputcon" maxlength="11" onblur="sjcheck()">
                        </td>
                        <td align="left">
                        <font class="font1">手机格式:11位,例:15226666666</font>
                        </td>
                    </tr>
                    <tr height="35px">
                        <td align='right'>传真</td>
                        <td >
                        <input type="text" name="fax" id="fax"  class="inputcon" maxlength="12"></td>
                    </tr>
                    <tr height="10px">
                        <td></td>
                        <td></td>
                    </tr>
                    <tr height="35px">
                        <td colspan="2" align="center">
	                        <input type="submit" name="submit" id="submit" value="确定" class="txtcon submit">
	                        <span style=" width:15px;;display: inline-block;"></span>
	                        <input type="reset" value="重置" class="txtcon submit">
	                    </td>
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
