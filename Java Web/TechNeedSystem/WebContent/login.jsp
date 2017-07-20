<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <title>登录-河北省重大技术需求征集系统</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="SHORTCUT ICON" href="images/xt.ico" />
        <style type="text/css">
            body {
                background: url(login/loginbg.jpg);
            }
            .txtcon {
                width: 100px;
                height: 30px;
                font-size: 16px;
                font-family: 幼圆;
                background-color: rgba(99, 86, 255, 0.94);
                color: white;
                border-radius: 4px;
                border: 0;
            }
             .submit:hover {
                background-color: #282ff7;
            }
        </style>
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="login/refresh.js"></script>
        <!--引入弹窗组件start-->
        <script type="text/javascript" src="js/attention/zDialog/zDrag.js">
        </script>
        <script type="text/javascript" src="js/attention/zDialog/zDialog.js">
        </script>
        <!--引入弹窗组件end-->
         <!-- 引入layer组件弹窗 -->
        <script src="layer/layer.js"></script>
        <!-- 回车换行 -->
        <script language="javascript" for="document" event="onkeydown">
            if (event.keyCode == 13 && event.srcElement.type != 'button' && event.srcElement.type != 'submit' && event.srcElement.type != 'reset' && event.srcElement.type != 'textarea' && event.srcElement.type != '')

                event.keyCode = 9; //Tab的键值为9 Enter的键值为13
        </script>

        <script type="text/javascript">
            function test() {
                top.Dialog.alert("如果丢失密码，请与0311-85813216电话联系！");
            }
        </script>
        <script type="text/javascript">
            function MM_swapImgRestore() { //v3.0
                var i, x, a = document.MM_sr;
                for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++)
                    x.src = x.oSrc;
            }

            function MM_preloadImages() { //v3.0


                var d = document;
                if (d.images) {
                    if (!d.MM_p)
                        d.MM_p = new Array();
                    var i, j = d.MM_p.length,
                        a = MM_preloadImages.arguments;
                    for (i = 0; i < a.length; i++)
                        if (a[i].indexOf("#") != 0) {
                            d.MM_p[j] = new Image;
                            d.MM_p[j++].src = a[i];
                        }
                }
            }

            function MM_findObj(n, d) { //v4.01
                var p, i, x;
                if (!d)
                    d = document;
                if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
                    d = parent.frames[n.substring(p + 1)].document;
                    n = n.substring(0, p);
                }
                if (!(x = d[n]) && d.all)
                    x = d.all[n];
                for (i = 0; !x && i < d.forms.length; i++)
                    x = d.forms[i][n];
                for (i = 0; !x && d.layers && i < d.layers.length; i++)
                    x = MM_findObj(n, d.layers[i].document);
                if (!x && d.getElementById)
                    x = d.getElementById(n);
                return x;
            }

            function MM_swapImage() { //v3.0
                var i, j = 0,
                    x, a = MM_swapImage.arguments;
                document.MM_sr = new Array;
                for (i = 0; i < (a.length - 2); i += 3)
                    if ((x = MM_findObj(a[i])) != null) {
                        document.MM_sr[j++] = x;
                        if (!x.oSrc)
                            x.oSrc = x.src;
                        x.src = a[i + 2];
                    }
            }

            function realodpage() {
                //alert(document.getElementById("shuaxin").src);
                $("#shuaxin").attr("src", "login/randCode.jsp?" + Math.random());
            }

            function re() {
                setTimeout("realodpage()", 10);
            }
            re();
        </script>
       
        <script>
            function check() {
                if (form0.uname.value == "") {
                	layer.tips('用户名不能为空', '#uname',{tips: [2, '#1874CD'],time:1200});
                    form0.uname.focus();
                    return false;
                }
                if (form0.pw.value == "") {
                	layer.tips('密码不能为空', '#pw',{tips: [2, '#1874CD'],time:1200});
                    form0.pw.focus();
                    return false;
                }
                if (form0.randcode.value == "") {
                	layer.tips('验证码不能为空', '#rc',{tips: [4, '#1874CD'],time:1200});
                	form0.randcode.focus();
                    return false;
                } 
                if (!isNum(form0.randcode.value)) {
                	layer.tips('验证码只能由数字组成', '#rc',{tips: [4, '#1874CD'],time:1200});
                    form0.randcode.value = "";
                    form0.randcode.focus();
                    return false;
                } /*
                if (CheckCode(form0.uname.value) && CheckCode(form0.pw.value) &&CheckCode(form0.randcode.value)) {
                    alert("有特殊字符请重新填写！");
                    form0.uname.value = "";
                    form0.pw.value = "";
                    form0.randcode.value = "";
                    return false;
                } */
                return true;
            }
            function isNum(str) {
                for (ilen = 0; ilen < str.length; ilen++) {
                    if (str.charAt(ilen) < '0' || str.charAt(ilen) > '9') {
                        return false;
                    }
                }
                return true;
            }
            /*
            function CheckCode(s) //有特殊字符为true  
            {
                var containSpecial = RegExp(/[(\ )(\~)(\!)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);
                return (containSpecial.test(s));
            }
            */
        </script>
        <script type="text/javascript">
        function inputfocus(){
    		document.getElementById("uname").focus();
    	}
        </script>
    </head>

    <body onLoad="inputfocus()">
		<form name="form0" action="login2.jsp" method="post" onsubmit="return check()">
        <table width="795" height="475" border="0" align="center" cellpadding="0" cellspacing="0" id="__01">
            <tr>
                <td colspan="5"><img src="login/login_01.jpg" width="795" height="159" alt=""></td>
            </tr>
            <tr>
                <td rowspan="2"><img src="login/login_02.jpg" width="269" height="174" alt=""></td>
                <td bgcolor="#CFE5F2"><img src="login/login_03.jpg" width="66" height="115" alt=""></td>
                <td colspan="2" bgcolor="#D0E6F3">
                    <table width="100%" height="116" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td colspan="2" align="left" valign="bottom">
                                <!-- 用户名 -->
                                <input type="text" name="uname" id="uname" class="STYLE1" maxlength="20" STYLE="width: 180px; height: 17px; border: #336699 1px solid" tabindex="1" />
                            </td>
                        </tr>
                        <tr>
                            <td height="32" colspan="2" align="left" valign="bottom">
                                <!-- 密码 -->
                                <input type="password" name="pw" id="pwd" class="STYLE1" maxlength="20" STYLE="width: 180px; height: 17px; border: #336699 1px solid" tabindex="1"  />
                            </td>
                        </tr>
                        <tr>
                            <td width="50%" height="29" align="left" valign="bottom">
                                <!-- 验证码 -->
                                <input type="text" name="randcode" id="rc" class="STYLE1" maxlength="10" STYLE="width: 100px; height: 17px; border: #336699 1px solid" tabindex="1" />
                            </td>
                            <td width="50%" align="left" valign="bottom">
                                <img src="login/randCode.jsp" id='shuaxin' width="50" height="25">
                            </td>
                        </tr>
                        <tr>
                            <td height="30" colspan="1" align="left" valign="bottom">&nbsp;</td>
                        </tr>
                    </table>
                </td>
                <td rowspan="2"><img src="login/login_05.jpg" width="262" height="174" alt=""></td>
            </tr>
            <tr>
                <td colspan="2">
               		<input type="submit" name="sure" id="sure" value="登录" class="txtcon submit" />
                </td>
                <td>
                	<a href="register.jsp"><button type="button" class="txtcon submit" >注册</button></a>
                </td>
            </tr>
            <tr>
                <td colspan="5">
                    <img src="login/login_08.jpg" alt="" width="795" height="141" border="0" usemap="#Map" />
                </td>
            </tr>
            <tr>
                <td><img src="login/&#x5206;&#x9694;&#x7b26;.gif" width="269" height="1" alt=""></td>
                <td><img src="login/&#x5206;&#x9694;&#x7b26;.gif" width="66" height="1" alt=""></td>
                <td><img src="login/&#x5206;&#x9694;&#x7b26;.gif" width="69" height="1" alt=""></td>
                <td><img src="login/&#x5206;&#x9694;&#x7b26;.gif" width="129" height="1" alt=""></td>
                <td><img src="login/&#x5206;&#x9694;&#x7b26;.gif" width="262" height="1" alt=""></td>
            </tr>
            <tr>
                <td colspan="5" align="center">
                    <!--a href="#">浏览器兼容问题说明</a-->
                </td>
            </tr>
        </table>
        </form>
        <map name="Map"><area shape="rect" coords="484,16,558,34" href="#"  onclick="test()" target="_self">
		</map>
    </body>
    </html>
