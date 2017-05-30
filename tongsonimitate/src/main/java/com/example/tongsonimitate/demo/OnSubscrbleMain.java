package com.example.tongsonimitate.demo;

import android.os.Handler;

import com.example.tongsonimitate.demo.i.OnSubscrible;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/29<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> <br>
 */

public class OnSubscrbleMain<T> implements OnSubscrible<T> {
    private Handler handler;
    private Observable<T> source;

    public OnSubscrbleMain(Handler handler, Observable<T> source) {
        this.handler = handler;
        this.source = source;
    }

    @Override
    public void call(final Subscriber<? super T> subscriber) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                source.subscrible(subscriber);
            }
        });
    }
}
