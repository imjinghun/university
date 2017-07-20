/*//归口管理部门
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
		},error:function(xhr){alert(xhr.responseText+"cu");}
	});
	//选中归口管理部门
	var gkglbm=document.getElementById("parentmgt1").value.toString();
	alert(gkglbm);
	document.getElementById("parentmgt").value=gkglbm;
}*/

//学科分类*************************************************************************
//一级学科
function getYiji() {
	var code,title;
	$.post({
		url : "./ajax/xk_listYi",
		dataType: "json", 
		success : function(data) {
			code=data.code.split(" ");
			title=data.title.split(" ");

            var select = document.getElementById("yiji");
            select.options.add(new Option("请选择","select"));
            for(var i=0;i<code.length-1;i++)
            {
            	select.options.add(new Option(title[i],code[i]+" "+title[i]));
            }
		},error:function(xhr){alert(xhr.responseText);}
	}); 
}
//二级学科
function getErji() {
	var code,title,yiji;
	yiji=document.getElementById("yiji").value;
	code = yiji.substring(0,3);
	$.post({
		url : "./ajax/xk_listEr",
		data:{"code":code},
		dataType: "json", 
		success : function(data) {
			code=data.code.split(" ");
			title=data.title.split(" ");

            var select = document.getElementById("erji");
          //清空原有内容
            document.getElementById("erji").innerHTML = "";
            document.getElementById("sanji").innerHTML = "";
            
            select.options.add(new Option("请选择","select"));
            for(var i=0;i<code.length-1;i++)
            {
            	select.options.add(new Option(title[i],code[i]+" "+title[i]));
            }
		},error:function(xhr){alert(xhr.responseText);}
	}); 
	//label显示一级学科代码
    if(yiji!="select"&&yiji!=""&&yiji!=null)
    {
    	document.getElementById("xkdm").innerHTML=yiji.substring(0,7);
    	document.getElementById("subtype").value=yiji;
    }
}
//三级学科
function getSanji() {
	var code,title,erji;
	erji=document.getElementById("erji").value;
	code = erji.substring(0,5);
	$.post({
		url : "./ajax/xk_listSan",
		data:{"code":code},
		dataType: "json", 
		success : function(data) {
			code=data.code.split(" ");
			title=data.title.split(" ");

            var select = document.getElementById("sanji");
          //清空option原有内容
            document.getElementById("sanji").innerHTML = "";
            
            select.options.add(new Option("请选择","select"));
            for(var i=0;i<code.length-1;i++)
            {
            	select.options.add(new Option(title[i],code[i]+" "+title[i]));
            }
		},error:function(xhr){alert(xhr.responseText);}
	}); 
    //label显示二级学科代码
    if(erji!="select"&&erji!=""&&erji!=null)
    {
    	document.getElementById("xkdm").innerHTML=erji.substring(0,7);
    	document.getElementById("subtype").value=erji;
    }
}

function setXkDm(){
	
	var sanji = document.getElementById("sanji").value;
    //label显示三级学科代码
	if(sanji!="select"&&sanji!=""&&sanji!=null)
    {
    	document.getElementById("xkdm").innerHTML=sanji.substring(0,7);
    	document.getElementById("subtype").value=sanji;
    }
}

//国民经济行业分类*********************************************************************
//门类
function getMenlei(){
	var code,title;
	$.post({
		url : "./ajax/gm_listMen",
		dataType: "json", 
		success : function(data) {
			code=data.code.split(" ");
			title=data.title.split(" ");

            var select = document.getElementById("menlei");
            select.options.add(new Option("请选择","select"));
            for(var i=0;i<code.length-1;i++)
            {
            	select.options.add(new Option(title[i],code[i]+" "+title[i]));
            }
		},error:function(xhr){alert(xhr.responseText);}
	}); 
}
//大类
function getDalei() {
	var code,title,menlei;
	menlei=document.getElementById("menlei").value;
	code = menlei.substring(0,1);
	$.post({
		url : "./ajax/gm_listDa",
		data:{"code":code},
		dataType: "json", 
		success : function(data) {
			code=data.code.split(" ");
			title=data.title.split(" ");

            var select = document.getElementById("dalei");
          //清空原有内容
            document.getElementById("dalei").innerHTML = "";
            document.getElementById("zhonglei").innerHTML = "";
            
            select.options.add(new Option("请选择","select"));
            for(var i=0;i<code.length-1;i++)
            {
            	select.options.add(new Option(title[i],code[i]+" "+title[i]));
            }
		},error:function(xhr){alert(xhr.responseText);}
	}); 
    //label显示门类代码
    if(menlei!="select"&&menlei!=""&&menlei!=null)
    {
    	document.getElementById("hydm").innerHTML=menlei.substring(0,5);
    	document.getElementById("needindustry").value=menlei;
    }
}
//中类
function getZhonglei() {
	var code,title,dalei;
	dalei=document.getElementById("dalei").value;
	code = dalei.substring(0,3);
	$.post({
		url : "./ajax/gm_listZhong",
		data:{"code":code},
		dataType: "json", 
		success : function(data) {
			code=data.code.split(" ");
			title=data.title.split(" ");

            var select = document.getElementById("zhonglei");
          //清空option原有内容
            document.getElementById("zhonglei").innerHTML = "";
            
            select.options.add(new Option("请选择","select"));
            for(var i=0;i<code.length-1;i++)
            {
            	select.options.add(new Option(title[i],code[i]+" "+title[i]));
            }
		},error:function(xhr){alert(xhr.responseText);}
	}); 
    
    //label显示大类代码
    if(dalei!="select"&&dalei!=""&&dalei!=null)
    {
    	document.getElementById("hydm").innerHTML=dalei.substring(0,5);
    	document.getElementById("needindustry").value=dalei;
    }
}
function setHyDm(){
	
	var zhonglei = document.getElementById("zhonglei").value;
    //label显示中类代码
	if(zhonglei!="select"&&zhonglei!=""&&zhonglei!=null)
    {
    	document.getElementById("hydm").innerHTML=zhonglei.substring(0,5);
    	document.getElementById("needindustry").value=zhonglei;
    }
}

