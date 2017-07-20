var sethistory = function (that, history) {
  var value = that.data.searchkey;
  if (!value) {
    return;
  }
  //console.log("获取值 ", value);
  var srch = new Array();
  srch = history;
  //检查是否搜索过此关键词
  var check = 0;
  for (var i = 0; i < srch.length; i++) {
    if (value == srch[i]) {
      check = 1;
      break;
    }
  }
  //没有搜索过
  if (check == 0) {
    srch.unshift(value);
    wx.setStorage({
      key: 'history',
      data: srch,
      success: function (res) {
        that.setData({
          history: srch
        })
      },
      fail: function (res) {
      },
      complete: function (res) {
      }
    })
  }
}
//获取应用实例
var app = getApp()
Page({
  data: {
    searchkey: null,
    history: [],
    showhidden: "hidden",
    bookclass: [{
      "id": "1",
      "name": "孕妇育儿"
    },
    {
      "id": "2",
      "name": "美容时尚"
    },
    {
      "id": "3",
      "name": "健康养生"
    },
    {
      "id": "4",
      "name": "两性生活"
    },
    {
      "id": "5",
      "name": "美食烹饪"
    },
    {
      "id": "6",
      "name": "修养心里"
    },
    {
      "id": "7",
      "name": "家庭教育"
    },
    {
      "id": "8",
      "name": "幽默笑话"
    },
    {
      "id": "9",
      "name": "生活杂谈"
    },
    {
      "id": "10",
      "name": "其它"
    }]
  },
  onLoad: function () {
    /*可不用
    var that = this;
    wx.request({
      url: 'https://api.tngou.net/book/classify',
      method: 'POST',
      header: { 'content-type': 'application/json' },
      success: function (res) {
        var bc = res.data.tngou;
        for (var i = 0; i < bc.length; i++) {
          bc[i].name = bc[i].name.replace("图书", "");
        }
        console.log("图书分类调用成功");
        that.setData({
          bookclass: bc
        })
      },
      fail: function (res) {
        console.log("图书分类调用失败");
      },
      complete: function (res) {
        //  console.log("图书分类调用完成");
      }
    })*/
  },
  //事件处理函数  *************************************
  inputsearch: function (e) {
    this.setData({
      searchkey: e.detail.value
    });
  },
  showhistory: function () {
    if (this.data.showhidden == "hidden") {
      var that = this;
      //读取缓存 放入history
      wx.getStorage({
        key: 'history',
        success: function (res) {
          that.setData({
            history: res.data
          })
        },
        fail: function (res) {
        },
        complete: function (res) {
        }
      })
      //显示历史记录
      this.setData({
        showhidden: "show"
      });
    }
  },
  hiddenhistory: function () {
    if (this.data.showhidden == "show") {
      this.setData({
        showhidden: "hidden"
      });
    }
  },
  //点击搜索按钮
  ctapsearch: function () {
    //输入为空返回
    if (!this.data.searchkey) {
      return;
    }
    //将搜索记录 读入缓存
    sethistory(this, this.data.history);

    wx.navigateTo({
      url: '../search/search?searchkey=' + this.data.searchkey,
      success: function (res) {
      },
      fail: function (res) {
      },
      complete: function (res) {
      }
    })
  },
  //清除历史记录
  clearhistory: function () {
    var that = this;
    wx.showModal({
      title: '',
      content: '确认清空历史',
      success: function (res) {
        if (res.confirm) {
          wx.clearStorage({
            key: 'history',
            success: function (res) {
              that.setData({
                history: []
              })
            },
            fail: function (res) {
            },
            complete: function (res) {
            }
          })
        }
      }
    })
  }
})
