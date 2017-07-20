
Page({
  data: {
    hidden: false,
    bookdetail: null
  },
  onLoad: function (options) {
   // console.log(options.id);
    var that = this;
    wx.request({
      url: 'https://api.douban.com/v2/book/' + options.id,
      data: {},
      method: 'GET',
      success: function (res) {
        that.setData({
          hidden: true,
          bookdetail: res.data
        });
       // console.log(res.data);
      },
      fail: function (res) {
        that.setData({
          hidden: true
        });
        wx.showToast({
          title: '加载失败，请返回重试',
          icon: 'loading',
          duration: 1500
        })
      },
      complete: function (res) {
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