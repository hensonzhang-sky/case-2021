package org.case2021.think.designpatterns.solid.srp;

/**
 * Open close Principle(对扩展开放，对修改关闭)
 * 添加新的功能应该是在已有的代码基础上扩展的代码（增加模块，类，方法等），而非修改已有代码（模块、类、方法等）
 *
 *
 *
 *
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">hensonzhang</a>
 * @date 2021/06/04
 */
public class Ocp {


    /**
     * 此方法如果要增加个功能（加个参数，方法体加个if ）那么需要改动方法内部实现，其次调用者也要修改，单元测试也要调整；
     * @see https://time.geekbang.org/column/article/176075
     * 如果遵循"开闭原则"该如何实现？
     * 1、将方法参数封装成对象
     * 2、将方法体的if判断改成handler的方式，将每个if的实现分布在各个handler中
     * 3、可提供一个单例实例调用
     * @param api
     * @param requestCount
     * @param errorCount
     * @param durationOfSeconds
     */
    public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {
        long tps = requestCount / durationOfSeconds;
        long maxTps = 1000L;
        if(tps > maxTps){
            // 通知告警
        }
        long maxErrorCount = 1L;
        if(errorCount > maxErrorCount){
            // 通知告警
        }
    }



}
