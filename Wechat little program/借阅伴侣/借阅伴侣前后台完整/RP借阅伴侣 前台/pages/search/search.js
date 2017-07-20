var url = 'https://api.douban.com/v2/book/search';
var requestData = function () {
  var that = this;
  wx.request({
    url: url,
    data: {
      q: that.data.searchkey,
      start: that.data.start
    },
    method: 'GET',
    success: function (res) {
      //获取已有的图书列表信息
      var booklisttemp = that.data.booklist;
      //首次加载时 查不到则返回
      if (booklisttemp.length == 0 && res.data.books.length == 0) {
        that.setData({
          hidden: true
        });
        //返回index tabBar
        wx.showModal({
          title: '提示',
          content: '查无此书，请重新输入',
          showCancel: false,
          success: function (res) {
            if (res.confirm) {
              wx.switchTab({
                url: '../index/index',
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
      var bookList = res.data.books;
      //追加新的图书列表信息
      for (var i = 0; i < bookList.length; i++) {
        booklisttemp.push(bookList[i]);
      }
      //重设图书列表信息 设置loading隐藏
      that.setData({
        booklist: booklisttemp,
        //每次起始值为 已有图书列表的长度
        start: booklisttemp.length,
        hidden: true
      })
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
}
Page({
  data: {
    start: 0, //查询的起始位置
    searchkey: null, //关键字
    booklist: [], //返回列表
    hidden: false
  },
  onLoad: function (options) {
    this.setData({
      searchkey: options.searchkey
    });
    requestData.call(this);
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  // 上拉事件
  pullUpLoad: function () {
    this.setData({
      hidden: false
    });
    requestData.call(this);
  }
})