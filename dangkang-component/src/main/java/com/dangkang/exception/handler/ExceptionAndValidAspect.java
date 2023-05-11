package com.dangkang.exception.handler;

import com.baidu.unbiz.fluentvalidator.interceptor.FluentValidateInterceptor;
import com.dangkang.application.annotation.ServiceDesc;
import com.dangkang.application.dto.response.AbstractResponse;
import com.dangkang.application.dto.response.MultipleResponse;
import com.dangkang.application.dto.response.Response;
import com.dangkang.exception.DangKangAppException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ProxyMethodInvocation;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @date 2023/1/13 14:42
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
public class ExceptionAndValidAspect {

    @Autowired
    private FluentValidateInterceptor fluentValidateInterceptor;

    public ExceptionAndValidAspect(){
    }
    public static final Logger logger = LoggerFactory.getLogger(ExceptionAndValidAspect.class);

//    @Pointcut("execution(* com.dangkang.app.customercontext.service.*.*(..))")
    @Pointcut(value="@annotation(com.dangkang.exception.annotation.ExceptionAndValid)")
    public void pointcut() {
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object methodResponse;

        try{
            methodResponse = invokeValidate(joinPoint);
        }catch (Throwable e){
            if(logger.isDebugEnabled()){
                logger.debug("around com.dangkang.exception",e);
            }
            return resolveException(joinPoint,e);
        }
        return methodResponse;
    }

    private Object resolveException(JoinPoint joinPoint,Throwable t)  {
        AbstractResponse response;
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method targetMethod = ms.getMethod();

       Class returnType = ms.getReturnType();
       if(returnType == Response.class){
           response = new Response<>();
       }else {
           response = new MultipleResponse<>();
       }

        String serviceCode = "";
        String serviceName = "";

        ServiceDesc serviceDesc = targetMethod.getAnnotation(ServiceDesc.class);
        if(serviceDesc != null){
            serviceCode = serviceDesc.ServiceCode();
            serviceName = serviceDesc.ServiceName();
        }

       if (t instanceof DangKangAppException) {
           //处理应用异常
           DangKangAppException ae = (DangKangAppException) t;
           if (t.getCause() != null) {
               //应用异常是自定义或转换为DangKangAppException，系统异常会内嵌在DangKangAppException中
               logger.error(ae.getDetailMessage(), t); //系统异常error，打印出错详细信息和堆栈
           } else {
               logger.warn(ae.getPromptMessage());//业务异常warn，不打印堆栈
           }
           response.buildFailure(serviceCode, serviceName, ae.getErrorCode(), ae.getPromptMessage());
       } else {
           //未捕获的其他异常
           response.buildUnknownFailure(serviceCode, serviceName, t.getMessage());
       }
       return response;
    }

    private Object invokeValidate(JoinPoint joinPoint) throws Throwable{
        MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint = (MethodInvocationProceedingJoinPoint)joinPoint;
        ProxyMethodInvocation proxyMethodInvocation;
        Field methodInvocation = MethodInvocationProceedingJoinPoint.class.getDeclaredField("methodInvocation");
        // 避免出现不可访问异常
        methodInvocation.setAccessible(true);
        proxyMethodInvocation = (ProxyMethodInvocation)methodInvocation.get(methodInvocationProceedingJoinPoint);
        return fluentValidateInterceptor.invoke(proxyMethodInvocation);
    }
}
