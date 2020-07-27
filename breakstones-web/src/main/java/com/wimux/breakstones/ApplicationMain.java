package com.wimux.breakstones;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Author siqigang
 * @Date 2018-12-29 16:45
 */
@SpringBootApplication
@ServletComponentScan("com.wimux.breakstones.servlet")
@MapperScan(basePackages = {"com.wimux.breakstones.mapper"})
public class ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
