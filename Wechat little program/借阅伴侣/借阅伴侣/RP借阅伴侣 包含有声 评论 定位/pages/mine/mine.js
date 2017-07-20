// pages/mine/mine.js
var app = getApp();
Page({
  data: {
    power: null,
    userID: null,
    showhidden0: "hidden",
    showhidden1: "show"
  },
  onLoad: function () {
    this.setData({
      power: app.globalData.power,
      userID: app.globalData.userID,
      showhidden0: app.globalData.mineSH0,
      showhidden1: app.globalData.mineSH1
    })
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    //console.log(app.globalData.mineSH0, app.globalData.mineSH1, app.globalData.userID, app.globalData.power);
    //console.log(this.data.showhidden0, this.data.showhidden1, this.data.userID, this.data.power);
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  btlogin: function () {
    var that = this;
    //重新授权
    wx.openSetting({
      success: function (res) {
        if (res) {
          if (res.authSetting["scope.userInfo"] == true) {
            wx.showModal({
              title: '提示',
              content: '由于网络原因，可能需要等待一会儿才能完成授权',
              showCancel: false,
              success: function (res) {
              }
            })
            app.login(function (globalData) {
              that.setData({
                power: globalData.power,
                userID: globalData.userID,
                showhidden0: globalData.mineSH0,
                showhidden1: globalData.mineSH1
              })
            });

          }
          else {
            console.log("没有选择授权")
          }
        }
      },
      fail: function () {
      }
    });
  },
  // 跳转
  ctapcollect: function () {
    wx.navigateTo({
      url: '../collect/collect',
      success: function (res) {
      },
      fail: function (res) {
      },
      complete: function (res) {
      }
    })
  },
  ctapborrow: function () {
    wx.navigateTo({
      url: '../borrow/borrow',
      success: function (res) {
      },
      fail: function (res) {
      },
      complete: function (res) {
      }
    })
  },
  ctapbooking: function () {
    wx.navigateTo({
      url: '../booking/booking',
      success: function (res) {
      },
      fail: function (res) {
      },
      complete: function (res) {
      }
    })
  },
  ctapqrcode: function () {
    wx.navigateTo({
      url: '../myqrcode/myqrcode',
      success: function (res) {
      },
      fail: function (res) {
      },
      complete: function (res) {
      }
    })
  },
  map: function () {
    console.log("点击")
    wx.navigateTo({
      url: '../map/map',
      success: function (res) {
      },
      fail: function (res) {
      },
      complete: function (res) {
      }
    })
  }
})