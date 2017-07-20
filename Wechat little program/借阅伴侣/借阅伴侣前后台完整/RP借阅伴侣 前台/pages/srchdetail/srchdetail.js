//根据isbn获取图书详情

var common=require('../../utils/util.js');

var app = getApp();
Page({
  data: {
    hidden: false,
    bookdetail: null
  },
  onLoad: function (options) {
    // console.log(options.isbn);
    var that = this;
    wx.request({
      url: 'https://api.douban.com/v2/book/isbn/' + options.isbn,
      data: {},
      method: 'GET',
      success: function (res) {
        // console.log(res.data.msg);
        if (res.data.msg == "book_not_found") {
          wx.showModal({
            title: '提示',
            content: '无此书,请重新扫描',
            showCancel: false,
            success: function (res) {
              if (res.confirm) {
                wx.switchTab({
                  url: '../scan/scan',
                  success: function (res) {
                  },
                  fail: function (res) {
                  },
                  complete: function (res) {
                  }
                })
              }
            }
          })
          return;
        }
        that.setData({
          hidden: true,
          bookdetail: res.data
        });
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
  },
  // 事件 ************************************
  //收藏
  ctapCollect: function (e) {
   // var power = app.globalData.power; @@@@@@@@@@@@
   var power = true;
    var obj = e.currentTarget.dataset.content;
    console.log(power, obj);
    if (power) {
     // var userid = app.globalData.userID; @@@@@@@@@@@@
      var isbn = obj.isbn10;
      var name = obj.title;
      var author = obj.author;
      var image = obj.image;
      var summary = obj.summary;
      var catalog=obj.catalog;
      var publisher=obj.publisher;
      var authintro=obj.author_intro;
      obj.userid="111111"; // @@@@@@@@@@@@
     // console.log( isbn, name, author, image, summary,catalog,publisher,authintro);

      //收藏
      common.collect(obj);

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
  },
  //借阅
  ctapBorrow: function (e) {
  //  var power = app.globalData.power; @@@@@@@@@@@@
  var power=true;
    var obj = e.currentTarget.dataset.content;
    console.log(power, obj);
    if (power) {
     // var userid = app.globalData.userID; @@@@@@@@@@@@
      var isbn = obj.isbn10;
      var name = obj.title;
      var author = obj.author;
      obj.userid='111111'; // @@@@@@@@@@@@
   //   console.log(isbn, name, author);
   
      //借阅
      common.borrow(obj);
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