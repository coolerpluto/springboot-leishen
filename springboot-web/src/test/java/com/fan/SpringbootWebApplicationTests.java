package com.fan;

import com.fan.bean.User;
import com.fan.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class SpringbootWebApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(1) from student", Long.class);
        log.info("student表有{}条数据", aLong);
        log.info("数据源类型:{}",dataSource.getClass());
    }

    @Test
    void test01(){
        User user = userMapper.selectById(1L);
        log.info("查询结果是{}", user );
    }

}
