package com.fan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest")
@RestController
public class MyRestController {
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public String restGet(){
        return "get";
    }
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")
    public String restPost(){
        return "post";
    }
//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String restPut(){
        return "put";
    }
//    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String restDelete(){
        return "delete";
    }
}
