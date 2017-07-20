//学科分类*************************************************************************
//一级学科
function getYiji() {
	var code,title;
	$.post({
		url : "../ajax/xk_listYi",
		dataType: "json", 
		success : function(data) {
			code=data.code.split(" ");
			title=data.title.split(" ");
            for(var i=0;i<code.length-1;i++)
            {
            	$("#yiji").append("<li onclick=getErji('"+code[i]+"') ><span>"+title[i]+
            			"</span><ul id='"+code[i]+"'></ul></li>");
            }
            $("#yiji").treeview({
                persist: "location",
                collapsed: true,
                unique: true
             });
		},error:function(xhr){alert(xhr.responseText);}
	}); 
}
//二级学科
function getErji(yiji) {
	//调用函数 显示查询结果 传入yiji
	submit("subtype",yiji,"one");
	var code,title,id;
	id=yiji;
	code = yiji.substring(0,3);
	//console.log(id);
	var flag=document.getElementById(id).hasChildNodes();
	if(!flag){
		$.post({
			url : "../ajax/xk_listEr",
			data:{"code":code},
			dataType: "json", 
			success : function(data) {
				code=data.code.split(" ");
				title=data.title.split(" ");
	            for(var i=0;i<code.length-1;i++)
	            {
	            	$("#"+id).append("<li onclick=getSanji('"+code[i]+"') ><span>"+title[i]+
	            			"</span><ul id='"+code[i]+"'></ul></li>");
	            }
	            $("#"+id).treeview({
	                persist: "location",
	                collapsed: true,
	                unique: true
	             });
			},error:function(xhr){alert(xhr.responseText);}
		}); 
	}
	
}
//三级学科
function getSanji(erji) {
	//调用函数 显示查询结果 传入erji
	submit("subtype",erji,"two");
	var code,title,id;
	id=erji;
	code = erji.substring(0,5);
	//console.log(id);
	var flag=document.getElementById(id).hasChildNodes();
	if(!flag){
		$.post({
			url : "../ajax/xk_listSan",
			data:{"code":code},
			dataType: "json", 
			success : function(data) {
				code=data.code.split(" ");
				title=data.title.split(" ");
	            for(var i=0;i<code.length-1;i++)
	            {
	            	$("#"+id).append("<li onclick=submit('subtype','"+code[i]+"','three');>"+title[i]+"</li>");
	            }
			},error:function(xhr){alert(xhr.responseText);}
		}); 
	}
}

//国民经济行业分类*********************************************************************
//门类
function getMenlei(){
	var code,title;
	$.post({
		url : "../ajax/gm_listMen",
		dataType: "json", 
		success : function(data) {
			code=data.code.split(" ");
			title=data.title.split(" ");
            for(var i=0;i<code.length-1;i++)
            {
            	$("#menlei").append("<li onclick=getDalei('"+code[i]+"') ><span>"+title[i]+
            			"</span><ul id='"+code[i]+"'></ul></li>");
            }
            $("#menlei").treeview({
                persist: "location",
                collapsed: true,
                unique: true
             });
		},error:function(xhr){alert(xhr.responseText);}
	}); 
}
//大类
function getDalei(menlei) {
	submit("needindustry",menlei,"one");
	var code,title,id;
	id=menlei;
	code = menlei.substring(0,1);
	var flag=document.getElementById(id).hasChildNodes();
	if(!flag){
		$.post({
			url : "../ajax/gm_listDa",
			data:{"code":code},
			dataType: "json", 
			success : function(data) {
				code=data.code.split(" ");
				title=data.title.split(" ");
	            for(var i=0;i<code.length-1;i++)
	            {
	            	$("#"+id).append("<li onclick=getZhonglei('"+code[i]+"') ><span>"+title[i]+
	            			"</span><ul id='"+code[i]+"'></ul></li>");
	            }
	            $("#"+id).treeview({
	                persist: "location",
	                collapsed: true,
	                unique: true
	             });
			},error:function(xhr){alert(xhr.responseText);}
		}); 
	}
}
//中类
function getZhonglei(dalei) {
	submit("needindustry",dalei,"two");
	var code,title,id;
	id=dalei;
	code = dalei.substring(0,3);
	var flag=document.getElementById(id).hasChildNodes();
	if(!flag){
		$.post({
			url : "../ajax/gm_listZhong",
			data:{"code":code},
			dataType: "json", 
			success : function(data) {
				code=data.code.split(" ");
				title=data.title.split(" ");
	            for(var i=0;i<code.length-1;i++)
	            {
	            	$("#"+id).append("<li onclick=submit('needindustry','"+code[i]+"','three');>"+title[i]+"</li>");
	            }
			},error:function(xhr){alert(xhr.responseText);}
		}); 
	}
}
