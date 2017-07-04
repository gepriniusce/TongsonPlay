package pr.tongson.threah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class JavaThreadActivity extends AppCompatActivity {
    public static final String TAG = "Tongson JavaThreadActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_thread);
        Object lock = new Object();
        new Producer(lock).start();
        new Consumer(lock).start();
    }


    //产品
    static class ProductObject{
        //线程操作变量可见
        public volatile static String value;
    }

    //生产者线程
    static class Producer extends Thread{
        Object lock;

        public Producer(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            //不断生产产品
            while(true){
                synchronized (lock) { //互斥锁
                    //产品还没有被消费，等待
                    if(ProductObject.value != null){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //产品已经消费完成，生产新的产品
                    ProductObject.value = "NO:"+System.currentTimeMillis();
                    Log.i(TAG,"生产产品："+ProductObject.value);
                    lock.notify(); //生产完成，通知消费者消费
                }
            }

        }
    }

    //消费者线程
    static class Consumer extends Thread{
        Object lock;
        public Consumer(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while(true){
                synchronized (lock) {
                    //没有产品可以消费
                    if(ProductObject.value == null){
                        //等待，阻塞
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Log.i(TAG,"消费产品："+ProductObject.value);
                    ProductObject.value = null;
                    lock.notify(); //消费完成，通知生产者，继续生产
                }
            }
        }
    }
}
