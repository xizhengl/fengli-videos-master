package com.fengli.video.mapper;

import java.util.List;

import com.fengli.video.pojo.Comments;
import com.fengli.video.pojo.vo.CommentsVO;
import com.fengli.video.utils.MyMapper;

public interface CommentsMapperCustom extends MyMapper<Comments> {
	
	public List<CommentsVO> queryComments(String videoId);
}