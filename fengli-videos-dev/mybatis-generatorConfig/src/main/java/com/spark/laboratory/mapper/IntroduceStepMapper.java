package com.spark.laboratory.mapper;

import com.spark.laboratory.pojo.IntroduceStep;
import com.spark.laboratory.pojo.IntroduceStepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntroduceStepMapper {
    long countByExample(IntroduceStepExample example);

    int deleteByExample(IntroduceStepExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IntroduceStep record);

    int insertSelective(IntroduceStep record);

    List<IntroduceStep> selectByExample(IntroduceStepExample example);

    IntroduceStep selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IntroduceStep record, @Param("example") IntroduceStepExample example);

    int updateByExample(@Param("record") IntroduceStep record, @Param("example") IntroduceStepExample example);

    int updateByPrimaryKeySelective(IntroduceStep record);

    int updateByPrimaryKey(IntroduceStep record);
}