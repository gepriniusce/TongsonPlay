package com.example.tongsonimitate.demo.i;

import com.example.tongsonimitate.demo.Subscriber;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/27<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> 观察者 <br>
 */

public interface Operator<T, R> extends Func<Subscriber<? super T>, Subscriber<? super R>> {
}
