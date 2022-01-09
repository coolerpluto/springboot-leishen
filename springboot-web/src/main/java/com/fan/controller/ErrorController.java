package com.fan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ErrorController {
    @GetMapping("404.html")
    public String page404(){
        return "error/404";
    }

    @GetMapping("500.html")
    public String page500(){
        return "error/500";
    }
}
