package com.fan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImage") MultipartFile headerImage,//@RequestPart拿到前端传的单个文件
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {//MultipartFile[]来获取多个文件
        log.info("email:{}, username:{}, headerImage{}, photos:{}",email, username, headerImage.getSize(), photos.length);
        if (!headerImage.isEmpty()){//先判断空
            String fileName = headerImage.getOriginalFilename();//获取文件的名称
            headerImage.transferTo(new File("E:\\bootcache\\"+fileName));//调用MultipartFile的方法，向指定路径添加文件
        }
        if(photos.length > 0){
            for (MultipartFile photo : photos){
                if (!photo.isEmpty()){
                    String fileName = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\bootcache\\"+fileName));
                }
            }
        }
        return "main";
    }
}
