package org.case2021.think.designpatterns.singleton.case2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 递增ID生成器（双重检查模式+局部变量接收，目的就是为了少访问一次volatile修饰过的变量，因为访问这个变量需要访问操作系统的主存）
 * https://www.javacodemonk.com/threadsafe-singleton-design-pattern-java-806ad7e6
 * https://docs.oracle.com/javase/specs/jls/se8/html/index.html
 * https://www.jianshu.com/p/aa6a9a7035a9
 * <p>
 * Using localRef, we are reducing the access of volatile variable to just one for positive usecase.
 * If we do not use localRef, then we would have to access volatile variable twice - once for checking null and then at method return time.
 * Accessing volatile memory is quite an expensive affair because it involves reaching out to main memory.
 * </p>
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">zh</a>
 * @date 2022/01/29
 */
public class IdGenerator3_1 {

    private final AtomicLong id = new AtomicLong(0);
    private static volatile IdGenerator3_1 instance;

    private IdGenerator3_1() {
    }

    /**
     * 双重检查锁
     * 这种模式在低版本的jdk中会因为指令重序发生问题，所以一般给instance加个volatile来告诉JDK不要优化
     *
     * @return 单例对象实例
     */
    public static IdGenerator3_1 getInstance() {
        // 这里用个变量接收下，下面的if就不用在从主存取instance的值了
        IdGenerator3_1 localRef = instance;
        if (localRef == null) {
            synchronized (IdGenerator3_1.class) {
                // 在接收下值，上面段代码可能有线程进来搞过，所以在接收下
                localRef = instance;
                if (localRef == null) {
                    localRef = new IdGenerator3_1();
                    instance = localRef;
                }
            }
        }
        // 注意这里返回的是局部变量，不用等到cpu把instance强刷到主存
        return localRef;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        // 下面两个线程去调 IdGenerator生成器生成ID会递增，不会出现跳号问题
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                System.out.println(IdGenerator3_1.getInstance().getId());
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                System.out.println(IdGenerator3_1.getInstance().getId());
            }
        });
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long start = System.currentTimeMillis();
        executorService.execute(threadB);
        executorService.execute(threadA);
    }

}
