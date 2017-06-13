package com.example.tongsonimitate.demo.i;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/27<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> 代码-->转化成-->产品的效果 <br>
 */

public interface Func<T, R> {
    R call(T t);
}
