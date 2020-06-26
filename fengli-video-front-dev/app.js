//app.js
App({
  serverUrl:"http://8hhy88.natappfree.cc",
  userInfo: null,
  
  setGlobalUserInfo: function(user) {
    wx.setStorageSync("userInfo", user);
  },

  getGlobalUserInfo: function () {
    return wx.getStorageSync("userInfo");
  },
})