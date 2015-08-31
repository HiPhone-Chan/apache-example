package com.chf.example.apache.commons.proxy;

import org.apache.commons.proxy.Interceptor;
import org.apache.commons.proxy.Invocation;

public class MyInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MyInterceptor...");
        return invocation.proceed();
    }

}
