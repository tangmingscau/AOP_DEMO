package com.example.tang.aop_demo;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class SpendTimeAspect {
    @Pointcut("execution(* *.onCreate(..))")
    public void injectSpendCode() {
        //生命所有的类中oncreate方法，作为切入点
    }

    @Around("injectSpendCode()")
    public void aroundOnCreate(ProceedingJoinPoint joinPoint) throws Throwable {
        //插入的代码
        long start = System.currentTimeMillis();
        //执行原来的代码
        Object[] params = joinPoint.getArgs();
        joinPoint.proceed(params);
        //插入的代码
        Log.d("SpendTimeAspect","method spend "+(System.currentTimeMillis()-start));
    }

}
