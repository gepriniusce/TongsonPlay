package com.example.tongsonimitate.demo;

import com.example.tongsonimitate.demo.i.Func;
import com.example.tongsonimitate.demo.i.Operator;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/27<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> 方法交换操纵者 项目组 具体的观察者-->具体的产品<br>
 * 项目组
 * T  需求
 * R  功能
 */
public class OperatorMap<T, R> implements Operator<R, T> {

    Func<? super T, ? extends R> transformer;

    public OperatorMap(Func<? super T, ? extends R> transformer) {
        this.transformer = transformer;
    }

    @Override
    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        /**
         * 返回 Subscriber<? super T> 对象
         */
        return new MapSubscriber<>(subscriber, transformer);
    }

    /**
     * 具体的技术
     *
     * @param <T>
     * @param <R>
     */
    private class MapSubscriber<T, R> extends Subscriber<T> {

        private Subscriber<? super R> actual;

        private Func<? super T, ? extends R> mapper;

        public MapSubscriber(Subscriber<? super R> actual, Func<? super T, ? extends R> mapper) {
            this.actual = actual;
            this.mapper = mapper;
        }


        @Override
        public void onNext(T t) {
            /**
             * Map中call方法的调用
             */
            R r = mapper.call(t);
            /**
             * Subscriber<? super R> 对象中的方法的调用  技术-->做功能
             */
            actual.onNext(r);
        }
    }
}