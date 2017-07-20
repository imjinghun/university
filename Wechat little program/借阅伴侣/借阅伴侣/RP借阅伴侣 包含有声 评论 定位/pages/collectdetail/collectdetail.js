//根据isbn获取图书详情
var common = require('../../utils/util.js');
var app = getApp();
Page({
  data: {
    bookdetail: null
  },
  onLoad: function (options) {
    var item = JSON.parse(options.item);
    this.setData({
      bookdetail: item
    })
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
  // 事件 ************************************
  //收藏
  ctapCollect: function (e) {
    var power = app.globalData.power;
    if (power) {
      var userid = app.globalData.userID;
      var isbn = this.data.bookdetail.isbn;

      //取消收藏
      common.cancelcollect(userid, isbn);

    }
    else {
      wx.showModal({
        title: '提示',
        content: '您没有接受授权，无法享用此服务',
        showCancel: false,
        success: function (res) {
        }
      })
    }
  }
})