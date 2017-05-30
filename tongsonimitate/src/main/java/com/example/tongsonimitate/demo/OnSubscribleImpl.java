package com.example.tongsonimitate.demo;

import com.example.tongsonimitate.demo.i.OnSubscrible;
import com.example.tongsonimitate.demo.i.Operator;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/29<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> <br>
 */
public class OnSubscribleImpl<T,R> implements OnSubscrible<R> {


    OnSubscrible<T> onSubscrible;
    Operator<? extends R,? super T> operator;

    public OnSubscribleImpl(OnSubscrible<T> onSubscrible, Operator<? extends R, ? super T> operator) {
        this.onSubscrible = onSubscrible;
        this.operator = operator;
    }

    @Override
    public void call(Subscriber<? super R> subscriber) {
        Subscriber<? super  T> tSubscriber=operator.call(subscriber);
        onSubscrible.call(tSubscriber);
    }
}
