window.onload=function(){
	//文档加载完毕之后 声明全局变量
		var username=document.getElementById("username");
		var password=document.getElementById("password");
		var alertlogin=document.getElementById("alertlogin");
	};
	
	//提交时检测
	function submitcheck()
	{
		var uname=username.value.toString().trim();
		var pwd=password.value.toString().trim();
		if(inputCheck())
		{
			alertlogin.innerText="登录中...";
			var cs="username="+uname+"&password="+pwd;
			loadAjax2(cs);
		}
	}
	function loadAjax2(cs) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var result=xmlhttp.responseText.split(" ");
			
				if(result[0]=="nouname")
				{
					alertlogin.innerText="用户不存在，请注册使用";
					username.focus();
				}
				if(result[0]=="nopwd")
				{
					alertlogin.innerText="密码错误，请重输";
					password.focus();
				}
				if(result[0]=="ok")
				{
					if(result[1]=="student")
					{
						window.location.href="./Course/stdIndex.jsp";
					}
					if(result[1]=="teacher")
					{
						window.location.href="./Course/tecIndex.jsp";
					}
					if(result[1]=="administrator")
					{
						window.location.href="./UserMgt/index.jsp";
					}
				}
			}
		};
		
		xmlhttp.open("POST", "servlet/Login", true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send(cs);
	}
	
	function inputCheck()
	{
		var uname=username.value.toString().trim();
		var pwd=password.value.toString().trim();
		if(uname=="")
		{
			alertlogin.innerText="用户名不可为空";
			return false;
		}
		if(pwd=="")
		{
			alertlogin.innerText="密码不可为空";
			return false;
		}
		return true;
	}
	
	$(function(){
		$("#submit").click(function(){submitcheck();});
		$("#username").focus(function(){
			$(this).css("background-color","rgba(63, 216, 204, 0.3)");
		});
		$("#password").focus(function(){
			$(this).css("background-color","rgba(63, 216, 204, 0.3)");
		});
		$("#username").blur(function(){
			$(this).css("background-color","rgba(202, 202, 202, 0.5)");
		});
		$("#password").blur(function(){
			$(this).css("background-color","rgba(202, 202, 202, 0.5)");
		});
	});