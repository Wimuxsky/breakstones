package com.wimux.breakstones.mapper;

import com.wimux.breakstones.entity.SegmentEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author siqigang
 * @Date 2018/9/21 16:23
 */
@Mapper
public interface SegmentMapper {

    @Select("SELECT biz_tag as bizTag,max_id as maxId,step as step FROM BS_Segment")
    List<SegmentEntity> findAll();


    @Insert("Replace into BS_Segment (biz_tag,max_id,step) values(#{bizTag},#{maxId},#{step})")
    void insert(@Param("bizTag") String bizTag, @Param("maxId") long maxId, @Param("step") int step);


    @Update("UPDATE BS_Segment SET max_id=max_id+step WHERE biz_tag=#{bizTag}")
    void update(@Param("bizTag") String bizTag);

    @Select("select biz_tag as bizTag,max_id as maxId,step as step FROM BS_Segment WHERE biz_tag=#{bizTag} limit 1;")
    SegmentEntity select(@Param("bizTag") String bizTag);

}
