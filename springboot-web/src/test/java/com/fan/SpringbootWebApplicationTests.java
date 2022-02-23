package com.fan;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
@Slf4j
@SpringBootTest
class SpringbootWebApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;



    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(1) from student", Long.class);
        log.info("student表有{}条数据", aLong);
    }

}
