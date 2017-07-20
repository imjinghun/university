<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="SHORTCUT ICON" href="image/bt.ico" />
        <title>注册中...</title>
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <!-- 引入layer组件弹窗 -->
        <script src="layer/layer.js"></script>
    </head>

    <body>
     <jsp:useBean id="db" class="bean.DBBean" scope="page" />
     <jsp:useBean id="md5" class="bean.MD5JM" scope="page" />
        <%
        request.setCharacterEncoding("UTF-8");
        String yhm,mm,jgdm,jgmc,gkbm,txdz,dwwz,dzxx,frdb,yzbm,lxr,gh,sj,cz;
        yhm=request.getParameter("uname");
        mm=request.getParameter("pw");
        if(mm!=null)
        {
        	mm=md5.transMD5(mm);
        }
        jgdm=request.getParameter("jgdm");
        jgmc=request.getParameter("jgmc");
        gkbm=request.getParameter("gkbm");
        txdz=request.getParameter("txdz");
        dwwz=request.getParameter("dwwz");
        dzxx=request.getParameter("dzxx");
        frdb=request.getParameter("frdb");
        yzbm=request.getParameter("yzbm");
        lxr=request.getParameter("lxr");
        gh=request.getParameter("gh");
        sj=request.getParameter("sj");
        cz=request.getParameter("cz");
        String sql="insert into userinfo values('"+yhm+"','"+mm+"','"+jgdm+"','"+jgmc+"','"+gkbm+"','"+txdz+"','"+ dwwz+"','"+dzxx+"','"
        +frdb+"','"+yzbm+"','"+lxr+"','"+gh+"','"+sj+"','"+cz+"')";
        
      //  System.out.println(mm);
        String submit = request.getParameter("submit");
    	if (submit != null && !submit.equals("")) {
    		String uname = request.getParameter("uname");
			String exist=db.userExist(uname);
			String exist2=db.managerExist(uname);
			String exist3=db.assessorExist(uname);
			String exist4=db.mgtExist(uname);
			try
			{
				if(exist.equals(uname))
				{
					out.println("<script language='javaScript'>"+
							"layer.open({title:'提示',content:'用户已存在！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){history.back();}});"
							+"</script>");
				}
				else if(exist2.equals(uname))//管理员
				{
					out.println("<script language='javaScript'>"+
							"layer.open({title:'提示',content:'用户已存在！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){history.back();}});"
							+"</script>");
				}
				else if(exist3.equals(uname))//形式审核员
				{
					out.println("<script language='javaScript'>"+
							"layer.open({title:'提示',content:'用户已存在！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){history.back();}});"
							+"</script>");
				}
				else if(exist4.equals(uname))//部门审核员
				{
					out.println("<script language='javaScript'>"+
							"layer.open({title:'提示',content:'用户已存在！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){history.back();}});"
							+"</script>");
				}
				else
				{
					int i = db.executeUpdate(sql);
		    		if (i == 1) {
		    			//从iframe中跳出到父级页面
		    			out.println("<script language='javaScript'>"+
								"layer.open({title:'提示',content:'注册成功，进入登录界面！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){window.parent.frames.location.href='login.jsp'}});"
								+"</script>");
		    		}
		    		else {
		    			out.println("<script language='javaScript'> alert('注册失败！');history.back();</script>");
		    			//response.setHeader("refresh", "0.1;url=register.jsp");
		    		}
				}
			}
			catch(Exception ex)
			{
				out.println("<script language='javaScript'> alert('注册失败,有异常！');history.back();</script>");
			}
    		db.close();
    	}
       %>
    </body>

    </html>