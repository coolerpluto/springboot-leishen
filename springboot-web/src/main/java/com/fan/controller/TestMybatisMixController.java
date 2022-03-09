package com.fan.controller;

import com.fan.bean.Account;
import com.fan.service.TestMybatisMixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestMybatisMixController {

    @Autowired
    TestMybatisMixService testMybatisMixService;

    @ResponseBody
    @GetMapping("/mybatisMix")
    public Account getById(@RequestParam("id") Long id){
        return testMybatisMixService.getById(id);
    }

    @ResponseBody
    @PostMapping("/mybatisMixInsert")
    public Account insertOne(Account account){
        testMybatisMixService.insertOne(account);
        return account;
    }
}
