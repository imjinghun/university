var WxParse = require('../../wxParse/wxParse.js');

Page({
  data: {
    idfirst: "",//第一个页面id
    idlast: "",//最后一个页面id
    id: "",//当前页面id
    wxParseData: [], //页面显示
    hidden: true //loading 隐藏
  },
  onLoad: function (options) {
    var id = options.id;
    //获取传递的参数信息
    this.setData({
      idfirst: options.idfirst,
      idlast: options.idlast,
      id: id
    })
    var that = this;
    wx.request({
      url: 'https://route.showapi.com/92-32',
      data: {
        showapi_appid: "36348",
        showapi_sign: "2a69af77c2e743bb88368847a63d6698",
        id: id
      },
      method: 'GET',
      success: function (res) {
        console.log("图书页面详情调用成功");
        var message = res.data.showapi_res_body.bookDetails.message;
        that.setData({
          wxParseData: WxParse('html', message),
          hidden: true
        })
      },
      fail: function (res) {
        console.log("图书页面详情调用失败");
        that.setData({
          hidden: true
        })
        //调用失败 友好提示
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
  },
  // 事件********************************************
  // 点击上一页
  ctapbefore: function () {
    var idfirst = this.data.idfirst;
    var id = this.data.id;
    if (id == idfirst) {
      wx.showToast({
        title: '已到达第一页',
        icon: 'success',
        duration: 1000
      })
      return;
    }
    if (id > idfirst) {
      id--;
    }
    this.setData({
      hidden: false
    })
    if (id >= idfirst) {
      var that = this;
      wx.request({
        url: 'https://route.showapi.com/92-32',
        data: {
          showapi_appid: "36348",
          showapi_sign: "2a69af77c2e743bb88368847a63d6698",
          id: id
        },
        method: 'GET',
        success: function (res) {
          console.log("图书页面详情调用成功");
          var message = res.data.showapi_res_body.bookDetails.message;
          that.setData({
            wxParseData: WxParse('html', message),
            id: id,
            hidden: true
          })
        },
        fail: function (res) {
          console.log("图书页面详情调用失败");

          that.setData({
            id: id++,
            hidden: true
          })
          //失败提示
          wx.showToast({
            title: '加载失败，请返回重试',
            icon: 'loading',
            duration: 1500
          })
        },
        complete: function (res) {
        }
      })
    }
  },
  // 点击下一页
  ctapafter: function () {
    var idlast = this.data.idlast;
    var id = this.data.id;
    if (id == idlast) {
      wx.showToast({
        title: '已到达最后一页',
        icon: 'success',
        duration: 1000
      })
      return;
    }
    if (id < idlast) {
      id++;
    }
    this.setData({
      hidden: false
    })
    if (id <= idlast) {
      var that = this;
      wx.request({
        url: 'https://route.showapi.com/92-32',
        data: {
          showapi_appid: "36348",
          showapi_sign: "2a69af77c2e743bb88368847a63d6698",
          id: id
        },
        method: 'GET',
        success: function (res) {
          console.log("图书页面详情调用成功");
          var message = res.data.showapi_res_body.bookDetails.message;
          that.setData({
            wxParseData: WxParse('html', message),
            id: id,
            hidden: true
          })
        },
        fail: function (res) {
          console.log("图书页面详情调用失败");
          that.setData({
            id: id--,
            hidden: true
          })
          //失败提示
          wx.showToast({
            title: '加载失败，请返回重试',
            icon: 'loading',
            duration: 1500
          })
        },
        complete: function (res) {
        }
      })
    }
  }
})