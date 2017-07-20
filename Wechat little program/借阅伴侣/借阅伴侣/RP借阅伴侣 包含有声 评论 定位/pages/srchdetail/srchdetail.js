//根据isbn获取图书详情

var common = require('../../utils/util.js');

var app = getApp();
Page({
  data: {
    hidden: false,
    bookdetail: null,
    isbn: null,
    choose: 0,
    choose0: '读者评论',
    choose1: '',
    choose2: 'hide',
    commentlist: null,
    sumcom: 0,
    star_nomal: 0,
    star_harf: 0,
    star_selected: 0,
    vedio: ''
  },
  onLoad: function (options) {
    //console.log("isbn1:" + options.isbn);
    this.setData({
      isbn: options.isbn
    })
    //console.log("isbn2:" + this.data.isbn);
    var that = this;

    //console.log('vedio:' + options.isbn);
    wx.request({
      url: 'https://www.team539.cn/WX/Comment?action=vedio&isbn=' + options.isbn,
      data: {
      },
      method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function (res) {
        // success
        that.setData({
          vedio: res.data
        })
      },
      fail: function (res) {
        // fail
      }
    })

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
    var power = app.globalData.power;
    var obj = e.currentTarget.dataset.content;
    console.log(power, obj);
    if (power) {
      var userid = app.globalData.userID;
      var isbn = obj.isbn10;
      var name = obj.title;
      var author = obj.author;
      var image = obj.image;
      var summary = obj.summary;
      var catalog = obj.catalog;
      var publisher = obj.publisher;
      var authintro = obj.author_intro;
      obj.userid = userid;
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
    var power = app.globalData.power;
    var obj = e.currentTarget.dataset.content;
    console.log(power, obj);
    if (power) {
      var userid = app.globalData.userID;
      var isbn = obj.isbn10;
      var name = obj.title;
      var author = obj.author;
      obj.userid = userid;

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
  },
  comment: function () {
    var that = this;
    if (this.data.choose == 0) {
      this.setData({
        choose: 1,
        choose0: '作品介绍',
        choose1: 'hide',
        choose2: ''
      }),
        wx.request({//访问后台评论区
          //https://www.team539.cn
          url: 'https://www.team539.cn/WX/Comment?action=show&isbn=' + this.data.isbn,
          method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
          header: { 'content-type': 'application/x-www-form-urlencoded' }, // 设置请求的 header
          success: function (res) {
            // success
            var sum = 0.00;
            var point = 0;
            console.log('submit success', res.data);
            for (var i = 0; i < res.data.length; i++) {
              sum += parseFloat(res.data[i].star);
              console.log('结果：'+res.data[i].star);
            }
            if (sum / res.data.length - parseInt(sum / res.data.length) >= 0.5) {
              point = 1;
            }
            that.setData({
              commentlist: res.data,
              sumcom: (sum / res.data.length).toFixed(1),
              star_selected: parseInt(sum / res.data.length),
              star_harf: point,
              star_nomal: 5 - point - parseInt(sum / res.data.length)
            })
          },
          fail: function (res) {
            // fail
            console.log('submit fail');
          }
        })
    }
    else {
      this.setData({
        choose: 0,
        choose0: '读者评论',
        choose1: '',
        choose2: 'hide'
      })
    }
  },
  mycomment: function () {
    console.log('mycomment:' + this.data.isbn);
    wx.navigateTo({
      url: '../comment/comment?isbn=' + this.data.isbn,
      success: function (res) {
      },
      fail: function (res) {
      },
      complete: function (res) {
      }
    })
  },
  vedio: function () {
    wx.navigateTo({
      url: '../vedio/vedio?vedio=' + this.data.vedio,
      success: function (res) {
      },
      fail: function (res) {
      },
      complete: function (res) {
      }
    })
  },
  onShareAppMessage: function () {
    return {
      title: '借阅伴侣——' + this.data.bookdetail.title,
      desc: this.data.bookdetail.summary,
      path: '/page/srchdetail?id=' + this.data.isbn
    }
  }
})