package pr.tongson.threah.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/7/31<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b>
 * 1、Executors.newFixedThreadPool(10) 初始化一个包含10个线程的线程池executor；
 * 2、通过 executor.execute 方法提交20个任务，每个任务打印当前的线程名；
 * 3、负责执行任务的线程的生命周期都由Executor框架进行管理；<br>
 */

public class ExecutorCase {


    private static Executor executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            executor.execute(new Task());
        }

    }

    private static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
