var common = require('../../utils/util.js');
var app = getApp();
Page({
  data: {
    booklist: [], //返回列表
  },
  onLoad: function (options) {
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    var that = this;
    var power = app.globalData.power;
    if (power) {
      var userid = app.globalData.userID;
      wx.request({
        url: 'https://www.team539.cn/WX/servlet/QueryBorrow',
        data: {
          'userid': userid
        },
        header: { 'content-type': 'application/x-www-form-urlencoded' },
        method: 'POST',
        success: function (res) {
          that.setData({
            booklist: res.data.list
          })
        },
        fail: function (res) {
          console.log(res)
        },
        complete: function (res) {
        }
      })
    }

  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  ctapcancel: function (e) {
    var isbn = e.currentTarget.dataset.isbn;
    var power = app.globalData.power;
    //用户已登录 power为true
    if (power) {
      var userid = app.globalData.userID;
      common.cancelborrow(userid, isbn);
      this.onShow();
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