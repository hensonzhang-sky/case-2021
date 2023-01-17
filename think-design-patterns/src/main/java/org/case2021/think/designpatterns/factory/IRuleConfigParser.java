package org.case2021.think.designpatterns.factory;

/**
 * 配置转换器定义
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">zh</a>
 * @date 2021/04/25
 */
public interface IRuleConfigParser {


    /**
     * 定义的转换器，实现这个定义的类
     * @return 内容
     */
    String load();


}
