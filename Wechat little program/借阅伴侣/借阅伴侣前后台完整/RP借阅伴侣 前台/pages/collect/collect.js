var common = require('../../utils/util.js');
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
    wx.request({
      url: 'http://localhost:8080/WXXCX/servlet/QueryCollect',
      data: {
        'userid': "111111" //@@@@@@@@@@@@@@@@@@@@@@@@@@
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
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  ctapnav: function (e) {
    var obj = e.currentTarget.dataset.content;
    var str = JSON.stringify(obj);
    wx.navigateTo({
      url: '../collectdetail/collectdetail?item=' + str,
      success: function (res) {
      },
      fail: function (res) {
      },
      complete: function (res) {
      }
    })
  },
  ctapcancel: function (e) {
    var isbn = e.currentTarget.dataset.isbn;
    // var power = app.globalData.power; @@@@@@@@@@@@
    var power = true;
    if (power) {
      // var userid = app.globalData.userID; @@@@@@@@@@@@
      var userid = "111111"; // @@@@@@@@@@@@

      //取消收藏
      common.cancelcollect(userid, isbn);
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