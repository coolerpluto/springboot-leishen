package com.fan.config;

import ch.qos.logback.core.db.DBHelper;
import com.fan.bean.Clazz;
import com.fan.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

//@Configuration表示这个类是配置类
//proxyBeanMethods是来设置容器是单实例非单实例，单实例的意思就是，无论bean组件生成方法调用多少次，都是先去容器看是否有当前组件，
//如果没有就生成该组件，有的话就不生成。
@Import({Student.class})//向容器里添加组件，组件名称默认是类全限定名称
@ImportResource("classpath:applicationContext.xml")//将配置文件的bean标签组件放到容器里
@Configuration(proxyBeanMethods = true)
public class MyConfig {
    @Bean("student")
    public Student studentBean(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setClazz(clazzBean());
        return student;
    }
    @Bean("clazz")
    public Clazz clazzBean(){
        return new Clazz(1,"1班");
    }

}
