package com.fan.config;

import com.fan.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//addPathPatterns是添加拦截请求路径，/**代表所有请求路径
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");//excludePathPatterns是不拦截哪些请求路径，要注意的是静态资源请求也是要处理一下的，不能拦截
    }
}
