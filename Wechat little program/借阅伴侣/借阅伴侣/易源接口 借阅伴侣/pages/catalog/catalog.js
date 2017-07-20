
Page({
  data: {
    idfirst: "",//第一个页面id
    idlast: "",//最后一个页面id
    details: [],//书籍详情
    hidden: true //loading 隐藏
  },
  onLoad: function (options) {
    this.setData({
      hidden: false
    })
    var that = this;
    var detail = new Array();
    wx.request({
      url: 'https://route.showapi.com/92-91',
      data: {
        showapi_appid: "36348",
        showapi_sign: "2a69af77c2e743bb88368847a63d6698",
        id: options.id
      },
      method: 'GET',
      success: function (res) {
        console.log("图书详情调用成功");
        var list = res.data.showapi_res_body.bookDetails.list;
        that.setData({
          idfirst: list[0].id,//第一个页面id
          idlast: list[list.length - 1].id,//最后一个页面id
          details: list,
          hidden: true
        })
      },
      fail: function (res) {
        console.log("图书详情调用失败");
        that.setData({
          hidden: true
        })
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