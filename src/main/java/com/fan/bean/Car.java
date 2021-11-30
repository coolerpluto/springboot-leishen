package com.fan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//1、boot主程序默认读取application.properties配置文件，这个注解@ConfigurationProperties(prefix = "car")，是将配置文件
//里的kv值赋给这个Car类，通过添加kv的前缀。来进行匹配
//2、要想使用这个配置文件赋值的功能需要把Car类变成组件放到容器里，所以加注解@Component
@NoArgsConstructor//省去了无参构造器
@AllArgsConstructor//省去了全参构造器，这两个构造器注解一般不用。
@ToString// 省去了tostring方法
@Data//作用：省去了get set 方法书写
@Component
@ConfigurationProperties(prefix = "car")
public class Car {
    private String name;

    private Integer price;

}
