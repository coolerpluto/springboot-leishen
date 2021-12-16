package com.fan.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class PathController {

    @RequestMapping("/user/{uid}/book/{bookid}")
    public Map<String, Object> a1(@PathVariable("uid") Integer uid,
                                  @PathVariable("bookid") Integer bookid,
                                  @PathVariable Map<String ,String> pv,
                                  @RequestHeader Map<String, String> requestHeader
                                  ){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("uid",uid);
        map1.put("bookid",bookid);
        map1.put("pv",pv);
        map1.put("requestHeader",requestHeader);
        return map1;
    }
}
