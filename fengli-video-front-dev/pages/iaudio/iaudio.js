// pages/iaudio/iaudio.js
Component({
    /**
     * 组件的属性列表
     */
    properties: {
        src: String,
        songName: String,
        singer: String,
        duration: String
    },

    /**
     * 组件的初始数据
     */
    data: {
        mymp3: {},
        isPlaying: false,
        ico: "play"
    },

    ready() {
        var mymp3 = wx.createInnerAudioContext();
        mymp3.autoplay = false;
        mymp3.src = this.data.src;
        this.setData({
            mymp3: mymp3
        });
    },

    /**
     * 组件的方法列表
     */
    methods: {
        display() {
            var isPlaying = this.data.isPlaying;
            if (!isPlaying) {
                this.data.mymp3.play();
                this.setData({
                    isPlaying: true,
                    ico: "pause"
                });
            } else {
                this.data.mymp3.pause();
                this.setData({
                    isPlaying: false,
                    ico: "play"
                });
            }
        }
    }
})
