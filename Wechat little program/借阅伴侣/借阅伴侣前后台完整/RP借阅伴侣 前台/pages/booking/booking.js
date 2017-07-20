// pages/booking/booking.js
Page({
  data: {
    showhidden: "hidden",
    booklist: null
  },
  onLoad: function (options) {
    /*var a=[];
    for(var i=0;i<10;i++){
a[i]=i;    }
    this.setData({
      booklist:a
    })*/
    // 页面初始化 options为页面跳转所带来的参数
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/WXXCX/servlet/QueryBooking',
      data: {
        'userid': "111111"
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
    var that=this;
    var obj = e.detail.value;
    if (obj.name == "" || obj.author == "") {
      wx.showToast({
        title: '不可有空值',
        image: '../../images/error.png',
        duration: 2000
      })
      return;
    }
    wx.request({
      url: 'http://localhost:8080/WXXCX/servlet/AddBooking',
      data: {
        'userid': "111111",
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
          obj.name="";
          obj.author="";
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
    wx.request({
      url: 'http://localhost:8080/WXXCX/servlet/DelBooking',
      data: {
        'userid': "111111",
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