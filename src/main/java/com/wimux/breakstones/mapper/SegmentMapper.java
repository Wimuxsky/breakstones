package com.wimux.breakstones.mapper;

import com.wimux.breakstones.entity.SegmentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author siqigang
 * @Date 2018/9/21 16:23
 */
@Mapper
public interface SegmentMapper {

    @Select("SELECT biz_tag as bizTag,max_id as maxId,step as step FROM BS_Segment")
    List<SegmentEntity> findAll();
}
