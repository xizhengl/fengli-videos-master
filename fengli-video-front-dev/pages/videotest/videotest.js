const app = getApp()

Page({
  url: "/200622FKS23GKF3C/video/6fa15162-8c14-4af0-818a-7887e7c9ca34.mp4",
  data: {
    danmuList: [
      {
        text: '第 1s 出现的弹幕',
        color: '#ff0000',
        time: 1
      },
      {
        text: '第 3s 出现的弹幕',
        color: '#ff00ff',
        time: 3
      }]
      
  },

  bindplay:function() {
    console.log("播放");
  },
  bindpause: function () {
    console.log("暂停");
  }
  

})