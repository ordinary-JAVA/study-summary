package com.example.test.test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lizongren
 * @create 2020.05.20 18:51
 */

public class NormalHandler implements InvocationHandler {

    private Object target;

    public NormalHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("man say invoked at : " + System.currentTimeMillis());
        method.invoke(target, args);
        return null;
    }

    public static void main(String[] args) {
        IPerson iPerson = new Man();

        NormalHandler normalHandler = new NormalHandler(iPerson);
        IPerson iPerson1 = (IPerson) Proxy.newProxyInstance(IPerson.class.getClassLoader(),
                new Class[] {IPerson.class}, normalHandler);
        iPerson1.say();
    }
}
