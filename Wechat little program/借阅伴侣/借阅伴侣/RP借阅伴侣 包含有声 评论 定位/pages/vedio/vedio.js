// pages/vedio/vedio.js
Page({
  data: {
    vediolist: null,
    tip: ''
  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数
    var that = this;
    console.log("信息：" + options.vedio);
    if (options.vedio == "") {
      that.setData({
        tip: '此书暂无有声读物~'
      })
    }
    console.log("tip：" + this.data.tip);
    wx.request({
      //http://mobile.ximalaya.com/mobile/playlist/album?albumId=238474&device=android&trackId=6047211
      //http://mobile.ximalaya.com/m/index_subjects
      url: 'https://mobile.ximalaya.com/mobile/playlist/album',
      data: {
        albumId: options.vedio,
        start: 0
      },
      method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function (res) {
        // success
        that.setData({
          vediolist: res.data
        })
      },
      fail: function (res) {
        // fail
      },
      complete: function (res) {
        // complete
      }
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
  }
})