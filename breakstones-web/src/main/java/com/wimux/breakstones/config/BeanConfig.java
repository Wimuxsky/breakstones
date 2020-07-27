package com.wimux.breakstones.config;

import com.wimux.breakstones.stone.uniqueid.SnowFlakeFake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author siqigang
 * @Date 2019-01-03 13:30
 */
@Configuration
public class BeanConfig {
    @Bean
    SnowFlakeFake snowFlakeFake() {
        return new SnowFlakeFake(2, 3);
    }

}
