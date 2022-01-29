package org.case2021.think.designpatterns.proxy;

/**
 * @author <a href="mailto:hensonzhang@foxmail.com">hensonzhang</a>
 * @date 2021/04/25
 */
public interface IProvider {

    /**
     * 获取数据
     * @param args
     * @return
     */
    Object getData(String args);

}
