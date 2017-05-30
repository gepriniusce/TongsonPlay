package com.example.tongsonimitate.demo;

import android.os.Handler;
import android.os.Looper;

import com.example.tongsonimitate.demo.i.OnSubscrible;
import com.example.tongsonimitate.demo.i.Func;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/27<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> 被观察者 <br>
 */

public class Observable<T> {

    /**
     * 接口 回调
     */
    private OnSubscrible<T> onSubscrible;

    /**
     * 构造器
     *
     * @param onSubscrible
     */
    private Observable(OnSubscrible<T> onSubscrible) {
        this.onSubscrible = onSubscrible;
    }


    /**
     * @param onSubscrible
     * @param <T>
     * @return
     */
    public static <T> Observable<T> create(OnSubscrible<T> onSubscrible) {
        return new Observable<>(onSubscrible);
    }


    /**
     * @param subscriber
     */
    public void subscrible(Subscriber<? super T> subscriber) {
        onSubscrible.call(subscriber);
    }

    public <R> Observable<R> map(Func<? super T,? extends R> func)
    {
        return lift(new OperatorMap<>(func));
    }

    public  <R> Observable<R> lift(OperatorMap<T, R> trOperatorMap) {
        return new Observable<>(new OnSubscribleLift<>(onSubscrible,trOperatorMap));
    }

    public  Observable<T> subscribleOnIO()
    {
        return create(new OnSubscribleOnIO<T>(this));
    }
    public Observable<T> subscribleMain()
    {
        return  create(new OnSubscrbleMain<T>(new Handler(Looper.getMainLooper()),this));
    }

}
