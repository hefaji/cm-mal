package com.xiaobaidu.mall.aop;

import com.google.common.collect.Maps;
import com.xiaobaidu.mall.util.JsonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * 切面类，用于记录service方法的入参，出参
 * @author hefaji
 * @create 2017-11-20 18:18
 **/
@Component
@Aspect
public class ServiceAop {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 切入点
     */
    @Pointcut("execution(* com.xiaobaidu.mall.service..*.*(..))")
    public void executeService(){

    }

    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        String method =signature.getName();
        //AOP代理类的名字
        String className = signature.getDeclaringTypeName();
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,String> parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }
        String str = JsonUtils.object2String(parameterMap);
        logger.info(className+"."+method+"请求参数："+str);
    }


    @AfterReturning(value = "execution(* com.xiaobaidu.mall.service..*.*(..))",returning = "keys")
    public void AfterExec(JoinPoint joinPoint,Object keys) {
        //pointcut是对应的注解类   keys就是方法运行完之后要返回的值
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        String method =signature.getName();
        //AOP代理类的名字
        String className = signature.getDeclaringTypeName();
        String str = JsonUtils.object2String(keys);
        logger.info(className+"."+method+"响应结果："+str);
    }
}
