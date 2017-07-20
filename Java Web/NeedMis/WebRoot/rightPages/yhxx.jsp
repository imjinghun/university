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
        	getGk();
        	//alert("ok");
        }
        function hf(){
        	document.getElementById("t1").style.display="block";
        	document.getElementById("t2").style.display="none";
        }
        
		function getGk() {
			//选择归口管理部门
			var code,title;
			$.post({
				url : "../ajax/gk_listGk",
				dataType: "json", 
				async:false,//使用同步 可以选中
				success : function(data) {
					code=data.code.split(" ");
					title=data.title.split(" ");
		
		            var select = document.getElementById("parentmgt");
		            select.options.add(new Option("","select"));
		            for(var i=0;i<code.length-1;i++)
		            {
		            	var temp=code[i]+title[i];
		            	select.options.add(new Option(title[i],code[i]+title[i]));
		            }
				},error:function(xhr){alert(xhr.responseText);}
			});
			//选中归口管理部门
			var gkglbm=document.getElementById("parentmgt1").value.toString();
			document.getElementById("parentmgt").value=gkglbm;
		}
        </script>
        
	</head>
	<body >
	
 <jsp:useBean id="db" class="bean.DBBean" scope="page" />
 <div id="t1" style="margin-left:10px;">
    	<table frame="border" rules="all" width="80%">
    	 			<tr >
                        <td width=30%>&nbsp;用户名</td>
                        <td >&nbsp;${user1.username}</td>
                    </tr>
                   <tr >
                        <td width=30%>&nbsp;机构代码</td>
                        <td >&nbsp;${user1.organcode}</td>
                    </tr>
                    <tr>
                        <td >&nbsp;机构名称</td>
                        <td >&nbsp;${user1.organname}</td>
                    </tr>
                    <tr>
                     	<td >&nbsp;归口管理部门</td>
                    	<td >&nbsp;${user1.parentmgt}</td>
                    </tr>
                    <tr>
                        <td >&nbsp;通讯地址</td>
                        <td >&nbsp;${user1.contactaddr}</td>
                    </tr>
                    <tr>
                        <td >&nbsp;单位网址</td>
                        <td >&nbsp;${user1.unitweb}</td>
                    </tr>
                    <tr>
                        <td >&nbsp;电子信箱</td>
                        <td >&nbsp;${user1.email}</td>
                    </tr>
                    <tr>
                        <td >&nbsp;法人代表</td>
                        <td >&nbsp;${user1.legalperson}</tr>
                    <tr>
                        <td >&nbsp;邮政编码</td>
                        <td >&nbsp;${user1.postcode}</tr>
                    <tr>
                        <td >&nbsp;联系人</td>
                        <td >&nbsp;${user1.contacts}</td>
                    </tr>
                    <tr>
                        <td >&nbsp;固话</td>
                        <td >&nbsp;${user1.tel}</td>
                    </tr>
                    <tr>
                        <td >&nbsp;手机</td>
                        <td >&nbsp;${user1.phone}</td>
                    </tr>
                    <tr>
                        <td >&nbsp;传真</td>
                        <td >&nbsp;${user1.fax}</td>
                    </tr>
                    <tr></tr>
                </table>
            <button id="xg" onclick="xg()" >修改</button>
    </div>
    
  <div id="t2" style="display:none;text-align:center;">
		<form name="form1" action="user_updateUser" method="post"
			onsubmit="return check()">
			<input type="hidden" name="username" value="${user1.username}" />
			<input type="hidden" name="password" value="${user1.password}" />
			<input type="hidden" name="powers" value="${user1.powers}" />
			<table>
				<tr height="35px">
					<td align='right'><font color="red">*</font>机构代码</td>
					<td><input type="text" name="organcode" id="organcode" value="${user1.organcode}"
						class="inputcon" maxlength="20"></td>
				</tr>
				<tr height="35px">
					<td align='right'><font color="red">*</font>机构全称</td>
					<td><input type="text" name="organname" id="organname" value="${user1.organname}"
						class="inputcon" maxlength="50"></td>
					<td align='left'><font class="font1">填写完整名称,例:石家庄铁道大学</font></td>
				</tr>
				<tr>
					<td align='right'>归口管理部门</td>
					<td>
					<input type="hidden" name="parentmgt1" id="parentmgt1" value="${user1.parentmgt}"/>
					<select name="parentmgt" id="parentmgt" class="inputcon">
							<%-- <option value="${user1.parentmgt}">${user1.parentmgt}</option>
							<%
                        		String sql="select * from guikou$";
                        		ResultSet rs = db.executeQuery(sql);
                    			while(rs.next())
                    			{
                    			%>
							<option value="<%=rs.getString(1)+rs.getString(2)%>"><%=rs.getString(2) %></option>
							<%
                    			}
                        		%> --%>
					</select></td>
				</tr>
				<tr height="35px">
					<td align='right'><font color="red">*</font>通讯地址</td>
					<td><input type="text" name="contactaddr" id="contactaddr" value="${user1.contactaddr}"
						class="inputcon" maxlength="50"></td>
					<td align="left"><font class="font1">通讯地址格式:省市县(区)到号,例:河北省石家庄市桥东区北二环东路17号</font>
					</td>
				</tr>
				<tr height="35px">
					<td align='right'>单位网址</td>
					<td><input type="text" name="unitweb" id="unitweb" value="${user1.unitweb}"
						class="inputcon" maxlength="255">
					</td>
				</tr>
				<tr height="35px">
					<td align='right'><font color="red">*</font>电子信箱</td>
					<td><input type="text" name="email" id="email" value="${user1.email}"
						class="inputcon" maxlength="50" onblur="emailcheck()"></td>
					<td align="left"><font class="font1">电子信箱格式如:123456789@qq.com</font>
					</td>
				</tr>
				<tr height="35px">
					<td align='right'><font color="red">*</font>法人代表</td>
					<td><input type="text" name="legalperson" id="legalperson" value="${user1.legalperson}"
						class="inputcon" maxlength="20">
					</td>
				</tr>
				<tr height="35px">
					<td align='right'>邮政编码</td>
					<td><input type="text" name="postcode" id="postcode" value="${user1.postcode}"
						class="inputcon" maxlength="6" onblur="ybcheck()">
					</td>
				</tr>
				<tr height="35px">
					<td align='right'><font color="red">*</font>联系人</td>
					<td><input type="text" name="contacts" id="contacts" value="${user1.contacts}"
						class="inputcon" maxlength="20">
					</td>
				</tr>
				<tr height="35px">
					<td align='right'>固话</td>
					<td><input type="text" name="tel" id="tel" class="inputcon" value="${user1.tel}"
						maxlength="12" onblur="ghcheck()"></td>
					<td align="left"><font class="font1">固话格式:区号加号码,例:031187936524</font>
					</td>
				</tr>
				<tr height="35px">
					<td align='right'><font color="red">*</font>手机</td>
					<td><input type="text" name="phone" id="phone" value="${user1.phone}"
						class="inputcon" maxlength="11" onblur="sjcheck()"></td>
					<td align="left"><font class="font1">手机格式:11位,例:15226666666</font>
					</td>
				</tr>
				<tr height="35px">
					<td align='right'>传真</td>
					<td><input type="text" name="fax" id="fax" class="inputcon" value="${user1.fax}"
						maxlength="12">
					</td>
				</tr>
				<tr height="10px">
					<td></td>
					<td></td>
				</tr>
				<tr height="15px">
					<td colspan="2" align="center"><input type="submit"
						name="submit" value="保存" class="sacan"><span
						style=" width:15px;;display: inline-block;"></span> <input
						type="button" value="取消" class="sacan" onclick="hf()" />
					</td>
				</tr>
				<tr height="15px">
					<td></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
	</body>
	</html>