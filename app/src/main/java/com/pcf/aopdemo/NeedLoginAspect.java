package com.pcf.aopdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class NeedLoginAspect {

    @Pointcut("execution(" +//执行语句
            "@com.pcf.aopdemo.NeedLogin" +//注解筛选
            " * " + //类路径,*为任意路径
            "*" +   //方法名,*为任意方法名
            "(..)" +//方法参数,'..'为任意个任意类型参数
            ")" +
            " && " +//并集
            "@annotation(needLogin)"//注解筛选,这里主要用于下面方法的'NeedLogin'参数获取
    )
    public void pointcutNeedLogin(NeedLogin needLogin) {

    }

    @Around("pointcutNeedLogin(needLogin)")
    public void aroundNeedLogin(ProceedingJoinPoint joinPoint, final NeedLogin needLogin) throws Throwable {
        if (false) {
            //方法执行
            joinPoint.proceed();
        } else {
            final Context context = MyApp.getContext();
            switch (needLogin.tipType()) {
                case NeedLogin.SHOW_TOAST:
                    Toast.makeText(context, needLogin.tipToast(), Toast.LENGTH_SHORT).show();
                    break;
                case NeedLogin.SHOW_DIALOG:
                    /*
                        判断context是否为Activity
                        如果不是 , 使用Dialog会crash
                     */
                    if (context instanceof Activity) {
                        new AlertDialog.Builder(context)
                                .setTitle("登录提示")
                                .setMessage(needLogin.tipDialog())
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .setPositiveButton("前往登录", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        Intent intent = new Intent(context, needLogin.loginActivity());
                                        context.startActivity(intent);
                                    }
                                }).show();
                    } else {
                        // 这里处理直接跳到登录界面
                        Toast.makeText(context, needLogin.tipToast(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, needLogin.loginActivity());
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                    break;
                //无响应类型
                case NeedLogin.NO_RESPONSE:
                default:
                    break;
            }
        }
    }

}