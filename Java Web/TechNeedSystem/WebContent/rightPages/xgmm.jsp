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
        <%
	       request.setCharacterEncoding("UTF-8");
	       String uname=(String)session.getAttribute("username");
	       %>
	       <input type="hidden" name="uname" id="uname" >
        <form method="post" action="xgmm.jsp" name="form1" onsubmit="return check()"> 
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
                    <input type="password" name="pw" id="pwd" class="inputcon" maxlength="20">
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
        
         <%
	       String pw=request.getParameter("pw");
         //加密
         if(pw!=null)
         {
        	 pw=md5.transMD5(pw);
         }
         //System.out.println(pw);
	       String submit=request.getParameter("submit");
	       String exist=db.userExist(uname);
		   String exist2=db.managerExist(uname);
		   String exist3=db.assessorExist(uname);
		   String exist4=db.mgtExist(uname);
		   //System.out.println(uname+" "+pw+" "+submit+" "+exist+" "+exist2);
	       if(submit!=null&&submit!="")
	       {
	    	   if(exist.equals(uname))
	    	   {
	    		   String sql="update userInfo set password='"+pw+"' where username='"+uname+"'";
	    		   int i=db.executeUpdate(sql);
	    		   if(i==1)
	    		   {
	    			   out.println("<script language='javaScript'>"+
								"layer.open({title:'提示',content:'修改成功！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){window.location.href='xgmm.jsp'}});"
								+"</script>");
	    		   }
	    		   else {
		    			out.println("<script language='javaScript'> alert('修改失败！');history.back();</script>");
		    			//response.setHeader("refresh", "0.1;url=register.jsp");
		    		}
	    	   }
	    	   if(exist2.equals(uname))
	    	   {
	    		   String sql="update managerInfo set password='"+pw+"' where username='"+uname+"'";
	    		   int i=db.executeUpdate(sql);
	    		   if(i==1)
	    		   {
	    			   out.println("<script language='javaScript'>"+
								"layer.open({title:'提示',content:'修改成功！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){window.location.href='xgmm.jsp'}});"
								+"</script>");
	    		   }
	    		   else {
		    			out.println("<script language='javaScript'> alert('修改失败！');history.back();</script>");
		    			//response.setHeader("refresh", "0.1;url=register.jsp");
		    		}
	    	   }
	    	   if(exist3.equals(uname))
	    	   {
	    		   String sql="update assessorInfo set password='"+pw+"' where username='"+uname+"'";
	    		   int i=db.executeUpdate(sql);
	    		   if(i==1)
	    		   {
	    			   out.println("<script language='javaScript'>"+
								"layer.open({title:'提示',content:'修改成功！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){window.location.href='xgmm.jsp'}});"
								+"</script>");
	    		   }
	    		   else {
		    			out.println("<script language='javaScript'> alert('修改失败！');history.back();</script>");
		    			//response.setHeader("refresh", "0.1;url=register.jsp");
		    		}
	    	   }
	    	   if(exist4.equals(uname))
	    	   {
	    		   String sql="update mgtInfo set password='"+pw+"' where username='"+uname+"'";
	    		   int i=db.executeUpdate(sql);
	    		   if(i==1)
	    		   {
	    			   out.println("<script language='javaScript'>"+
								"layer.open({title:'提示',content:'修改成功！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){window.location.href='xgmm.jsp'}});"
								+"</script>");
	    		   }
	    		   else {
		    			out.println("<script language='javaScript'> alert('修改失败！');history.back();</script>");
		    			//response.setHeader("refresh", "0.1;url=register.jsp");
		    		}
	    	   }
	       }
        %>
    </body>

    </html>