
Page({
  data: {
    details: [],
    hidden: true //loading 隐藏
  },
  onLoad: function (options) {
    this.setData({
      hidden: false
    })
    var that = this;
    var detail = new Array();
    wx.request({
      url: 'https://api.tngou.net/book/show',
      data: {
        id: options.id
      },
      method: 'GET',
      success: function (res) {
        console.log("图书详情调用成功");
        var listlength = res.data.list.length;
        var j = listlength;
        for (var i = 0; i < listlength; i++) {
          j--;
          detail[i] = res.data.list[j];
        }
        that.setData({
          details: detail,
          hidden: true
        })
        //异步缓存 将图书详情缓存
        wx.setStorage({
          key: 'bookdetail',
          data: that.data.details,
          success: function (res) {
            console.log("图书详情缓存成功");
          },
          fail: function (res) {
          },
          complete: function (res) {
          }
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
        console.log("图书详情调用失败");
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