package com.fengli.video.mapper;

import java.util.List;

import com.fengli.video.pojo.SearchRecords;
import com.fengli.video.utils.MyMapper;

public interface SearchRecordsMapper extends MyMapper<SearchRecords> {
	
	public List<String> getHotwords();
}