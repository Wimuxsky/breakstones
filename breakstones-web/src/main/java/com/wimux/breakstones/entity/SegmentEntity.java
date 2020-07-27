package com.wimux.breakstones.entity;

/**
 * @Author siqigang
 * @Date 2019-01-03 13:25
 */
public class SegmentEntity {

    private String bizTag;

    private Long maxId;

    private Integer step;

    public String getBizTag() {
        return bizTag;
    }

    public void setBizTag(String bizTag) {
        this.bizTag = bizTag;
    }

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }
}
