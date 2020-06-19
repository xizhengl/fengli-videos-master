//app.js
App({
  serverUrl:"http://zs2du6.natappfree.cc",
  userInfo: null,
  
  setGlobalUserInfo: function(user) {
    wx.setStorageSync("userInfo", user);
  },

  getGlobalUserInfo: function () {
    return wx.getStorageSync("userInfo");
  },
})