package com.example.tongsonimitate.demo;

import com.example.tongsonimitate.demo.i.OnSubscrible;
import com.example.tongsonimitate.demo.i.Operator;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/29<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> ObservableDistinctUntilChanged  OnSubscrible对象交换者 供subscrible(Subscriber<? super T> subscriber)调用 <br>
 * <b>Description:</b>  技术的老大-->分派任务 <br>
 */
public class OnSubscribleImpl<T, R> implements OnSubscrible<R> {

    /**
     * 产品
     */
    OnSubscrible<T> onSubscrible;

    /**
     * 交换操纵者 -->需求换成-->具体的功能
     * extends   返回类型的限定
     * super     参数类型的限定
     * T  需求
     * R 功能
     */
    Operator<? extends R, ? super T> operator;

    public OnSubscribleImpl(OnSubscrible<T> onSubscrible, Operator<? extends R, ? super T> operator) {
        this.onSubscrible = onSubscrible;
        this.operator = operator;
    }

    /**
     * 外部调用
     * 让交换操纵者 返回Subscriber<? super T> tSubscriber
     * 老大  让产品提需求给技术去做功能（分派任务）
     *
     * @param subscriber
     */
    @Override
    public void call(Subscriber<? super R> subscriber) {
        /**
         *  operator  项目组
         *  tSubscriber  技术
         */
        Subscriber<? super T> tSubscriber = operator.call(subscriber);
        /**
         * 老大 直接把产品分派给技术（分派任务）
         */
        onSubscrible.call(tSubscriber);
    }
}
