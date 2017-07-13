package pr.tongson.threah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AsyncTask2Activity extends AppCompatActivity {
    public static final String TAG = "Tongson AsyncTask2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task2);


        int CPU_COUNT = Runtime.getRuntime().availableProcessors();  //可用的CPU个数
        Log.i(TAG, "CPU_COUNT-->" + CPU_COUNT);
        int CORE_POOL_SIZE = CPU_COUNT + 1; //5(corePoolSize - 池中所保存的线程数，包括空闲线程。)
        Log.i(TAG, "CORE_POOL_SIZE-->" + CORE_POOL_SIZE);
        int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1; //9(maximumPoolSize - 池中允许的最大线程数。)
        Log.i(TAG, "MAXIMUM_POOL_SIZE-->" + MAXIMUM_POOL_SIZE);

        int KEEP_ALIVE = 1;//(keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。)

        //任务队列（128）(workQueue - 执行前用于保持任务的队列。此队列仅由保持 execute 方法提交的 Runnable 任务。)
        final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue<Runnable>(128);

        //线程工厂(threadFactory - 执行程序创建新线程时使用的工厂。)
        ThreadFactory sThreadFactory = new ThreadFactory() {
            private final AtomicInteger mCount = new AtomicInteger(1);

            public Thread newThread(Runnable r) {
                String name = "Thread #" + mCount.getAndIncrement();
                Log.i(TAG, "newThread-->" + name);
                return new Thread(r, name);
            }
        };

        //线程池
        Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
                //(unit - keepAliveTime 参数的时间单位。)
                TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        
        
        /*  如果运行的线程少于 corePoolSize，则 Executor 始终首选添加新的线程，而不进行排队。
            如果运行的线程等于或多于 corePoolSize，则 Executor 始终首选将请求加入队列，而不添加新的线程。
            如果无法将请求加入队列，则创建新的线程，除非创建此线程超出 maximumPoolSize，在这种情况下，任务将被拒绝。*/
        //执行异步任务
        //如果当前线程池中的数量大于corePoolSize，缓冲队列workQueue已满，
        //并且线程池中的数量等于maximumPoolSize，新提交任务由Handler处理。
        //RejectedExecutionException
        for (int i = 0; i < 200; i++) {
            //相当于new AsyncTask().execute();
            THREAD_POOL_EXECUTOR.execute(new MyTask(i));
        }
    }

    static class MyTask implements Runnable {

        int i;

        public MyTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            Log.i(TAG, Thread.currentThread().getName() + ";i:" + i);
        }

    }
}
