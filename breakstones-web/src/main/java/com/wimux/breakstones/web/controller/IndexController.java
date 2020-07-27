package com.wimux.breakstones.web.controller;

import com.wimux.breakstones.web.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author siqigang
 * @Date 2018/9/21 15:02
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public ResultVO index() {
        return new ResultVO(ResultVO.CODE_SUCCESS, "success");
    }

}
