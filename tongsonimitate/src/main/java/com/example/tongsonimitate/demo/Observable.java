package com.example.tongsonimitate.demo;

import com.example.tongsonimitate.demo.i.OnSubscrible;

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


}
