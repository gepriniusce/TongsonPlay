package com.example.tongsonimitate;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tongsonimitate.demo.Observable;
import com.example.tongsonimitate.demo.Subscriber;
import com.example.tongsonimitate.demo.i.Func;
import com.example.tongsonimitate.demo.i.OnSubscrible;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    Button cleanBtn;

    private TextView resultTv;
    private SpannableStringBuilder spannableStringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.btn_1);
        button2 = (Button) findViewById(R.id.btn_2);
        button3 = (Button) findViewById(R.id.btn_3);
        cleanBtn = (Button) findViewById(R.id.btn_clean);
        resultTv = (TextView) findViewById(R.id.tv_result);
        spannableStringBuilder = new SpannableStringBuilder();


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        cleanBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                spannableStringBuilder.append("btn_1-------------------\n");
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
                spannableStringBuilder.append("-------------------\n\n");
                resultTv.setText(spannableStringBuilder);
                break;
            case R.id.btn_2:
                /**
                 * 响应式编程
                 */
                spannableStringBuilder.append("btn_2-------------------\n");
                Observable.create(new OnSubscrible<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        spannableStringBuilder.append("Observable -->Subscriber call:" + "1" + "\n");
                        spannableStringBuilder.append("Observable -->Subscriber call:" + "1 ，currentThread:" + Thread.currentThread().getName() + "\n");

                        subscriber.onNext("http://www.baidu.com");
                        spannableStringBuilder.append("Observable -->Subscriber call:" + "5" + "\n");
                        spannableStringBuilder.append("Observable -->Subscriber call:" + "5 ，currentThread:" + Thread.currentThread().getName() + "\n");
                    }
                }).map(new Func<String, Bitmap>() {
                    //具体的转换类型角色
                    @Override
                    public Bitmap call(String s) {
                        spannableStringBuilder.append("map-->OnSubscribleImpl call:" + "s:" + s + "\n");
                        spannableStringBuilder.append("map-->OnSubscribleImpl call:" + "currentThread:" + Thread.currentThread().getName() + "\n");
                        Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.ic_launcher);
                        return bitmap;
                    }
                }).subscrible(new Subscriber<Bitmap>() {
                    @Override
                    public void onNext(Bitmap bitmap) {
                        spannableStringBuilder.append("Subscriber onNext -->" + "\n");
                        spannableStringBuilder.append("Subscriber onNext -->" + "currentThread:" + Thread.currentThread().getName() + "\n");

                    }
                });
                spannableStringBuilder.append("-------------------\n\n");
                resultTv.setText(spannableStringBuilder);
                break;
            case R.id.btn_3:
                spannableStringBuilder.append("btn_3-------------------\n");
                Observable.create(new OnSubscrible<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        spannableStringBuilder.append("Observable -->Subscriber call:" + "1" + "\n");
                        spannableStringBuilder.append("Observable -->Subscriber call:" + "1 ，currentThread:" + Thread.currentThread().getName() + "\n");

                        subscriber.onNext("http://www.baidu.com");
                        spannableStringBuilder.append("Observable -->Subscriber call:" + "5" + "\n");
                        spannableStringBuilder.append("Observable -->Subscriber call:" + "5 ，currentThread:" + Thread.currentThread().getName() + "\n");
                    }
                }).subscribleMain().map(new Func<String, Bitmap>() {
                    //具体的转换类型角色
                    @Override
                    public Bitmap call(String s) {
                        spannableStringBuilder.append("map-->OnSubscribleImpl call:" + "s:" + s + "\n");
                        spannableStringBuilder.append("map-->OnSubscribleImpl call:" + "currentThread:" + Thread.currentThread().getName() + "\n");
                        Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.ic_launcher);
                        return bitmap;
                    }
                }).subscrible(new Subscriber<Bitmap>() {
                    @Override
                    public void onNext(Bitmap bitmap) {
                        spannableStringBuilder.append("Subscriber onNext -->" + "\n");
                        spannableStringBuilder.append("Subscriber onNext -->" + "currentThread:" + Thread.currentThread().getName() + "\n");

                    }
                });
                spannableStringBuilder.append("-------------------\n\n");
                resultTv.setText(spannableStringBuilder);
                break;
            case R.id.btn_clean:
                spannableStringBuilder.clear();
                resultTv.setText(spannableStringBuilder);
                break;
        }
    }
}
