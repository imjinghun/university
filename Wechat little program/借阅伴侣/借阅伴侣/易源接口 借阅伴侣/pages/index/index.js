//index.js
//获取应用实例
var app = getApp()
Page({
  data: {
    bookclass: [{
      "id": "1",
      "name": "孕妇育儿"
    },
    {
      "id": "2",
      "name": "美容时尚"
    },
    {
      "id": "3",
      "name": "健康养生"
    },
    {
      "id": "4",
      "name": "两性生活"
    },
    {
      "id": "5",
      "name": "美食烹饪"
    },
    {
      "id": "6",
      "name": "修养心里"
    },
    {
      "id": "7",
      "name": "家庭教育"
    },
    {
      "id": "8",
      "name": "幽默笑话"
    },
    {
      "id": "9",
      "name": "生活杂谈"
    },
    {
      "id": "10",
      "name": "其它"
    }],
    searchkey:null
  },
  onLoad: function () {
   /* var that = this;
    wx.request({
      url: 'https://route.showapi.com/92-93',
      //当data为空时 应写下方 
      //url:'https://route.showapi.com/92-93?showapi_appid=36348&showapi_sign=2a69af77c2e743bb88368847a63d6698&id=224'
      data: {
        showapi_appid: "36348",
        showapi_sign: "2a69af77c2e743bb88368847a63d6698"
      },
      method: 'GET',//使用这个接口 必须用GET
      header: { 'content-type': 'application/json' },
      success: function (res) {
        var bc=res.data.showapi_res_body.bookClass;
        for(var i=0;i<bc.length;i++)
        {
          bc[i].name=bc[i].name.replace("图书","");
          // bc[i].name=bc[i].name.toString().substring(0,bc[i].name.toString().length-1);
        }
        console.log("成功" + res.data.showapi_res_code);
        that.setData({
          bookclass:bc
        })
      },
      fail: function (res) {
        console.log("失败" + res.data.showapi_res_code);
      },
      complete: function (res) {
        console.log("完成" + res.data.showapi_res_code);
      }
    })*/
  },
  //事件处理函数  *************************************
  inputsearch:function(e){
    this.setData({
      searchkey:e.detail.value
    });
  },
  //点击搜索按钮
  ctapsearch: function () {
    //输入为空返回
    if(!this.data.searchkey)
    {
      return;
    }
    wx.navigateTo({
      url: '../search/search?searchkey='+this.data.searchkey,
      success: function (res) {
        // success
      },
      fail: function (res) {
        // fail
      },
      complete: function (res) {
        // complete
      }
    })
  }
})
