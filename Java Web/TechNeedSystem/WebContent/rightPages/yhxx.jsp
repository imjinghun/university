<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="../css/mycss/register.css" /> 
        <script src="../js/myjs/yhxx.js"></script>
        <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
        <!-- 引入layer组件弹窗 -->
        <script src="../layer/layer.js"></script>
        <style type="text/css">
        table tr{
        height:35px;
        }
        #xg{
        height:30px;
        width:60px;
        font-size:16px;
        color:white;
        background-color: rgba(99, 86, 255, 0.94);
        border: 0;
        }
        #xg:hover{
        background-color: #282ff7;
        }
        .sacan{
        height:30px;
        width:60px;
        font-size:16px;
        border:0px;
        color:white;
        background-color: #282ff7;
        }
        .sacan:hover{
        color:black;
        background-color: yellow;
        }
        </style>
        <script>
        function setReadonly(){
        	var inputs=document.getElementsByTagName("input");
            for(var i=0;i<inputs.length;i++){
            inputs[i].setAttribute("readOnly",true);
            }
        }
        function xg(){
        	document.getElementById("t1").style.display="none";
        	document.getElementById("t2").style.display="block";
        	setGkbm();
        	//alert("ok");
        }
        function hf(){
        	document.getElementById("t1").style.display="block";
        	document.getElementById("t2").style.display="none";
        }
        function setGkbm(){
        	var gkbm=form1.bm.value;
        	if(gkbm!="select")
        	{
        		var select=document.getElementById("gk");
        		var options=select.options;
        		
        		for(var i=0;i<options.length;i++)
        		{
        			if(options[i].value==gkbm)
        			{
        				select.options[i].selected = true; 
        				break;
        			}
        		}
        	}
        }
        </script>
        
	</head>
	<body >
	
 <jsp:useBean id="db" class="bean.DBBean" scope="page" />
 <%
    String username=(String)session.getAttribute("username");
