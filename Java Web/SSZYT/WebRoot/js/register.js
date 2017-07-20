var username = "", password = "", password2 = "", identity = "", sno = "", name = "", school = "";
	$(function() {
		$("#xuehao").hide();

		$("#student").click(function() {
			$("#xuehao").show();
		});
		$("#teacher").click(function() {
			$("#xuehao").hide();
			$("#sno").val("");
		});
		//输入框聚焦时
		$("#username").focus(function(){
			$(this).css("background-color","rgba(63, 216, 204, 0.3)");
		});
		$("#password").focus(function(){
			$(this).css("background-color","rgba(63, 216, 204, 0.3)");
		});
		$("#password2").focus(function(){
			$(this).css("background-color","rgba(63, 216, 204, 0.3)");
		});
		$("#sno").focus(function(){
			$(this).css("background-color","rgba(63, 216, 204, 0.3)");
		});
		$("#name").focus(function(){
			$(this).css("background-color","rgba(63, 216, 204, 0.3)");
		});
		$("#school").focus(function(){
			$(this).css("background-color","rgba(63, 216, 204, 0.3)");
		});
		//输入框内容改变时
		$("#username").blur(function() {
			username = $.trim($("#username").val());
			$(this).css("background-color","rgba(202, 202, 202, 0.5)");
			if (username == "") {
				$("#alertregister").text("用户名不可为空");
			} else if (username.length > 20 || username.length < 6) {
				$("#alertregister").text("用户名格式不正确");
				return false;
			} else {
				$("#alertregister").text("");
			}
		});
		$("#password").blur(function() {
			password = $.trim($("#password").val());
			$(this).css("background-color","rgba(202, 202, 202, 0.5)");
			if (password == "") {
				$("#alertregister").text("密码不可为空");
				return false;
			} else if (password.length > 20 || password.length < 6) {
				$("#alertregister").text("密码格式不正确");
				return false;
			} else {
				$("#alertregister").text("");
			}
		});
		$("#password2").blur(function() {
			password2 = $.trim($("#password2").val());
			$(this).css("background-color","rgba(202, 202, 202, 0.5)");
			if (password2 == "") {
				$("#alertregister").text("确认密码不可为空");
				return false;
			} else if (password2 != password) {
				$("#alertregister").text("两次密码不一致");
				return false;
			} else {
				$("#alertregister").text("");
			}
		});
		$("#sno").blur(function() {
			sno = $.trim($("#sno").val());
			$(this).css("background-color","rgba(202, 202, 202, 0.5)");
			if (sno == "") {
				$("#alertregister").text("学号不可为空");
			} else {
				$("#alertregister").text("");
			}
		});
		$("#name").blur(function() {
			name = $.trim($("#name").val());
			$(this).css("background-color","rgba(202, 202, 202, 0.5)");
			if (name == "") {
				$("#alertregister").text("姓名不可为空");
			} else {
				$("#alertregister").text("");
			}
		});
		$("#school").blur(function() {
			school = $.trim($("#school").val());
			$(this).css("background-color","rgba(202, 202, 202, 0.5)");
			if (school == "") {
				$("#alertregister").text("学校不可为空");
			} else {
				$("#alertregister").text("");
			}
		});
		//提交前验证
		$("#submit").click(function() {
			if (inputCheck()) {
				$.ajax({
					type : "post",
					url : "servlet/Register",
					dataType : "text",
					async : true,
					data : {
						"username" : username,
						"password" : password,
						"identity" : identity,
						"sno" : sno,
						"name" : name,
						"school" : school
					},
					success : function(value) {

						if (value == "success") {
							layer.msg('注册成功，马上登录', {icon:6});
							setTimeout(function(){window.location.href = "login.jsp";},1000);
						} else if (value == "exist") {
							$("#username").focus();
							$("#alertregister").text("用户已存在");
						} else {
							layer.alert('抱歉，注册失败',{icon:5});
						}
					}
				});
			}
		});

	});

	function inputCheck() {
		username = $.trim($("#username").val());
		password = $.trim($("#password").val());
		password2 = $.trim($("#password2").val());
		identity = $("input:radio[name='identity']:checked").val();
		name = $.trim($("#name").val());
		school = $.trim($("#school").val());
		if (username == "") {
			$("#username").focus();
			$("#alertregister").text("用户名不可为空");
			return false;
		}
		if (username.length > 20 || username.length < 6) {
			$("#username").focus();
			$("#alertregister").text("用户名格式不正确");
			return false;
		}
		if (password == "") {
			$("#password").focus();
			$("#alertregister").text("密码不可为空");
			return false;
		}
		if (password.length > 20 || password.length < 6) {
			$("#password").focus();
			$("#alertregister").text("密码格式不正确");
			return false;
		}
		if (password2 == "") {
			$("#password2").focus();
			$("#alertregister").text("确认密码不可为空");
			return false;
		}
		if (password2 != password) {
			$("#password2").focus();
			$("#alertregister").text("两次密码不一致");
			return false;
		}
		if (identity == null) {
			$("#alertregister").text("请选择身份");
			return false;
		}
		if (identity == "学生") {
			sno = $.trim($("#sno").val());
			if (sno == "") {
				$("#sno").focus();
				$("#alertregister").text("学号不可为空");
				return false;
			}
		}
		if (name == "") {
			$("#name").focus();
			$("#alertregister").text("姓名不可为空");
			return false;
		}
		if (school == "") {
			$("#school").focus();
			$("#alertregister").text("学校不可为空");
			return false;
		}
		$("#alertregister").text("");
		return true;
	}