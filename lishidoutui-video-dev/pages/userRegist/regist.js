var app = getApp()

Page({
    data: {
    },
    doRegist: function(e){
        var password = e.detail.value.password;
        var username = e.detail.value.username;
        if(password.length == 0 || username.length == 0){
            wx.showToast({
              title: '用户名或密码不能为空',
              icon: 'none',
              duration: 3000
            })
        }else{
            wx.request({
              url: app.serverUrl + "/regist",
              method: "POST",
              data: {
                username: username,
                password: password
              },
              header: {
                'content-type': 'application/json' // 默认值
              },
              success: function(res){
                var status = res.data.status;
                  if(status == 200){
                    wx.showToast({
                        title: "用户注册成功~！！！",
                        icon: 'none',
                        duration: 3000
                      })
                  // app.userInfo = res.data.data;
                  app.setGlobalUserInfo(res.data.data);
                  }else if(status == 500){
                    wx.showToast({
                        title: res.data.msg,
                        icon: 'none',
                        duration: 3000
                      })
                  }
              }
            })
        }
    },
    goLoginPage:function() {
        wx.navigateTo({
          url: '../userLogin/login',
        })
      }
})