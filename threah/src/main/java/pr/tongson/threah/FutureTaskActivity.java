package pr.tongson.threah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskActivity extends AppCompatActivity {
    public static final String TAG = "Tongson FutureTaskActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_task);

        Task work = new Task();
        FutureTask<Integer> future = new FutureTask<Integer>(work) {
            //异步任务执行完成，回调
            @Override
            protected void done() {
                try {
                    Log.i(TAG, "done:" + get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };
        //线程池（使用了预定义的配置）
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(future);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        //取消异步任务
//        future.cancel(true);
        try {
            //阻塞，等待异步任务执行完毕
            Log.i(TAG, "" + future.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    //异步任务
    static class Task implements Callable<Integer> {
        //返回异步任务的执行结果
        @Override
        public Integer call() throws Exception {
            int i = 0;
            for (; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(TAG, Thread.currentThread().getName() + "_" + i);
            }
            return i;
        }
    }
}
