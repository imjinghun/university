// pages/booking/booking.js
var app = getApp();
Page({
  data: {
    showhidden: "hidden",
    booklist: null
  },
  onLoad: function (options) {

    // 页面初始化 options为页面跳转所带来的参数
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    var that = this;
    var power = app.globalData.power;
    if (power) {
      var userid = app.globalData.userID;
      console.log("booking ",userid);
      wx.request({
        url: 'https://www.team539.cn/WX/servlet/QueryBooking',
        data: {
          'userid': userid
        },
        method: 'POST',
        header: { 'content-type': 'application/x-www-form-urlencoded' },
        success: function (res) {
          that.setData({
            booklist: res.data.list
          })
        },
        fail: function (res) {
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
  ctapbooking: function () {
    this.setData({
      showhidden: "show"
    })
  },
  ctaphidden: function () {
    this.setData({
      showhidden: "hidden"
    })
  },
  //预订
  formSubmit: function (e) {
    var that = this;
    var obj = e.detail.value;
    var userid = app.globalData.userID;
    if (obj.name == "" || obj.author == "") {
      wx.showToast({
        title: '不可有空值',
        image: '../../images/error.png',
        duration: 2000
      })
      return;
    }
    wx.request({
      url: 'https://www.team539.cn/WX/servlet/AddBooking',
      data: {
        'userid': userid,
        'name': obj.name,
        'author': obj.author
      },
      header: { 'content-type': 'application/x-www-form-urlencoded' },
      method: 'POST',
      success: function (res) {
        if (res.data == "success") {
          wx.showToast({
            title: '预订成功',
            icon: 'success',
            duration: 1500
          })
          obj.name = "";
          obj.author = "";
          that.onShow();
        }
        if (res.data == "1") {
          wx.showToast({
            title: '已经预订',
            icon: 'success',
            duration: 1500
          })
        }
      },
      fail: function (res) {
      },
      complete: function (res) {
      }
    })
  },
  //取消预订
  ctapcancel: function (e) {
    var obj = e.currentTarget.dataset.content;
    var that = this;
    var userid = app.globalData.userID;
    wx.request({
      url: 'https://www.team539.cn/WX/servlet/DelBooking',
      data: {
        'userid': userid,
        'name': obj.name,
        'author': obj.author
      },
      header: { 'content-type': 'application/x-www-form-urlencoded' },
      method: 'POST',
      success: function (res) {
        if (res.data == "success") {
          wx.showToast({
            title: '取消预订成功',
            icon: 'success',
            duration: 1500
          })
          that.onShow();
        }
      },
      fail: function (res) {
      },
      complete: function (res) {
      }
    })
  }

})