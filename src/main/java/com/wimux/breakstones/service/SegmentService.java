package com.wimux.breakstones.service;

import com.wimux.breakstones.dto.SegmentDTO;
import com.wimux.breakstones.entity.SegmentEntity;
import com.wimux.breakstones.mapper.SegmentMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author siqigang
 * @Date 2019-01-03 13:26
 */
@Service
public class SegmentService {

    @Autowired
    private SegmentMapper segmentMapper;

    public List<SegmentDTO> findAll() {
        List<SegmentEntity> entityList = segmentMapper.findAll();
        if (!CollectionUtils.isEmpty(entityList)) {
            return entityList.stream()
                    .map(entity -> {
                        SegmentDTO dto = new SegmentDTO();
                        BeanUtils.copyProperties(entity, dto);
                        return dto;
                    })
                    .collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    public void insert(String bizTag, long maxId, int step) {
        segmentMapper.insert(bizTag, maxId, step);
    }


}
