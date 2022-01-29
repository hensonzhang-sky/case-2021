package org.case2021.think.designpatterns.singleton.case2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 递增ID生成器（饿汉式）
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">zh</a>
 * @date 2022/01/29
 */
public class IdGenerator {

    private final AtomicLong id = new AtomicLong(0);
    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        // 下面两个线程去调 IdGenerator生成器生成ID会递增，不会出现跳号问题
        Thread threadA = new Thread(() -> {
            for (; ; ) {
                System.out.println(IdGenerator.getInstance().getId());
            }
        });
        threadA.start();

        Thread threadB = new Thread(() -> {
            for (; ; ) {
                System.out.println(IdGenerator.getInstance().getId());
            }
        });
        threadB.start();
    }

}
