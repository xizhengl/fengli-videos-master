package com.spark.laboratory.pojo;

public class IntroduceStep {
    private Integer id;

    private String lineValue;

    private Integer lineType;

    private String isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLineValue() {
        return lineValue;
    }

    public void setLineValue(String lineValue) {
        this.lineValue = lineValue == null ? null : lineValue.trim();
    }

    public Integer getLineType() {
        return lineType;
    }

    public void setLineType(Integer lineType) {
        this.lineType = lineType;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}