package com.yao.springbootdemo.controller;

import com.yao.springbootdemo.properties.NetworkProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>Hello SpringBoot Controller
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/21 10:28
 */
@RestController
public class HelloController {

    /**
     * 从配置文件中读取user的值
     * user-name , userName 通过@Value注入似乎是一个关键字 取得是默认的系统用户
     */
    @Value("${user}")
    private String user;

    /**
     * 从配置文件中读取age的值
     */
    @Value("${age}")
    private Integer age;

    /**
     * 从配置文件中注入birthday时间类型的值
     */
    @Value("${birthday}")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    /**
     * 从配置文件中读取值中值
     */
    @Value("${content}")
    private String content;

    /**
     * 从配置文件中读取对象
     */
    @Autowired
    private NetworkProperties networkProperties;

    /**
     * 从配置文件中获取对象属性中的值
     */
    @Value("${network.host}")
    private String host;

    /**
     * SpringBoot的Hello World
     *
     * @return Hello Spring Boot
     */
    @RequestMapping(value = {"/hello", "/hi"}, method = {RequestMethod.GET})
    public String sayHello() {
        StringBuffer hello = new StringBuffer();
        hello.append("Hello Spring Boot!").append("<br/>");
        hello.append("userName is: " + user + ", age is: " + age).append("<br/>");
        hello.append("birthday is: " + birthday.toString()).append("<br/>");
        hello.append(content).append("<br/>");
        hello.append(networkProperties.toString()).append("<br/>");
        return hello.toString();
    }
}
