//退出系统
	function quit(){
	layer.confirm('确认退出系统？',{icon: 3,title:'注意'},function(){
			window.location="quit.jsp";
		});
	}
	//修改密码
	function revisePwd(){
		layer.open({
		  title:'修改密码',
	  	  type: 2,
		  area: ['400px', '300px'],
		  fixed: false, //不固定
		  offset:'t',
		  scrollbar:false,
		  content: './revisepwd.jsp'
		});
	}