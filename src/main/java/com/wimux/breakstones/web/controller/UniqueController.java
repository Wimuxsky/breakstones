package com.wimux.breakstones.web.controller;

import com.wimux.breakstones.service.SegmentService;
import com.wimux.breakstones.stone.uniqueid.SnowFlakeFake;
import com.wimux.breakstones.web.vo.ResultVO;
import com.wimux.breakstones.web.vo.UniqueIdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author siqigang
 * @Date 2018/9/21 16:40
 */
@RequestMapping("/unique")
@RestController
public class UniqueController {
    @Autowired
    private SegmentService segmentService;

    @Autowired
    private SnowFlakeFake snowFlakeFake;


    @GetMapping("/segment/next")
    public ResultVO segmentNext() {
        return new ResultVO(segmentService.findAll());
    }


    @GetMapping("/snowflake/next")
    public ResultVO snowflakeNext() {
        return new ResultVO(new UniqueIdVO(snowFlakeFake.nextId()));
    }

    @GetMapping("test/insert")
    public ResultVO testInsert(String bizTag) {
        segmentService.insert(bizTag, 10, 10);
        return new ResultVO(ResultVO.CODE_SUCCESS, "success");
    }
}
