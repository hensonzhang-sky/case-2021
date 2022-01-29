package org.case2021.think.designpatterns.singleton.case2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 递增ID生成器（懒汉式）
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">zh</a>
 * @date 2022/01/29
 */
public class IdGenerator2 {

    private final AtomicLong id = new AtomicLong(0);
    private static IdGenerator2 instance;

    private IdGenerator2() {
    }

    /**
     * 这里还有个的写法，那就是双重检查锁
     * 当前这种并发几乎没有，就是个串行
     * @return 单例对象实例
     */
    public static synchronized IdGenerator2 getInstance() {
        if (instance == null) {
            instance = new IdGenerator2();
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
                System.out.println(IdGenerator2.getInstance().getId());
            }
        });
        threadA.start();

        Thread threadB = new Thread(() -> {
            for (; ; ) {
                System.out.println(IdGenerator2.getInstance().getId());
            }
        });
        threadB.start();
    }

}