%>
 <div id="t1" style="margin-left:10px;">
 <% 
 	String sql="select * from userInfo where username='"+username+"'";
	ResultSet rs=db.executeQuery(sql);
	if(rs.next())
	{
 %>
    	<table frame="border" rules="all" width="80%">
                   <tr >
                        <td width=30%>&nbsp;机构代码</td>
                        <td >&nbsp;
                        	<%=rs.getString(3)%>
                        </td>
                    </tr>
                    <tr>
                        <td >&nbsp;机构名称</td>
                        <td >&nbsp;
                        	<%=rs.getString(4)%>
                        </td>
                    </tr>
                    <tr>
                     	<td >&nbsp;归口管理部门</td>
                    	<td >&nbsp;
                    	<%
                    	if(!rs.getString(5).equals("select"))
                    		out.print(rs.getString(5).substring(3));
                    	%>
                   	 	</td>
                    </tr>
                    <tr>
                        <td >&nbsp;通讯地址</td>
                        <td >&nbsp;
                        	<%=rs.getString(6)%>
                        </td>
                    </tr>
                    <tr>
                        <td >&nbsp;单位网址</td>
                        <td >&nbsp;
                        <%=rs.getString(7)%>
                        </td>
                    </tr>
                    <tr>
                        <td >&nbsp;电子信箱</td>
                        <td >&nbsp;
                        	<%=rs.getString(8)%>
                        </td>
                    </tr>
                    <tr>
                        <td >&nbsp;法人代表</td>
                        <td >&nbsp;
                        <%=rs.getString(9)%></td>
                    </tr>
                    <tr>
                        <td >&nbsp;邮政编码</td>
                        <td >&nbsp;
                        <%=rs.getString(10)%></td>
                    </tr>
                    <tr>
                        <td >&nbsp;联系人</td>
                        <td >&nbsp;
                        <%=rs.getString(11)%></td>
                    </tr>
                    <tr>
                        <td >&nbsp;固话</td>
                        <td >&nbsp;
                        	<%=rs.getString(12)%>
                        </td>
                    </tr>
                    <tr>
                        <td >&nbsp;手机</td>
                        <td >&nbsp;
                        	<%=rs.getString(13)%>
                        </td>
                    </tr>
                    <tr>
                        <td >&nbsp;传真</td>
                        <td >&nbsp;
                        <%=rs.getString(14)%></td>
                    </tr>
                    <tr></tr>
                </table>

            <%
            }
            %>
            <button id="xg" onclick="xg()" >修改</button>
    </div>
    
  <div id="t2" style="display:none;text-align:center;">
  <% 
 	sql="select * from userInfo where username='"+username+"'";
	rs=db.executeQuery(sql);
	if(rs.next())
	{
		String str[]=new String[15];
		for(int i=3;i<15;i++)
		{
			str[i]=rs.getString(i);
		}
 %>
  <form name="form1" action="yhxx2.jsp" method="post" onsubmit="return check()">
                <table >
                    <tr height="10px">
                        <td width=20%></td>
                        <td width=35%></td>
                        <td width=45%></td>
                    </tr>
                    <tr>
                        <td align='right'><font color="red">*</font>机构代码</td>
                        <td >
                        	<input type="text" name="jgdm" id="jgdm" class="inputcon" maxlength="20" value="<%=str[3]%>" readonly="true" style="border:none;background:none;"/>
                        </td>
                    </tr>
                    <tr>
                        <td align='right'><font color="red">*</font>机构全称</td>
                        <td >
                        	<input type="text" name="jgmc" id="jgmc" class="inputcon" maxlength="50" value="<%=str[4]%>">
                        </td>
                        <td align='left'>
                    		<font class="font1">填写完整名称,例:石家庄铁道大学</font>
                    	</td>
                    </tr>
                    <tr>
                     	<td align='right'>归口管理部门</td>
                    	<td>
                        	<select name="gkbm" id="gk"  class="inputcon">
                        	<option value="select">请选择</option>
                        		<%
                        		sql="select * from guikou$";
                        		rs = db.executeQuery(sql);
                    			while(rs.next())
                    			{
                    				if((rs.getString(1)+rs.getString(2)).equals(str[5]))
                    				{
                    					%>
                    					<option value="<%=rs.getString(1)+rs.getString(2)%>" selected="selected"><%=rs.getString(2) %></option>
                    					<%
                    					continue;
                    				}
                    				%>
                    				<option value="<%=rs.getString(1)+rs.getString(2)%>"><%=rs.getString(2) %></option>
                    				<%
                    			}
                        	%>
                        	</select>
                   	 	</td>
                    </tr>
                    <tr>
                        <td align='right'><font color="red">*</font>通讯地址</td>
                        <td >
                        	<input type="text" name="txdz" id="txdz" class="inputcon" maxlength="50" value="<%=str[6]%>">
                        </td>
                        <td align='left'>
                    		<font class="font1">通讯地址格式:省市县(区)到号,例:河北省石家庄市桥东区北二环东路17号</font>
                    	</td>
                    </tr>
                    <tr>
                        <td align='right'>单位网址</td>
                        <td >
                        <input type="text" name="dwwz" id="dwwz" class="inputcon" maxlength="255" value="<%=str[7]%>"></td>
                    </tr>
                    <tr>
                        <td align='right'><font color="red">*</font>电子信箱</td>
                        <td >
                        	<input type="text" name="dzxx" id="dzxx" class="inputcon" maxlength="50" onblur="emailcheck()" value="<%=str[8]%>">
                        </td>
                        <td align="left">
                        	<font class="font1">电子信箱格式如:123456789@qq.com</font>
                    	</td>
                    </tr>
                    <tr>
                        <td align='right'><font color="red">*</font>法人代表</td>
                        <td >
                        <input type="text" name="frdb" id="frdb" class="inputcon" maxlength="20" value="<%=str[9]%>"></td>
                    </tr>
                    <tr>
                        <td align='right'>邮政编码</td>
                        <td >
                        <input type="text" name="yzbm" id="yzbm" class="inputcon" maxlength="6" value="<%=str[10]%>" onblur="ybcheck()"></td>
                    </tr>
                    <tr>
                        <td align='right'><font color="red">*</font>联系人</td>
                        <td >
                        <input type="text" name="lxr" id="lxr" class="inputcon" maxlength="20" value="<%=str[11]%>"></td>
                    </tr>
                    <tr>
                        <td align='right'>固话</td>
                        <td >
                        	<input type="text" name="gh" id="gh" class="inputcon" maxlength="12" onblur="ghcheck()" value="<%=str[12]%>">
                        </td>
                        <td align="left">
							<font class="font1">固话格式:区号加号码,例:031187936524
							</font>
						</td>
                    </tr>
                    <tr>
                        <td align='right'><font color="red">*</font>手机</td>
                        <td >
                        	<input type="text" name="sj" id="sj" class="inputcon" maxlength="11" onblur="sjcheck()" value="<%=str[13]%>">
                        </td>
                        <td align="left">
                        <font class="font1">手机格式:11位,例:15226666666</font>
                        </td>
                    </tr>
                    <tr>
                        <td align='right'>传真</td>
                        <td >
                        <input type="text" name="cz" id="cz" class="inputcon" maxlength="12" value="<%=str[14]%>"></td>
                    </tr>
                    <tr height="10px">
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                        <input type="submit" name="submit" value="保存" class="sacan"><span style=" width:15px;;display: inline-block;"></span>
                        <input type="button" value="取消"  class="sacan" onclick="hf()"/>
                        </td>
                    </tr>
                    <tr height="15px">
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </form>
            <%
            }
            %>
        </div>
	</body>
	</html>