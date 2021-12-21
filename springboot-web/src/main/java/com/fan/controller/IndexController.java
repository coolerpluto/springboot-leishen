package com.fan.controller;

import com.fan.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }
    @PostMapping("/login")
    public String main(User user, HttpSession session){
        if(!StringUtils.isEmpty(user.getUserName()) && StringUtils.hasLength(user.getPassword())){
            session.setAttribute("userStatus", "true");
            session.setMaxInactiveInterval(20);
            return "redirect:main.html";
        }else {
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session){
        System.out.println(session.getAttribute("userStatus"));
        if (session.getAttribute("userStatus")!=null){
            return "main";
        }else {
            return "login";
        }

    }
}
