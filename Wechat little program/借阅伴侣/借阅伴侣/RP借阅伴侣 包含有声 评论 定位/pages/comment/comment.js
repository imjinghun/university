// pages/comment/comment.js

//获取应用实例
var app = getApp()
Page({
  data: {
    stars: [0, 1, 2, 3, 4],
    normalSrc: '../../images/normal.png',
    selectedSrc: '../../images/selected.png',
    halfSrc: '../../images/half.png',
    key: 0,//评分
    content: "",//内容,
    name: "",//昵称
    isbn: ""
  },
  onLoad: function (options) {
    console.log("isbn:" + options.isbn)
    this.setData({
      isbn: options.isbn
    })
  },
  //点击右边,半颗星
  selectLeft: function (e) {
    var key = e.currentTarget.dataset.key
    if (this.data.key == 0.5 && e.currentTarget.dataset.key == 0.5) {
      //只有一颗星的时候,再次点击,变为0颗
      key = 0;
    }
    console.log("得" + key + "分")
    this.setData({
      key: key
    })

  },
  //点击左边,整颗星
  selectRight: function (e) {
    var key = e.currentTarget.dataset.key
    console.log("得" + key + "分")
    this.setData({
      key: key
    })
  },
  bindFormSubmit: function (e) {
    console.log("comment:" + this.data.isbn)
    console.log("textarea:" + e.detail.value.textarea)
    var that = this;
    this.setData({
      content: e.detail.value.textarea,
      name: e.detail.value.input
    })
    wx.request({
      //http://localhost:8080
      url: 'https://www.team539.cn/WX/Comment',
      data: {
        action: 'add',
        star: this.data.key,
        content: this.data.content,
        name: this.data.name,
        isbn: this.data.isbn
      },
      method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      header: { 'content-type': 'application/x-www-form-urlencoded' }, // 设置请求的 header
      success: function (res) {
        // success
        console.log('submit succeed' + that.data.isbn);
        wx.redirectTo({
          url: '../srchdetail/srchdetail?isbn=' + that.data.isbn,
        })
      },
      fail: function (res) {
        // fail
        console.log('submit fail');
        wx.showModal({
          title: '提示',
          content: '添加失败'
        })
      }
    })
  }
})