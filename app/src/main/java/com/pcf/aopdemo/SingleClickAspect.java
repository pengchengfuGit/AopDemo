package com.pcf.aopdemo;

import android.util.Log;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Calendar;

/**
 * 避免连续点击
 */
@Aspect
public class SingleClickAspect {
    private long lastClickTime = 0;
    private String TAG = SingleClickAspect.class.getSimpleName();
    private final long MIN_CLICK_DELAY_TIME = 600;

    @Pointcut("execution(@com..SingleClick * *(..))")
    public void methodAnnotated() {
    }

    @Around("methodAnnotated()")
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {//过滤掉600毫秒内的连续点击
            if (BuildConfig.DEBUG) {
                Log.d(TAG, "点击发生时间:" + currentTime);
            }
            lastClickTime = currentTime;
            //执行原方法
            joinPoint.proceed();
        }
        else
        {
            Toast.makeText(MyApp.getContext(),"点击事件被过滤",Toast.LENGTH_LONG).show();
        }
    }

}