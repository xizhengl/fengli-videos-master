package com.fengli.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.fengli.video.utils.RedisOperator;

/**
 *  基础常量定义类
 * @author Administrator
 */
@RestController
public class BasicController {

    @Autowired
    public RedisOperator redis;

    /**
     * redis 用户session key命名
     */
    public static final String USER_REDIS_SESSION = "user-redis-session";

        public static final String FILE_SPACE = "F:\\fengli_videos_dev";
//        public static final String FILE_SPACE = "/root/fengli_videos_dev";

    //    public static final String FFMPEG_EXE = "F:\\ffmpeg-20200617-0b3bd00-win64-static\\bin\\ffmpeg.exe";
        public static final String FFMPEG_EXE = "D:\\ffmpeg-20200620-29ea4e1-win64-static\\bin\\ffmpeg.exe";

    /**
     * aliyun 服务器
     */
//    public static final String FFMPEG_EXE = "/usr/local/bin/ffmpeg";


    /**
     *  每页分页的记录数
      */
    public static final Integer PAGE_SIZE = 5;

}
