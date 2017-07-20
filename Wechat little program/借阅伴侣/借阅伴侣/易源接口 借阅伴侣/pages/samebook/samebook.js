/*//引入html标签转换插件
var WxParse = require('../../wxParse/wxParse.js');
*/
//确定请求URL
var url = 'https://route.showapi.com/92-92';
//请求数据
var requestData = function (that) {
  wx.request({
    url: url,
    data: {
      showapi_appid: "36348",
      showapi_sign: "2a69af77c2e743bb88368847a63d6698",
      id: that.data.id,
      limit: 10,
      page: that.data.page
    },
    method: 'GET',
    success: function (res) {
      console.log("同类图书列表调用成功");
      //获取接口返回值
      var bookList = res.data.showapi_res_body.bookList;
      //获取已有的图书列表信息
      var booklisttemp = that.data.booklist;
      //追加新的图书列表信息
      for (var i = 0; i < bookList.length; i++) {
        booklisttemp.push(bookList[i]);
      }
      //重设图书列表信息 设置loading隐藏
      that.setData({
        booklist: booklisttemp,
        hidden: true
      })
    },
    fail: function (res) {
      console.log("同类图书列表调用失败");
      that.setData({
        hidden: true
      })
      wx.showToast({
        title: '加载失败，请返回重试',
        icon: 'loading',
        duration: 1500
      })
    },
    complete: function (res) {
    }
  })
}

Page({
  data: {
    id: "", //图书分类id
    bookclass: "", //图书分类名称
    booklist: [], //同类图书列表
    page: 1, //每次请求页数
    hidden: true //loading 隐藏
  },
  onLoad: function (options) {
    //在当前页面显示导航条加载动画
    // wx.showNavigationBarLoading();
    // console.log("页面load,请求第 " + this.data.page+" 页");
    //获取图书分类id name
    this.setData({
      id: options.id,
      bookclass: options.name,
      hidden: false
    })
    var that = this;
    requestData(that);
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    // 页面显示
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  //事件********************************************
  //scroll-view 上拉加载
  pullUpLoad: function () {
    //在当前页面显示导航条加载动画
    // wx.showNavigationBarLoading();
    //页面+1
    this.setData({
      page: this.data.page + 1,
      hidden: false
    })
    //console.log("上拉加载,请求第 " + this.data.page + " 页");
    var that = this;
    requestData(that);
  }
})