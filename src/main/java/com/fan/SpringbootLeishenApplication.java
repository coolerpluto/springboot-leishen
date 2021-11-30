package com.fan;

import com.fan.bean.Clazz;
import com.fan.bean.Student;
import com.fan.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootLeishenApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootLeishenApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println("组件数量==="+beanDefinitionCount);

//        MyConfig bean = run.getBean(MyConfig.class);
//        Student student1 = bean.studentBean();
//        Student student2 = bean.studentBean();
//        System.out.println(student1 == student2);

//        MyConfig config = run.getBean(MyConfig.class);
//        Student student = config.studentBean();
//        Clazz clazz = config.clazzBean();
//        System.out.println(student.getClazz() == clazz);


//        Student student = run.getBean("student", Student.class);
//        Clazz clazz = run.getBean("clazz", Clazz.class);
//        System.out.println(student.getClazz() == clazz);

//        MyConfig config1 = new MyConfig();
//        Clazz clazz1 = config1.clazzBean();
//        System.out.println("===");
//        System.out.println(config == config1);
//        System.out.println("===");
//        System.out.println(clazz == clazz1);

    }

}
