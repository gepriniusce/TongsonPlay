package pr.tongson.threah;

import android.os.Bundle;

public class ChildThreadActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_thread);
        
        method1();
        method2();
        method3();
    }

    // 1、直接new 一个线程类，传入参数实现Runnable接口的对象（new Runnable），相当于方法二
    private void method1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 写子线程中的操作
                isMainThread();
            }
        }).start();
    }

    // 2、通过实现Runnable接口
    private void method2() {
        Thread t = new Thread(new myRunnable());
        t.start();
    }

    // Runnable是一个接口，需要实现
    public class myRunnable implements Runnable {
        @Override
        public void run() {
            // 写子线程中的操作
            isMainThread();

        }

    }

    // 3、通过继承线程类实现
    private void method3() {
        new myThread().start();
    }

    // Thread是一个类，必须继承
    public class myThread extends Thread {
        @Override
        public void run() {
            super.run();
            // 写子线程中的操作
            isMainThread();
        }
    }

}
