package com.wimux.breakstones.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.wimux.breakstones.stone.uniqueid.SnowFlakeFake;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author siqigang
 * @Date 2019-01-03 13:30
 */
@Configuration
public class BeanConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.druid") //加载时读取指定的配置信息,前缀为spring.datasource.druid
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }


//    @Bean(name = "sqlSessionFactory")
//    @Primary
//    public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("datasource") DataSource dataSource)throws Exception{
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        return bean.getObject();
//    }

    @Bean
    SnowFlakeFake snowFlakeFake() {
        return new SnowFlakeFake(2, 3);
    }

}
