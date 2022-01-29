package org.case2021.think.designpatterns.singleton.case2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 递增ID生成器（双重检查模式，关键点是给一把Class级别的锁，然后给instance加个volatile关键字）
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">zh</a>
 * @date 2022/01/29
 */
public class IdGenerator3 {

    private final AtomicLong id = new AtomicLong(0);
    private static volatile IdGenerator3 instance;

    private IdGenerator3() {
    }

    /**
     * 双重检查锁
     * 这种模式在低版本的jdk中会因为指令重序发生问题，所以一般给instance加个volatile来告诉JDK不要优化
     *
     * @return 单例对象实例
     */
    public static IdGenerator3 getInstance() {
        if (instance == null) {
            synchronized (IdGenerator3.class) {
                if (instance == null) {
                    instance = new IdGenerator3();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        // 下面两个线程去调 IdGenerator生成器生成ID会递增，不会出现跳号问题
        Thread threadA = new Thread(() -> {
            for (; ; ) {
                System.out.println(IdGenerator3.getInstance().getId());
            }
        });
        threadA.start();

        Thread threadB = new Thread(() -> {
            for (; ; ) {
                System.out.println(IdGenerator3.getInstance().getId());
            }
        });
        threadB.start();
    }

}
