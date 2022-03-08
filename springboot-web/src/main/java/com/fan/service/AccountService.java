package com.fan.service;

import com.fan.bean.Account;
import com.fan.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;

    public Account getAccount(Long id){
        return accountMapper.getAccount(id);
    }
}
