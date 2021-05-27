package org.case2021.think.designpatterns.proxy.dynamicproxy;


import org.case2021.think.designpatterns.proxy.IProvider;
import org.case2021.think.designpatterns.proxy.SimpleProvider;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 代理执行者对象
 * @author <a href="mailto:hensonzhang@foxmail.com">hensonzhang</a>
 * @date 2021/04/25
 */
public class DynamicProxy implements InvocationHandler {

    Object proxyTarget;

    public Object bind(Object targetObject) {
        this.proxyTarget = targetObject;
        // Create proxy object.
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Dynamic limit");
        return method.invoke(proxyTarget, args);
    }

    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy();
        IProvider provider = (IProvider) dynamicProxy.bind(new SimpleProvider());
        provider.getData("Case 2021 -[Dynamic proxy]");
    }
}
