package com.wimux.breakstones.config;

import com.wimux.breakstones.stone.uniqueid.SnowFlakeFake;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author siqigang
 * @Date 2019-01-03 13:30
 */
@Configuration
public class BeanConfig {

    @Bean(name = "datasource")
    @ConfigurationProperties(prefix = "spring.datasource") // application.properteis中对应属性的前缀
    public DataSource dataSource() {
        DataSource build = DataSourceBuilder.create().build();
        return build;
    }

    @Bean
    SnowFlakeFake snowFlakeFake() {
        return new SnowFlakeFake(2, 3);
    }

}
