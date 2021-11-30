package com.fan.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@ConfigurationProperties(prefix = "person")
@ToString
@Data
public class Person {
    private String userName;
    private boolean boss;
    private Date birth;
    private Integer age;
    private Car car;
    private String[] interests;
    private List<String> animal;
    private Map<String, Object> score;
    private Set<Double> salaries;
    private Map<String, List<Car>> allCars;
}
