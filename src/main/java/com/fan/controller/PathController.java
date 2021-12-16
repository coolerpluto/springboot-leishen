package com.fan.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class PathController {

    @RequestMapping("/user/{uid}/book/{bookid}")
    public Map<String, Object> a1(@PathVariable("uid") Integer uid,
                                  @PathVariable("bookid") Integer bookid,
                                  @PathVariable Map<String ,Object> pv,
                                  ){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("uid",uid);
        map1.put("bookid",bookid);
        map1.put("pv",pv);
        return map1;
    }
}
