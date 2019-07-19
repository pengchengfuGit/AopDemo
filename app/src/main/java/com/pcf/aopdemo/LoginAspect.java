package com.pcf.aopdemo;

import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author crazyZhangxl on 2019/1/28.
 * Describe: 切面
 */
@Aspect
public class LoginAspect {
 
    /**
     * 对含有某个方法的特定注解打上切点
     */
    @Pointcut("execution(@com.pcf.aopdemo.LoginTrace * *(..))")
    public void pointCutLogin(){
 
    }
 
    /**
     * 处理 特定的打上切点的方法
     * @param proceedingJoinPoint
     * @throws Throwable
     */
    @Around("pointCutLogin()")
    public void aroundLogin(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if (false){
            proceedingJoinPoint.proceed();
        }else {
            Toast.makeText(MyApp.getContext(), "请先进行登陆!", Toast.LENGTH_SHORT).show();
        }
 
    }
}