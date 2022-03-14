package com.fan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.bean.User;

//BaseMapper是mybatis-plus封装集成的有增删改查接口的类，使用泛型，填写要使用的实体bean类
//然后就可以使用增删改查了，UserMapper userMapper,在@Autowired一下就可以了
public interface UserMapper extends BaseMapper<User> {
}
