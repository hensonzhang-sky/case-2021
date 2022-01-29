package org.case2021.think.designpatterns.singleton.case2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 递增ID生成器（基于枚举实现）
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">zh</a>
 * @date 2022/01/29
 */
public enum IdGenerator5 {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId(){
        return INSTANCE.id.incrementAndGet();
    }

    public static void main(String[] args) {
        // 下面两个线程去调 IdGenerator生成器生成ID会递增，不会出现跳号问题
        Thread threadA = new Thread(() -> {
            for (; ; ) {
                System.out.println(IdGenerator5.INSTANCE.getId());
            }
        });
        threadA.start();

        Thread threadB = new Thread(() -> {
            for (; ; ) {
                System.out.println(IdGenerator5.INSTANCE.getId());
            }
        });
        threadB.start();
    }

}
