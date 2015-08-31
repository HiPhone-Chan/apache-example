package com.chf.example.apache.commons.proxy;

public class Main {

    public static void main(String[] args) {

        Class<?>[] classes = new Class[] { Echo.class, Echo2.class };

        MyProxyFactory proxyFactory = new MyProxyFactory(classes);

        System.out.println("--- null ---");
        Object proxy = proxyFactory.nullProxy();
        print(((Echo) proxy).echo("hello"));

        System.out.println("--- ducktyping ---");
        proxy = proxyFactory.duckTypingProxy(FakeEcho.class);
        print(((Echo) proxy).echo("hello"));
        print(((Echo2) proxy).echo2("hello"));

        System.out.println("--- myproxy ---");
        proxy = proxyFactory.myProxy(new EchoImpl());
        print(((Echo) proxy).echo("hello"));
    }

    public static void print(String msg) {
        System.out.println("return :" + msg);
    }
}
