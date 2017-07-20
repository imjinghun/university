<%//@page import="com.sun.javafx.scene.layout.region.Margins.Converter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="../css/mycss/index.css" />
        <style type="text/css">
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
	    <script src="../js/jquery-1.4.js"></script>
    	<script>
    	
   	 	</script>
	</head>
	<body>
	<jsp:useBean id="db" class="bean.DBBean" scope="page" />
        <%
	       request.setCharacterEncoding("UTF-8");
        	String id=request.getParameter("id");
        String sql="select * from needtable where id="+id;
        ResultSet rs=db.executeQuery(sql);
        String str[]=new String[34];
        if(rs.next())
        {
        	for(int i=2;i<34;i++)
        	{
        		if(i!=23)
        		{
        			str[i]=rs.getString(i);
        		}
        		else
        		{
        			str[i]=rs.getInt(i)+"";
        		}
        	}
        	//System.out.println(str[31]+","+str[32]+","+str[33]);
        }
        %>
        <a href="javascript:history.go(-1);">
    		<button id="btnback" >返回</button>
    	</a>
        <div style="text-align: center;margin-top:10px;">
            <table frame="border" rules="all" align="center" width="95%">
                <tr>
                    <td scope="row" width="12%"><font color="red">*</font>机构全称</td>
                    
                    <td align="left">
                    	<%=str[2]%>
                    </td>
                    <td colspan="3" width="12%">归口管理部门</td>
                    <td align="left" colspan="2">
						<%if(!str[3].equals("")) out.print(str[3].substring(3));%>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>通讯地址</td>
                    <td align="left">
                    	<%=str[4]%>
                    </td>
                    <td colspan="3"><font color="red">*</font>所在地域</td>
                    <td align="left" colspan="2">
                    	<%=str[5].substring(7)%>
                    </td>
                </tr>
                <tr>
                    <td scope="row">网&nbsp;址</td>
                    <td align="left">
                        <%=str[6]%>
                    </td>
                    <td colspan="3"><font color="red" >*</font>电子信箱</td>
                    <td colspan="2" align="left">
                        <%=str[7]%>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>法人代表</td>
                    <td align="left">
                       <%=str[8]%>
                    </td>
                    <td colspan="3" >邮政编码</td>
                    
                    <td colspan="2" align="left" >
                        <%=str[9]%>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>联系人</td>
                    <td align="left">
                        <%=str[10]%>
                    </td>
                    <td colspan="3">固定电话</td>
                    <td align="left">
                       	 <%=str[11]%>
                    </td>
                    
                </tr>
                <tr>
                	<td><font color="red">*</font>手机</td>
                	<td align="left">
                       	 <%=str[12]%>
                    </td>
                    <td colspan="2">传真</td>
                    <td colspan="4" align="left">
                        <%=str[13]%>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>机构属性</td>
                    <td colspan="6" align="left">
                       <%=str[14] %>
                    </td>
                </tr>
                <tr>
                 <td scope="row">
                    <font color="red">*</font>机构简介
                    <td colspan="6" align="left">
                    	<%=str[15]%>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>技术需求名称</td>
                    <td align="left">
                        <%=str[16]%>
                    </td>
                    <td colspan="2"><font color="red">*</font>需求时限</td>
                    <td  align="left" colspan="3">
                        <%=str[17]%> 年至
                        <%=str[18]%> 年
                    </td>
                </tr>
                <tr>
                    <td scope="row" style="height:100px;"><font color="red">*</font>技术需求概述</td>
                    <td height="63" colspan="6" align="left">
                    	<p class="tip1">1、主要问题（需要解决的重大技术问题，限500字以内）</p>
                        <%=str[19] %>
                        <p class="tip1">2、技术关键（所需的关键技术、主要指标，限500字以内）</p>
                        <%=str[20] %>
                        <p class="tip1">3、预期目标（技术创新性、经济社会效益，限500字以内）</p>
                        <%=str[21] %>
                    </td>

                </tr>
                <tr>
                    <td>
                        <font color="red">*</font>关键字<font style="font-size:14px;color:red;">（1-5个）</font>
                    </td>
                    <td colspan="7" align="left">
                        <%=str[22]%>
                    </td>

                </tr>
                <tr>
                    <td scope="row">资金需求总额</td>
                    <td align="left">
                        <%=str[23]%>
                    </td>
                    <td colspan="5" align="left">&nbsp;万元</td>
                </tr>
                <tr>
                    <td rowspan="2" scope="row"><font color="red">*</font>技术需求解决方式</td>
                    <td colspan="6" align="left">
                    	<%=str[24] %>
                    </td>
                </tr>
                <tr>
                    <td>合作意向单位
                    	<font style="font-size:14px;color:red;">(非必填)</font>
                    </td>
                    <td colspan="6" align="left">
                    <%=str[25]%>
                    </td>
                </tr>
                <tr>
                    <td scope="row"><font color="red">*</font>科技活动类型</td>
                    <td colspan="6" align="left">
                    <%=str[26]%>
                    </td>
                </tr>
                <%
	                if(str[26].equals("基础研究")) 
	                {
	                	out.print("<tr><td scope='row'><font color='red'>*</font>学科分类<br/><br/>"+
	                			"<font style='font-size:14px;color:#000aff;''>（限基础研究填写） </font></td>"+
	                	"<td colspan='6' align='left'>"+str[27]+"</td></tr>");
	                }
	                else
	                {
	                	out.print("<tr><td scope='row'><font color='red'>*</font>需求技术所属领域<br/><br/>"+
	                			"<font style='font-size:14px;color:#000aff;''>（非基础研究填写） </font></td>"+
	                	"<td colspan='6' align='left'>"+str[28]+"</td></tr>"+
	                	
	                			"<tr><td scope='row'><font color='red'>*</font>需求技术应用行业<br/><br/>"+
            			"<font style='font-size:14px;color:#000aff;''>（非基础研究填写） </font></td>"+
            			"<td colspan='6' align='left'>"+str[29]+"</td></tr>");
	                }
                %>
            </table>
       
	        <table width="95%" align="center"  border="1px" frame="box" rules="none">
		        <tr>
		        	<td align="left">
		        		<%
		        		if(str[30].equals("2"))
		        		{
		        			out.print("等待审核<br/>");
		        		}
		        		if(str[30].equals("1"))
		        		{
		        			out.print("等待部门审核<br/>");
		        		}
		        		if(str[30].equals("0"))
		        		{
		        			out.print("形式审核意见："+str[31]+"<br/>");
		        		}
		        		if(str[30].equals("10"))
		        		{
		        			out.print("形式审核意见："+str[31]+"<br/>");
		        			out.print("<br/>部门审核意见："+str[33]);
		        		}
		        		if(str[30].equals("11"))
		        		{
		        			out.print("形式审核意见："+str[31]+"<br/>");
		        			out.print("<br/>部门审核意见："+str[33]);
		        		}
		        		%>
					</td>
		        </tr>
	        </table>
        
        </div>
	</body>
	</html>