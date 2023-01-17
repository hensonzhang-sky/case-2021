package org.case2021.think.designpatterns.factory.simplefactory;


import org.case2021.think.designpatterns.factory.IRuleConfigParser;
import org.case2021.think.designpatterns.factory.JsonParsers;
import org.case2021.think.designpatterns.factory.XmlParsers;

import java.util.HashMap;
import java.util.Map;

/**
 * 和RuleConfigParserSimpleFactory1相比，取消了静态块，改成可以从外部接收parser，这就叫符合开闭
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">zh</a>
 * @date 2021/04/25
 */
public class RuleConfigParserSimpleFactory {

    private static final Map<String, IRuleConfigParser> CACHED_PARSERS = new HashMap<>();

    /**
     * 注册Parsers
     * @param parsersName 转换器名称
     * @param parsersObject 转换器对象
     */
    public static void registerParsers(String parsersName,IRuleConfigParser parsersObject){
        CACHED_PARSERS.put(parsersName, parsersObject);
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            // null或者throw exception随便
            return null;
        }
        return CACHED_PARSERS.get(configFormat.toLowerCase());
    }

    public static void main(String[] args) {
        // 注册到工厂
        RuleConfigParserSimpleFactory.registerParsers("json",new JsonParsers());
        RuleConfigParserSimpleFactory.registerParsers("xml",new XmlParsers());

        // 根据名称创建解析器
        IRuleConfigParser json = RuleConfigParserSimpleFactory.createParser("json");
        IRuleConfigParser xml = RuleConfigParserSimpleFactory.createParser("xml");

        System.out.println(json.load());

        System.out.println(xml.load());
    }


}
