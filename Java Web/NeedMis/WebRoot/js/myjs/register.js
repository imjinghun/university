window.onload=function(){getGk();document.getElementById("username").focus();};
function getGk() {
	//选择归口管理部门
	var code,title;
	$.post({
		url : "../ajax/gk_listGk",
		dataType: "json", 
		//async:false,//使用同步 可以选中
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
}
function check() {
			var exist=document.getElementById("unamecheck").innerText;
			if(exist=="用户已存在")
            {
            	form1.username.focus();
                layer.msg('用户已存在',{time:1200});
                return false;
            }
                if (form1.username.value.trim() == "") {
                	
                	layer.msg('用户名不能为空',{time:1200});
                	form1.username.focus();
                    return false;
                }
                if (form1.username.value.trim().length<6) {
                    form1.username.focus();
                    layer.msg('用户名长度不能低于6位',{time:1200});
                    return false;
                }
                if (form1.password.value.trim() == "") {
                    form1.password.focus();
                    layer.msg('密码不能为空',{time:1200});
                    return false;
                }
                if (form1.password.value.trim().length<6) {
                    form1.password.focus();
                    layer.msg('密码长度不能低于6位',{time:1200});
                    return false;
                }
                if (form1.password.value.trim() == "") {
                    form1.password.focus();
                    layer.msg('确认密码不能为空',{time:1200});
                    return false;
                }
                if (form1.password1.value.trim() != form1.password.value.trim()) {
                    form1.password1.focus();
                    layer.msg('两次密码不一致',{time:1200});
                  
                    return false;
                }
                if(form1.organcode.value.trim()=="")
                {
                	form1.organcode.focus();
                	layer.msg('机构代码不可为空',{time:1200});
      
                    return false;
                }
                if(form1.organname.value.trim()=="")
                {
                	form1.organname.focus();
                	layer.msg('机构全称不可为空',{time:1200});
                
                    return false;
                }
                if(form1.contactaddr.value.trim()=="")
                {
                	form1.contactaddr.focus();
                	layer.msg('通讯地址不可为空',{time:1200});
                 
                    return false;
                }
                if(form1.email.value.trim()=="")
                {
                	form1.email.focus();
                	layer.msg('电子信箱不可为空',{time:1200});
             
                    return false;
                }
                if(!emailcheck())
    			{
    				form1.email.focus();
    				layer.msg('电子信箱格式错误',{time:1200});
    	
    				return false;
    			}
                if(form1.legalperson.value.trim()=="")
                {
                	form1.legalperson.focus();
                	layer.msg('法人代表不可为空',{time:1200});
                  
                    return false;
                }
                if(!ybcheck())
                {
                	return false;
                }
                if(form1.contacts.value.trim()=="")
                {
                	form1.contacts.focus();
                	layer.msg('联系人不可为空',{time:1200});
          
                    return false;
                }
                if(!ghcheck())
                {
                	return false;
                }
                if(form1.phone.value.trim()=="")
                {
                	form1.phone.focus();
                	layer.msg('手机不可为空',{time:1200});
              
                    return false;
                }
                if(!sjcheck())
    			{
    				form1.phone.focus();
    				layer.msg('手机格式错误',{time:1200});
    		
    				return false;
    			}
                return true;
            }
		function emailcheck()
		{
			//电子信箱 
			var re=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			var result=re.test(form1.email.value.trim());
			if(!result)
			{
				form1.email.focus();
				layer.msg('电子信箱格式错误',{time:1200});
				return false;
			}
			return true;
		}
		function ghcheck()
		{
			//固话 至少11位数字
			re=/^\d{11,}$/;
			if(form1.tel.value.trim()!="")
			{
				result=re.test(form1.tel.value.trim());
				if(!result)
				{
					form1.tel.focus();
					layer.msg('固话格式错误',{time:1200});
				
					return false;
				}
			}
			return true;
		}
		function ybcheck()
	    {
	    	//邮编6位
			re=/^\d{6}$/;
			if(form1.postcode.value.trim()!="")
			{
				result=re.test(form1.postcode.value.trim());
				if(!result)
				{
					layer.msg('邮编格式错误',{time:1200});
					form1.postcode.focus();
					return false;
				}
			}
			return true;
	    }
		function sjcheck()
		{
			//手机号 11位
			re=/^\d{11}$/;
			result=re.test(form1.phone.value.trim());
			if(!result)
			{
				form1.phone.focus();
				layer.msg('手机格式错误',{time:1200});
		
				return false;
			}
			return true;
		}