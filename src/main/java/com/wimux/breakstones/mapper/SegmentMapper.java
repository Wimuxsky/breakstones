package com.wimux.breakstones.mapper;

import com.wimux.breakstones.entity.SegmentEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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


    @Insert("Replace into BS_Segment (biz_tag,max_id,step) values(#{bizTag},#{maxId},#{step})")
    void insert(@Param("bizTag") String bizTag, @Param("maxId") long maxId, @Param("step") int step);

}
