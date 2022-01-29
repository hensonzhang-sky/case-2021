package org.case2021.think.designpatterns.singleton.case2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 递增ID生成器（静态内部类，既能延迟加载又不加锁）
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">zh</a>
 * @date 2022/01/29
 */
public class IdGenerator4 {

    private final AtomicLong id = new AtomicLong(0);
    private IdGenerator4(){}

    private static class SingletonHolder {
        private static final IdGenerator4 instance = new IdGenerator4();
    }

    /**
     * 双重检查锁
     * 这种模式在低版本的jdk中会因为指令重序发生问题，所以一般给instance加个volatile来告诉JDK不要优化
     *
     * @return 单例对象实例
     */
    public static IdGenerator4 getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        // 下面两个线程去调 IdGenerator生成器生成ID会递增，不会出现跳号问题
        Thread threadA = new Thread(() -> {
            for (; ; ) {
                System.out.println(IdGenerator4.getInstance().getId());
            }
        });
        threadA.start();

        Thread threadB = new Thread(() -> {
            for (; ; ) {
                System.out.println(IdGenerator4.getInstance().getId());
            }
        });
        threadB.start();
    }

}
