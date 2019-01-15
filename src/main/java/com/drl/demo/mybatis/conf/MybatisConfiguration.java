package com.drl.demo.mybatis.conf;

import com.drl.demo.mybatis.dao.BookMapper;
import com.drl.demo.mybatis.dao.UserMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile({"production", "default", "dev"})
public class MybatisConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mybatis1")
    public DataSource myBatis1() {
        return new HikariDataSource();
    }

    @Bean
    @Primary
    public SqlSessionFactoryBean mybatis1SqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }


    @Bean
    public MapperFactoryBean<UserMapper> userMapper(@Qualifier("mybatis1SqlSessionFactoryBean") SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
        MapperFactoryBean<UserMapper> mapperMapperFactoryBean = new MapperFactoryBean<>(UserMapper.class);
        mapperMapperFactoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return mapperMapperFactoryBean;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.mybatis2")
    public DataSource myBatis2() {
        return new HikariDataSource();
    }

    @Bean
    public MapperFactoryBean<BookMapper> bookMapper(@Qualifier("mybatis2SqlSessionFactoryBean") SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
        MapperFactoryBean<BookMapper> mapperMapperFactoryBean = new MapperFactoryBean<>(BookMapper.class);
        mapperMapperFactoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return mapperMapperFactoryBean;
    }

    @Bean
    public SqlSessionFactoryBean mybatis2SqlSessionFactoryBean(@Qualifier("myBatis2") DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

}
