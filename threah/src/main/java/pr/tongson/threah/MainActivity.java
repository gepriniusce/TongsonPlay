package pr.tongson.threah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mainThreadBtn;
    Button childThreadBtn;
    Button HandlerThreadBtn;
    Button LooperThreadBtn;
    Button AsyncTaskThreadBtn;
    Button JavaThreadThreadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainThreadBtn = (Button) findViewById(R.id.main_thread_btn);
        childThreadBtn = (Button) findViewById(R.id.child_thread_btn);
        HandlerThreadBtn = (Button) findViewById(R.id.Handler_thread_btn);
        LooperThreadBtn = (Button) findViewById(R.id.Looper_thread_btn);
        AsyncTaskThreadBtn = (Button) findViewById(R.id.AsyncTask_thread_btn);
        JavaThreadThreadBtn = (Button) findViewById(R.id.JavaThread_thread_btn);
        mainThreadBtn.setOnClickListener(this);
        childThreadBtn.setOnClickListener(this);
        HandlerThreadBtn.setOnClickListener(this);
        LooperThreadBtn.setOnClickListener(this);
        AsyncTaskThreadBtn.setOnClickListener(this);
        JavaThreadThreadBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.main_thread_btn:
                intent.setClass(this, MainThreadActivity.class);
                startActivity(intent);
                break;
            case R.id.child_thread_btn:
                intent.setClass(this, ChildThreadActivity.class);
                startActivity(intent);
                break;
            case R.id.Handler_thread_btn:
                intent.setClass(this, HandlerActivity.class);
                startActivity(intent);
                break;
            case R.id.Looper_thread_btn:
                intent.setClass(this, LooperActivity.class);
                startActivity(intent);
                break;
            case R.id.AsyncTask_thread_btn:
                intent.setClass(this, AsyncTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.JavaThread_thread_btn:
                intent.setClass(this, JavaThreadActivity.class);
                startActivity(intent);
                break;
        }
    }
}
