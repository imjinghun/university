//收藏
function collect(obj) {
  wx.request({
    url: 'http://localhost:8080/WXXCX/servlet/AddCollection',
    data: {
      'userid': obj.userid,
      'isbn': obj.isbn10,
      'name': obj.title,
      'author': obj.author,
      'image': obj.image,
      'summary': obj.summary,
      'catalog': obj.catalog,
      'publisher': obj.publisher,
      'authintro': obj.author_intro
    },
    header: { 'content-type': 'application/x-www-form-urlencoded' },
    method: 'POST',
    success: function (res) {
      if (res.data == "success") {
        wx.showToast({
          title: '收藏成功',
          icon: 'success',
          duration: 1500
        })
      }
      if (res.data == "1") {
        wx.showToast({
          title: '已经收藏',
          icon: 'success',
          duration: 1500
        })
      }
    },
    fail: function (res) {
    },
    complete: function (res) {
    }
  })
}
//取消收藏
function cancelcollect(userid, isbn) {
  wx.request({
    url: 'http://localhost:8080/WXXCX/servlet/DelCollection',
    data: {
      'userid': userid,
      'isbn': isbn
    },
    header: { 'content-type': 'application/x-www-form-urlencoded' },
    method: 'POST',
    success: function (res) {
      if (res.data == "success") {
        wx.showToast({
          title: '取消收藏',
          icon: 'success',
          duration: 1500
        })
      }
    },
    fail: function (res) {
    },
    complete: function (res) {
    }
  })
}
//借阅
function borrow(obj) {
  var date = new Date();
  wx.request({
    url: 'http://localhost:8080/WXXCX/servlet/AddBorrow',
    data: {
      'userid': obj.userid,
      'isbn': obj.isbn10,
      'name': obj.title,
      'author': obj.author
    },
    method: 'POST',
    header: { 'content-type': 'application/x-www-form-urlencoded' },
    success: function (res) {
      if (res.data == "1") {
        wx.showModal({
          title: '提示',
          content: '已经借阅',
          showCancel: false,
          success: function (res) {
          }
        })
      }
      if (res.data == "2") {
        wx.showModal({
          title: '提示',
          content: '最多借两本书',
          showCancel: false,
          success: function (res) {
          }
        })
      }
      if (res.data == "success") {
        //借阅成功 请交押金
        wx.showModal({
          title: '提示',
          content: '借阅成功,请交押金',
          showCancel: false,
          success: function (res) {
            //调用微信支付二维码交押金
          }
        })
      }
    },
    fail: function (res) {
    },
    complete: function (res) {
    }
  })
}
//取消借阅 还书
function cancelborrow(userid, isbn) {
  wx.request({
    url: 'http://localhost:8080/WXXCX/servlet/DelBorrow',
    data: {
      'userid': userid,
      'isbn': isbn
    },
    header: { 'content-type': 'application/x-www-form-urlencoded' },
    method: 'POST',
    success: function (res) {
      if (res.data == "success") {
        wx.showToast({
          title: '还书完成',
          icon: 'success',
          duration: 1500
        })
      }
    },
    fail: function (res) {
    },
    complete: function (res) {
    }
  })
}
module.exports = {
  collect: collect,
  borrow: borrow,
  cancelcollect: cancelcollect,
  cancelborrow: cancelborrow
}
/*module.exports.collect = collect
exports.borrow = borrow
exports.cancelcollect = cancelcollect
exports.cancelborrow = cancelborrow*/