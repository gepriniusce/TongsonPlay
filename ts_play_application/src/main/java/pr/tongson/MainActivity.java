package pr.tongson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pr.tongson.View.Main3Activity;
/**
 * https://juejin.im/entry/58291283a22b9d00696ed518
 * http://www.jianshu.com/p/c83e08dfb6fb
 * */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, Main3Activity.class));
    }
}
