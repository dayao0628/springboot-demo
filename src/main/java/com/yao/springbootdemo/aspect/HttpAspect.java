package com.yao.springbootdemo.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * <p>
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/22 23:42
 */
@Aspect
@Component
public class HttpAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut(value = "execution(public * com.yao.springbootdemo.controller.*.*(..))")
    public void httpLog() {
        //有代码也不执行 需要是空方法
    }

    @Before(value = "httpLog()")
    public void doHttpBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = Objects.requireNonNull((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletRequest request = requestAttributes.getRequest();

        logger.info("URL = {}", request.getRequestURL());
        logger.info("Method Type = {}", request.getMethod());
        logger.info("Remote IP = {}", request.getRemoteAddr());
        logger.info("Class Method = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("Method args = {}", joinPoint.getArgs());
    }

    @After(value = "httpLog()")
    public void testAfter() {
        logger.info("===========testAfter success===========");
    }

    @AfterReturning(returning = "response", pointcut = "httpLog()")
    public void doHttpAfterReturning(Object response) {
        logger.info("response={}", JSON.toJSONString(response));
    }

    @AfterThrowing(throwing = "throwable", pointcut = "httpLog()")
    public void doHttpAfterThrowing(Throwable throwable) {
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        StringBuilder errorInfo = new StringBuilder();
        for (StackTraceElement element : stackTrace) {
            errorInfo.append(element).append("\n");
        }
        logger.info("error detail info={}", errorInfo.toString());
        logger.info("error info={}", throwable.getMessage());
    }


}
