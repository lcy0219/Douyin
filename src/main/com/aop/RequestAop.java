package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class RequestAop {
//    this is for testing chatgpt reviewing test 3
//    this is for testing chatgpt reviewing test 3
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.controller.*.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        //System.out.println("URL : " + request.getRequestURL().toString());
        //System.out.println("HTTP_METHOD : " + request.getMethod());
        //System.out.println("CLASS_METHOD : " + jp);
        //System.out.println("ARGS : " + Arrays.toString(jp.getArgs()));
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("Name: " + joinPoint.getTarget().getClass().getName());

        logger.info("Name: " + joinPoint.getTarget().getClass().getName()); //    this is for testing chatgpt reviewing test 4
        logger.info("Name: " + joinPoint.getTarget().getClass().getName()); //    this is for testing chatgpt reviewing test 5
    }
}
