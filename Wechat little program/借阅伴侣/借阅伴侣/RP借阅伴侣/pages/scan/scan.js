//扫码 
var scan=function(){
  wx.scanCode({
      success: function (res) {
        //console.log(res);
        wx.navigateTo({
          url: '../srchdetail/srchdetail?isbn='+res.result,
          success: function(res){
          },
          fail: function(res) {
          },
          complete: function(res) {
          }
        })
      },
      fail: function () {
      },
      complete: function () {
      }
    })
}

Page({
  data:{},
  onLoad:function(options){
  },
  onReady:function(){
    // 页面渲染完成
  },
  onShow:function(){
    scan.call();
  },
  onHide:function(){
    // 页面隐藏
  },
  onUnload:function(){
    // 页面关闭
  },
  //点击扫描
  btnscan:function(){
      scan.call();
  }
})