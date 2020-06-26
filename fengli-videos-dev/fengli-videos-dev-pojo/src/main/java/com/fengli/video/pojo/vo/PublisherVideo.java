package com.fengli.video.pojo.vo;

/**
 *  发布视频作者 信息类
 * @author Administrator
 */
public class PublisherVideo {

	/**
	 * 视频用户信息
	 */
	public UsersVO publisher;
	/**
	 * 登陆用户和视频喜欢关系
	 */
	public boolean userLikeVideo;

	public UsersVO getPublisher() {
		return publisher;
	}
	public void setPublisher(UsersVO publisher) {
		this.publisher = publisher;
	}
	public boolean isUserLikeVideo() {
		return userLikeVideo;
	}
	public void setUserLikeVideo(boolean userLikeVideo) {
		this.userLikeVideo = userLikeVideo;
	}
}