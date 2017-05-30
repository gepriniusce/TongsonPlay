package com.example.tongsonimitate.demo;

import com.example.tongsonimitate.demo.i.Func;
import com.example.tongsonimitate.demo.i.Operator;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/27<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b>操纵者<br>
 */

public class OperatorMap<T, R> implements Operator<R, T> {
    Func<? super T, ? extends R> transformer;

    public OperatorMap(Func<? super T, ? extends R> transformer) {
        this.transformer = transformer;
    }

    @Override
    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        return new MapSubscrible<>(subscriber, transformer);
    }

    private class MapSubscrible<T, R> extends Subscriber<T> {

        private Subscriber<? super R> actual;

        private Func<? super T, ? extends R> mapper;


        public MapSubscrible(Subscriber<? super R> actual, Func<? super T, ? extends R> mapper) {
            this.actual = actual;
            this.mapper = mapper;
        }

        @Override
        public void onNext(T t) {
            R r = mapper.call(t);
            actual.onNext(r);
        }
    }
}
