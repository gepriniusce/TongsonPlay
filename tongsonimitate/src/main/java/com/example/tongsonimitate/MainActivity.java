package com.example.tongsonimitate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

import com.example.tongsonimitate.demo.Observable;
import com.example.tongsonimitate.demo.Subscriber;
import com.example.tongsonimitate.demo.i.OnSubscrible;

public class MainActivity extends AppCompatActivity {

    private TextView resultTv;
    private SpannableStringBuilder spannableStringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = (TextView) findViewById(R.id.tv_result);
        spannableStringBuilder = new SpannableStringBuilder();
        /**
         *
         */
        Observable.create(new OnSubscrible<String>() {//接口
            @Override
            public void call(Subscriber<? super String> subscriber) {
                spannableStringBuilder.append("Observable -->Subscriber call" + "\n");
                subscriber.onNext("该醒醒了");
            }
            //Subscriber    1
            //new Subscriber  2  订阅与发布
        }).subscrible(new Subscriber<String>() {//通过订阅方法
            @Override
            public void onNext(String s) {
                spannableStringBuilder.append("Subscriber onNext -->" + "\n");
                spannableStringBuilder.append("result:" + s + "\n");
            }
        });
        resultTv.setText(spannableStringBuilder);
    }
}
