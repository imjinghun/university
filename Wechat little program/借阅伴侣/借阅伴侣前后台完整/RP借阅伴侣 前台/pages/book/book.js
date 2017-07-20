var WxParse = require('../../wxParse/wxParse.js');

Page({
  data: {
    idfirst: null, //第一个页面id
    idlast: null, //最后一个页面id
    id: null, //当前页面id
    message: [], //缓存的数据
    wxParseData: [], //页面显示
    hidden: false //loading
  },
  onLoad: function (options) {
    var id = options.id;
    //同步获取数据缓存
    var msg = wx.getStorageSync('bookdetail');
    //获取msg数组 第一个和最后一个页面first last id
    var idfirst = msg[0].id;
    var idlast = msg[msg.length - 1].id;
    console.log(id, idfirst, idlast);
    //赋值
    this.setData({
      idfirst: idfirst,
      idlast: idlast,
      id: id,
      message: msg
    })
    //页面显示
    for (var i = 0; i < msg.length; i++) {
      if (msg[i].id == id) {
        //更新数据
        this.setData({
          wxParseData: WxParse('html', msg[i].message)
        })
        break;
      }
    }
    this.setData({
      hidden: true
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
      var msg = this.data.message;
      for (var i = 0; i < msg.length; i++) {
        if (msg[i].id == id) {
          //更新数据 更新当前id
          this.setData({
            wxParseData: WxParse('html', msg[i].message),
            id:id
          })
          break;
        }
      }
    }
    this.setData({
      hidden: true
    })
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
      var msg = this.data.message;
      for (var i = 0; i < msg.length; i++) {
        if (msg[i].id == id) {
          //更新数据
          this.setData({
            wxParseData: WxParse('html', msg[i].message),
            id:id
          })
          break;
        }
      }
      this.setData({
        hidden: true
      })
    }
  }
})