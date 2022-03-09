package com.fan.service;

import com.fan.bean.Account;
import com.fan.mapper.TestMybatisMixMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestMybatisMixService {

    @Autowired
    TestMybatisMixMapper testMybatisMixMapper;

    public Account getById(Long id){
        return testMybatisMixMapper.getById(id);
    }

    public void insertOne(Account account){
        testMybatisMixMapper.insertOne(account);
    }
}
