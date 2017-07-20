$(document).ready(function(){
	$("#shuaxin").click(function (){
		$("#shuaxin").attr("src","images/login/randCode.jsp?"+Math.random());
	});
});