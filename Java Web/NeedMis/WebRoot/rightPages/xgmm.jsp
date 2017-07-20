<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <style type="text/css">
            .inputcon {
                width: 90%;
                height: 100%;
                font-size: 16px;
            }
            .btn{
            height: 30px;
                width: 60px;
                font-size: 16px;
                border: 1px;
                background-color: #B0B0B0;
            }
            .btn:hover {
                background-color: #6A5ACD;
            }
        </style>
        <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
        <!-- 引入layer组件弹窗 -->
        <script src="../layer/layer.js"></script>
        <!--加密算法  -->
        <script type="text/javascript" src="../js/myjs/jiami.js"> </script>
        <script type="text/javascript">
            function check() {
            	var pwd=document.getElementById("pwd");
            	var pwd1=document.getElementById("pwd1");
                if (pwd.value == "") {
                	pwd.focus();
                	layer.msg('密码不能为空',{time:1200});
                    return false;
                }
                if (pwd.value.length<6) {
                	pwd.focus();
                	layer.msg('密码长度不能低于6位',{time:1200});
                    return false;
                }
                if (pwd1.value == "") {
                	pwd1.focus();
                	layer.msg('确认密码不能为空',{time:1200});
                    return false;
                }
                if (pwd1.value != pwd.value) {
                	pwd1.focus();
                	layer.msg('两次密码不一致',{time:1200});
                    return false;
                }
                return true;
            }
        </script>
        

    </head>

    <body>
        <jsp:useBean id="db" class="bean.DBBean" scope="page" />
        <jsp:useBean id="md5" class="bean.MD5JM" scope="page" />
       
        <form method="post" action="user_updatePwd" name="form1" onsubmit="return check()"> 
        <input type="hidden" name="username"  value="${user1.username}" />
        <input type="hidden" name="organcode"  value="${user1.organcode}" />
        <input type="hidden" name="organname"  value="${user1.organname}" />
        <input type="hidden" name="parentmgt"  value="${user1.parentmgt}" />
        <input type="hidden" name="contactaddr"  value="${user1.contactaddr}" />
        <input type="hidden" name="unitweb"  value="${user1.unitweb}" />
        <input type="hidden" name="email"  value="${user1.email}" />
        <input type="hidden" name="legalperson"  value="${user1.legalperson}" />
        <input type="hidden" name="postcode"  value="${user1.postcode}" />
        <input type="hidden" name="contacts"  value="${user1.contacts}" />
        <input type="hidden" name="tel"  value="${user1.tel}" />
        <input type="hidden" name="phone"  value="${user1.phone}" />
        <input type="hidden" name="fax"  value="${user1.fax}" />
        <input type="hidden" name="glbm"  value="${user1.glbm}" />
        <input type="hidden" name="powers"  value="${user1.powers}" />
        <table>

            <tr height="10px">
                <td width=20%></td>
                <td width=35%></td>
                <td width=45%></td>
            </tr>
            <tr height="10px"></tr>
            <tr height="35px">
                <td align='right'>
                    <font color="red">*</font>新密码</td>
                <td>
                    <input type="password" name="password" id="pwd" class="inputcon" maxlength="20">
                </td>
                <td align='left'>
                    <font class="font1">6-20位</font>
                </td>
            </tr>
            <tr height="35px">
                <td align='right'>
                    <font color="red">*</font>确认密码</td>
                <td>
                    <input type="password" name="pw1" id="pwd1" class="inputcon" maxlength="20">
                </td>
            </tr>
            <tr height="10px"></tr>
            <tr>
                <td></td>
                <td>
                <input type="submit" name="submit" value="确定" class="btn" onclick=""/>
                <input type="reset" value="重置" class="btn" style="margin-left:20px;"/>
                </td>
                <td></td>
            </tr>
        </table>
        </form>
    </body>

    </html>