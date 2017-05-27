package com.example.tongsonimitate.demo.i;

import com.example.tongsonimitate.demo.Subscriber;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/27<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> 交换实现者 <br>
 */

public interface OnSubscrible<T> extends Action<Subscriber<? super T>> {
}
