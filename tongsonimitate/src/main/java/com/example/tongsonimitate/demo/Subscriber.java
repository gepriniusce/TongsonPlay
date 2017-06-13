package com.example.tongsonimitate.demo;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/27<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> 订阅者 抽象的技术 <br>
 */
public abstract class Subscriber<T> {


    /**
     * 做功能的行为
     *
     * @param t 功能
     */
    public abstract void onNext(T t);
}
