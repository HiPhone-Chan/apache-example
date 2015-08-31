package com.chf.example.apache.commons.proxy;

import java.lang.reflect.Method;

import org.apache.commons.proxy.Invoker;

public class MyInvoker implements Invoker {

    private final Object target;

    public MyInvoker(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result = method.invoke(target, args);
        return result;
    }
}
