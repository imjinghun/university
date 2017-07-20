<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="SHORTCUT ICON" href="image/bt.ico" />
        <title>修改中...</title>
        <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
        <!-- 引入layer组件弹窗 -->
        <script src="../layer/layer.js"></script>
    </head>

    <body>
     <jsp:useBean id="db" class="bean.DBBean" scope="page" />
        <%
        request.setCharacterEncoding("UTF-8");
	    String uname=(String)session.getAttribute("username");
        String jgdm,jgmc,gkbm,txdz,dwwz,dzxx,frdb,yzbm,lxr,gh,sj,cz;
        
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
        
        String sql="update userinfo set Organcode='"+jgdm
        		+"',Organname='"+jgmc+"',parentmgt='"+gkbm+"',Contactaddr='"+txdz+"',Unitweb='"+ dwwz+"',Email='"+dzxx
        		+"',Legalperson='"+frdb+"',Postcode='"+yzbm+"',Contacts='"+lxr+"',Tel='"+gh+"',Phone='"+sj+"',Fax='"+cz+"'where username='"+uname+"'";
        
      //  System.out.println(sql);
        String submit = request.getParameter("submit");
    	if (submit != null && !submit.equals("")) {
			try
			{
				int i = db.executeUpdate(sql);
	    		if (i == 1) {
	    			out.println("<script language='javaScript'>"+
							"layer.open({title:'提示',content:'修改成功！',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){window.location.href='yhxx.jsp'}});"
							+"</script>");
	    		}
	    		else {
	    			out.println("<script language='javaScript'> alert('修改失败！');history.back();</script>");
	    			//response.setHeader("refresh", "0.1;url=register.jsp");
	    		}
			}
			catch(Exception ex)
			{
				out.println("<script language='javaScript'> alert('修改失败,有异常！');history.back();</script>");
			}
    		db.close();
    	}
       %>
    </body>

    </html>