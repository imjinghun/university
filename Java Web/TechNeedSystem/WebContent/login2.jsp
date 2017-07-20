<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="SHORTCUT ICON" href="image/bt.ico" />
        <title>登录中...</title>
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <!-- 引入layer组件弹窗 -->
        <script src="layer/layer.js"></script>
    </head>

    <body>
      <jsp:useBean id="db" class="bean.DBBean" scope="page" />
       <jsp:useBean id="md5" class="bean.MD5JM" scope="page" />
	<%
	request.setCharacterEncoding("UTF-8");
	String randCode=(String)session.getAttribute("rand");
	//System.out.println(randCode);
	String submit = request.getParameter("sure");
	if (submit != null && !submit.equals("")) {
		String uname = request.getParameter("uname");
		String pw = request.getParameter("pw");
		//加密
		if(pw!=null)
		{
			pw=md5.transMD5(pw);
		}
		//获得验证码
		String rand=request.getParameter("randcode");
		String exist=db.userExist(uname);
		String exist2=db.managerExist(uname);
		String exist3=db.assessorExist(uname);
		String exist4=db.mgtExist(uname);
		if(!rand.equals(randCode))
		{
			out.println("<script language='javaScript'>"+
			"layer.open({title:'提示',content:'验证码不正确！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){history.back();}});"
			+"</script>");
			//System.out.println(rand);
			return;
		}
		if(exist.equals(uname))
		{
			String sql="select password from userinfo where username='"+uname+"'";
			ResultSet rs = db.executeQuery(sql);
			rs.next();
			String str=rs.getString(1);
			if(pw.equals(str))
			{
				request.getSession().setAttribute("username", uname);
				response.sendRedirect("index.jsp");
			}
			else
			{
				out.println("<script language='javaScript'>"+
						"layer.open({title:'提示',content:'密码不正确！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){history.back();}});"
						+"</script>");
			}
		}
		else if(exist2.equals(uname))//管理员
		{
			String sql="select password from managerinfo where username='"+uname+"'";
			ResultSet rs = db.executeQuery(sql);
			rs.next();
			String str=rs.getString(1);
			if(pw.equals(str))
			{
				request.getSession().setAttribute("username", uname);
				response.sendRedirect("index1.jsp");
			}
			else
			{
				out.println("<script language='javaScript'>"+
						"layer.open({title:'提示',content:'密码不正确！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){history.back();}});"
						+"</script>");
			}
		}
		else if(exist3.equals(uname))//形式审核员
		{
			String sql="select password from assessorinfo where username='"+uname+"'";
			ResultSet rs = db.executeQuery(sql);
			rs.next();
			String str=rs.getString(1);
			if(pw.equals(str))
			{
				request.getSession().setAttribute("username", uname);
				response.sendRedirect("index2.jsp");
			}
			else
			{
				out.println("<script language='javaScript'>"+
						"layer.open({title:'提示',content:'密码不正确！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){history.back();}});"
						+"</script>");
			}
		}
		else if(exist4.equals(uname))//部门审核员
		{
			String sql="select password from mgtinfo where username='"+uname+"'";
			ResultSet rs = db.executeQuery(sql);
			rs.next();
			String str=rs.getString(1);
			if(pw.equals(str))
			{
				request.getSession().setAttribute("username", uname);
				response.sendRedirect("index3.jsp");
			}
			else
			{
				out.println("<script language='javaScript'>"+
						"layer.open({title:'提示',content:'密码不正确！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){history.back();}});"
						+"</script>");
			}
		}
		else
		{
			out.println("<script language='javaScript'>"+
					"layer.open({title:'提示',content:'用户不存在，请注册！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){history.back();}});"
					+"</script>");
		}
		db.close();
	}
	%>
    </body>

    </html>