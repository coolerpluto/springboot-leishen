package com.fan.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("user")//mybatis-plus默认会根据实体类名去数据库库匹配首字母小写的表，如果数据库表和实体类不是一样的，
//那就需要在实体类加一个表匹配注解
@Data
public class User {
    @TableField(exist = false)//如果实体类的属性不在表里，那就加这个注解
    private String userName;
    @TableField(exist = false)
    private String password;

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
