package com.fan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class RequestController {

    @ResponseBody
    @RequestMapping("/user/{uid}/book/{bookid}")
    public Map<String, Object> a1(@PathVariable("uid") Integer uid,//uid路径变量
                                  @PathVariable("bookid") Integer bookid,//bookid路径变量
                                  @PathVariable Map<String ,String> pv,//所有路径变量
                                  @RequestHeader Map<String, String> requestHeader,//请求头
                                  @RequestParam("sex") String sex,//路径上的请求参数sex
                                  @RequestParam("interests")List<String> interests//路径参数有时会赋多个值，http://localhost:8080/user/2/book/3?sex=男&interests=篮球&interests=足球
                                  ){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("uid",uid);
        map1.put("bookid",bookid);
        map1.put("pv",pv);
        map1.put("requestHeader",requestHeader);
        map1.put("sex", sex);
        map1.put("interests", interests);
        return map1;
    }
    //@RequestBody注解使用
    // @RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)
    @PostMapping("/post/form1")
    public Map a2(@RequestBody String jsonString){
        Map<String,Object> map = new HashMap<>();
        map.put("jsonString", jsonString);
        return map;
    }

    @GetMapping("/params")//这几个类型的参数，其赋得值都是放在请求域中，所以可以在HttpServletRequest request里来获取到这些值，例如在这个方法里赋了三个值，然后在success方法里通过了HttpServletRequest拿到了这些值
    public String testParam(Map<String,Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("map","map123");
        model.addAttribute("model", "model123");
        request.setAttribute("request", "request123");
        Cookie cookie = new Cookie("c1", "v1");
        response.addCookie(cookie);
        return "forward:/success";//请求跳转到下面这个success方法。forward写法：要想直接跳转使用某个方法，必须要与目的方法的RequestMapping的value值相等
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(HttpServletRequest request){

        Object map = request.getAttribute("map");
        Object model = request.getAttribute("model");
        Object request1 = request.getAttribute("request");
        Map<String,Object> map1 = new HashMap<>();
        map1.put("map", map);
        map1.put("model", model);
        map1.put("request1", request1);
        return map1;
    }
}
