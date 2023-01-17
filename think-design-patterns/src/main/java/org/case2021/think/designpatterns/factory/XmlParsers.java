package org.case2021.think.designpatterns.factory;

/**
 * xml解析器
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">zh</a>
 * @date 2021/04/25
 */
public class XmlParsers implements IRuleConfigParser{

    @Override
    public String load() {
        return "<? xml>";
    }
}
