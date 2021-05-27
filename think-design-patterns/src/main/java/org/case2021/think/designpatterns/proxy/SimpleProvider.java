package org.case2021.think.designpatterns.proxy;

/**
 * 被代理的对象
 * @author <a href="mailto:hensonzhang@foxmail.com">hensonzhang</a>
 * @date 2021/04/25
 */
public class SimpleProvider implements IProvider {
    @Override
    public Object getData(String args) {
        System.out.println("Request data is :" + args);
        return args;
    }
}
