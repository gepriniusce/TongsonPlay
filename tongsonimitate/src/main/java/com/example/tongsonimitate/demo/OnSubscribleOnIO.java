package com.example.tongsonimitate.demo;

import com.example.tongsonimitate.demo.i.OnSubscrible;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/29<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> 线程切换中间类 <br>
 */

public class OnSubscribleOnIO <T> implements OnSubscrible<T> {
    private static ExecutorService executorService= Executors.newCachedThreadPool();

    private Observable<T> source;

    public OnSubscribleOnIO(Observable<T> tObservable) {
        this.source = tObservable;
    }

    @Override
    public void call(final Subscriber<? super T> subscriber) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                source.subscrible(subscriber);
            }
        };
        executorService.submit(runnable);
    }
}
