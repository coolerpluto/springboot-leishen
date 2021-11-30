package com.fan.controller;

import com.fan.bean.Car;
import com.fan.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    Car car;
    @Autowired
    Person person;

    @RequestMapping("/hello")
    public String hello(){
        return "hello大世界";
    }
    @RequestMapping("/carInfo")
    public Car carInfo(){
        return car;
    }
    @RequestMapping("yml")
    public Person personYmlTest(){
        return person;
    }
}
