<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <!--title>提交中...</title-->
        <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
        <!-- 引入layer组件弹窗 -->
        <script src="../layer/layer.js"></script>
    </head>

    <body>
        <jsp:useBean id="db" class="bean.DBBean" scope="page" />
        <%
        request.setCharacterEncoding("UTF-8");
        
        String id="",jgmc="",gkbm="",txdz="",szdy="",dwwz="",dzxx="",frdb="",yzbm="",lxr="",gd="",sj="",cz="",jgsx="",
        		jgjj="",xqmc="",syear="",eyear="",xqgs1="",xqgs2="",xqgs3="",gjz="",jjfs="",
                		hzyxdw="",zjze="",hdlx="",xkfl="",xqly="",jsyyhy="",states="";
		double ze=0;
		
		id=request.getParameter("id");
		
        jgmc=request.getParameter("jgmc");
        gkbm=request.getParameter("gkbm");
        if(gkbm.equals("select"))
        {
        	gkbm="";
        }
        txdz=request.getParameter("txdz");
        szdy=request.getParameter("szdy");
        dwwz=request.getParameter("dwwz");
        dzxx=request.getParameter("dzxx");
        frdb=request.getParameter("frdb");
        yzbm=request.getParameter("yzbm");
        lxr=request.getParameter("lxr");
        gd=request.getParameter("gd");
        sj=request.getParameter("sj");
        cz=request.getParameter("cz");
        jgsx=request.getParameter("jgsx");
        jgjj=request.getParameter("jgjj");
        xqmc=request.getParameter("xqmc");
        syear=request.getParameter("syear");
        eyear=request.getParameter("eyear");
        xqgs1=request.getParameter("xqgs1");
        xqgs2=request.getParameter("xqgs2");
        xqgs3=request.getParameter("xqgs3");
        gjz=request.getParameter("gjz");
        zjze=request.getParameter("zjze");
        jjfs=request.getParameter("jjfs");
        hzyxdw=request.getParameter("hzyxdw");
        hdlx=request.getParameter("hdlx");
        xkfl=request.getParameter("xkfl");
        xqly=request.getParameter("xqly");
        jsyyhy=request.getParameter("jsyyhy");
        states=request.getParameter("states");
        if(!zjze.equals(""))
        {
        	//有时候出错  可能eclipse原因 或者 jdk加载原因
        	ze=Double.parseDouble(zjze);
        }
        
        String sql="update needtable set Organname='"+jgmc+"',parentmgt='"+gkbm+"',Contactaddr='"+txdz+"',LocationArea='"+szdy+
"',Unitweb='"+dwwz+"',Email='"+dzxx+"',Legalperson='"+frdb+"',Postcode='"+yzbm+"',Contacts='"+lxr+"',Tel='"+gd+"',phone='"+sj+
"',Fax='"+cz+"',organattr='"+jgsx+"',organInfo='"+jgjj+"',needname='"+xqmc+"',needsyear='"+syear+"',needeyear='"+eyear+
"',needoverview1='"+xqgs1+"',needoverview2='"+xqgs2+"',needoverview3='"+xqgs3+"',needkey='"+gjz+"',totalmoney="+ze+",needmodel='"+jjfs+ 
"',coopunit='"+hzyxdw+"',restype='"+hdlx+"',subtype='"+xkfl+"',needfield='"+xqly+"',needindustry='"+jsyyhy+"',states='"+states+"' where id="+id;

       // System.out.println(sql);
        String submit = request.getParameter("submit");
        String save = request.getParameter("save");
        //System.out.println(submit+" "+save);
    	if (save != null && !save.equals("")) {
    		int i = db.executeUpdate(sql);
    		if (i == 1) {
    			out.println("<script language='javaScript'>"+
    					"layer.open({title:'提示',content:'保存成功 ',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){window.location.href='xqgl.jsp'}});"
    					+"</script>");
    			
    		} else {
    			out.println("<script language='javaScript'> alert('保存失败，点击确定返回编辑页面！');history.back();</script>");
    			
    		}
    		db.close();
    	}
    	if (submit != null && !submit.equals("")) {
    		int i = db.executeUpdate(sql);
    		if (i == 1) {
    			out.println("<script language='javaScript'>"+
    					"layer.open({title:'提示',content:'保存并提交成功 ',skin: 'layui-layer-lan',closeBtn: 0,btn:['确定'],btn1:function(){window.location.href='xqgl.jsp'}});"
    					+"</script>");
    			
    		} else {
    			out.println("<script language='javaScript'> alert('保存并提交失败，点击确定返回修改页面！');history.back();</script>");
    			
    		}
    		db.close();
    	}
        %>
        
    </body>

    </html>