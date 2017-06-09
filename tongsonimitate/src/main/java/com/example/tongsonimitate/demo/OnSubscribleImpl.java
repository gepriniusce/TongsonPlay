package com.example.tongsonimitate.demo;

import com.example.tongsonimitate.demo.i.OnSubscrible;
import com.example.tongsonimitate.demo.i.Operator;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/29<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> OnSubscrible对象交换者 供subscrible(Subscriber<? super T> subscriber)调用 <br>
 */
public class OnSubscribleImpl<T, R> implements OnSubscrible<R> {

    //
    OnSubscrible<T> onSubscrible;

    // 交换操纵者
    //extends 返回类型的限定
    //super   参数类型的限定
    Operator<? extends R, ? super T> operator;

    public OnSubscribleImpl(OnSubscrible<T> onSubscrible, Operator<? extends R, ? super T> operator) {
        this.onSubscrible = onSubscrible;
        this.operator = operator;
    }

    /**
     * 外部调用
     * 让交换操纵者 返回Subscriber<? super T> tSubscriber
     *
     * @param subscriber
     */
    @Override
    public void call(Subscriber<? super R> subscriber) {
        Subscriber<? super T> tSubscriber = operator.call(subscriber);
        //OnSubscrible的交换
        onSubscrible.call(tSubscriber);
    }
}
