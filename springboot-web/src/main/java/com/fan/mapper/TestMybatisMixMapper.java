package com.fan.mapper;

import com.fan.bean.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMybatisMixMapper {
    @Select("select * from account where id=#{id}")
    public Account getById(Long id);

//设置了useGeneratedKeys为true，就可以获取到自增主键的值
    @Insert("insert into account(`user_id`, `money`) values(#{userId}, #{money})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insertOne(Account account);
}
