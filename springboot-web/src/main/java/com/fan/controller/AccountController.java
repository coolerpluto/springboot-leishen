package com.fan.controller;

import com.fan.bean.Account;
import com.fan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;


    @ResponseBody
    @GetMapping("/account")
    public Account getAccount(@RequestParam("id") Long id){
        return accountService.getAccount(id);
    }
}
