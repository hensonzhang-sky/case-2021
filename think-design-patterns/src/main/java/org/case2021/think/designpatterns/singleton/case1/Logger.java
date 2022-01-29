package org.case2021.think.designpatterns.singleton.case1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 日志单例case，多个线程往一个文件（共享资源）写数据
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">zh</a>
 * @date 2022/01/29
 */
public class Logger {

    private FileWriter writer;
    private static final Logger instance = new Logger();

    private Logger() {
        File file = new File("/Users/henson/cache_db/Logger.txt");
        try {
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) throws IOException {
        // 这玩意其实是个synchronized(this)
        writer.write(message);
    }

    public static void main(String[] args) throws IOException {

        Thread threadA = new Thread(() -> {
            for (; ; ) {
                try {
                    Logger.getInstance().log("Hello world");
                    System.out.println("线程A");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();

        Thread threadB = new Thread(() -> {
            for (; ; ) {
                try {
                    Logger.getInstance().log("Hello world");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        threadB.start();
    }


}
