package org.case2021.think.designpatterns.factory;

/**
 * json解析器
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">zh</a>
 * @date 2021/04/25
 */
public class JsonParsers implements IRuleConfigParser {
    @Override
    public String load() {
        return "{\"admin\":\"123\"}";
    }
}
