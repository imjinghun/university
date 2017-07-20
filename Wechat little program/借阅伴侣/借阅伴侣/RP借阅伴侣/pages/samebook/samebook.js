//var common = require('../../utils/util.js');
//确定请求URL
var app = getApp();
var url = 'https://api.tngou.net/book/list';
//请求数据
var requestData = function (that) {
  wx.request({
    url: url,
    data: {
      id: that.data.id,
      rows: 10,
      page: that.data.page
    },
    method: 'GET',
    success: function (res) {
      console.log("同类图书列表调用成功");
      //获取已有的图书列表信息
      var booklisttemp = that.data.booklist;
      //追加新的图书列表信息
      for (var i = 0; i < res.data.list.length; i++) {
        booklisttemp.push(res.data.list[i]);
      }
      //重设图书列表信息 并且设置loading隐藏
      that.setData({
        booklist: booklisttemp,
        hidden: true
      })
    },
    fail: function (res) {
      that.setData({
        hidden: true
      })
      wx.showToast({
        title: '加载失败，请返回重试',
        icon: 'loading',
        duration: 1500
      })
      console.log("同类图书列表调用失败");
    },
    complete: function (res) {
      //隐藏导航条加载动画
      wx.hideNavigationBarLoading()
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
    wx.showNavigationBarLoading();
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
    wx.showNavigationBarLoading();
    //页面+1
    this.setData({
      page: this.data.page + 1,
      hidden: false
    })
    var that = this;
    requestData(that);
  },
  //收藏
  ctapCollect: function (e) {
    /*不用
    // var power = app.globalData.power; @@@@@@@@@@@@@@@@@@@
    var power = true;
    var obj = e.currentTarget.dataset.content;
    console.log(power, obj);
    if (power) {
      //  var userid = app.globalData.userID;  @@@@@@@@@@@@
      var isbn = obj.id;
      var name = obj.name;
      var author = obj.author;
      var image = 'http://tnfs.tngou.net/img' + obj.img;
      var summary = obj.summary;
      obj.userid = "111111"; // @@@@@@@@@@@@ 
      obj.isbn10 = isbn;
      obj.title = name;
      obj.catalog = "";
      obj.publisher = "";
      obj.author_intro = "";
      obj.image = image;
      //收藏方法 提示收藏成功
      console.log(userid, isbn, name, author, image, summary);
      common.collect(obj);
    }
    else {
      wx.showModal({
        title: '提示',
        content: '您没有接受授权，无法享用此服务',
        showCancel: false,
        success: function (res) {
        }
      })
    }*/
  },
  //借阅
  ctapBorrow: function (e) {
   /*  不用
   // var power = app.globalData.power; @@@@@@@@@@@@@@@@@@@
    var power = true;
    var obj = e.currentTarget.dataset.content;
    console.log(power, obj);
    if (power) {
      //  var userid = app.globalData.userID;  @@@@@@@@@@@@
      var isbn = obj.id;
      var name = obj.name;
      var author = obj.author;
      obj.userid = "111111"; //@@@@@@@@@@@@
      obj.isbn10 = isbn;
      obj.title = name;
      //借阅方法 付款 最多两本
      console.log(userid, isbn, name, author);
      common.borrow(obj);
    }
    else {
      wx.showModal({
        title: '提示',
        content: '您没有接受授权，无法享用此服务',
        showCancel: false,
        success: function (res) {
        }
      })
    }*/
  }
})