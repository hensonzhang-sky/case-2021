package org.case2021.think.designpatterns.proxy.staticproxy;

import org.case2021.think.designpatterns.proxy.IProvider;
import org.case2021.think.designpatterns.proxy.SimpleProvider;

/**
 * @author <a href="mailto:hensonzhang@foxmail.com">hensonzhang</a>
 * @date 2021/04/25
 */
public class StaticProviderProxy implements IProvider {

    IProvider iProvider;

    public StaticProviderProxy(IProvider iProvider) {
        this.iProvider = iProvider;
    }

    @Override
    public Object getData(String args) {
        // limit
        System.out.println("Static proxy limit");
        return iProvider.getData(args);
    }

    public static void main(String[] args) {
        IProvider provider = new StaticProviderProxy(new SimpleProvider());
        provider.getData("Case 2021 -[Static proxy]");
    }
}
