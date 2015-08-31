package com.chf.example.apache.commons.proxy;

import org.apache.commons.proxy.ObjectProvider;
import org.apache.commons.proxy.ProxyFactory;
import org.apache.commons.proxy.invoker.DuckTypingInvoker;
import org.apache.commons.proxy.invoker.NullInvoker;
import org.apache.commons.proxy.provider.BeanProvider;

public class MyProxyFactory {

    private ProxyFactory factory;

    private Class<?>[] classes;

    public MyProxyFactory(Class<?>[] classes) {
        factory = new ProxyFactory();
        this.classes = classes;
    }

    public Object nullProxy() {
        NullInvoker ullInvoker = new NullInvoker();
        return factory.createInvokerProxy(ullInvoker, classes);
    }

    public Object duckTypingProxy(Class<?> duckclz) {
        ObjectProvider provider = new BeanProvider(duckclz);
        DuckTypingInvoker duckTypingInvoker = new DuckTypingInvoker(provider);
        return factory.createInvokerProxy(duckTypingInvoker, classes);
    }

    public Object myProxy(Object target) {
        MyInterceptor interceptor = new MyInterceptor();
        return factory.createInterceptorProxy(target, interceptor, classes);
    }

}
