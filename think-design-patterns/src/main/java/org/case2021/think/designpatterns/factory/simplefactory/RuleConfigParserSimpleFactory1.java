package org.case2021.think.designpatterns.factory.simplefactory;


import org.case2021.think.designpatterns.factory.IRuleConfigParser;
import org.case2021.think.designpatterns.factory.JsonParsers;
import org.case2021.think.designpatterns.factory.XmlParsers;

import java.util.HashMap;
import java.util.Map;

/**
 * 这种方式注册parser是在静态块实现的，不能从外部接收parser，要加parser就要改静态块代码，这就叫不符合开闭原则？懂吗？
 * 相反 RuleConfigParserSimpleFactory是可以从外部接收parser的
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">zh</a>
 * @date 2021/04/25
 */
public class RuleConfigParserSimpleFactory1 {

    private static final Map<String, IRuleConfigParser> CACHED_PARSERS = new HashMap<>();

    static {
        CACHED_PARSERS.put("json",new JsonParsers());
        CACHED_PARSERS.put("xml",new XmlParsers());
    }

    public static IRuleConfigParser configParser(String configFormat){
        if (configFormat==null || configFormat.isEmpty()){
            // null或者throw exception随便
            return null;
        }
        return CACHED_PARSERS.get(configFormat.toLowerCase());
    }

    public static void main(String[] args) {
        IRuleConfigParser parser = RuleConfigParserSimpleFactory1.configParser("json");
        System.out.println(parser.load());
    }
}
