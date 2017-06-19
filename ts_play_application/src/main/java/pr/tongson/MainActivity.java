package pr.tongson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import pr.tongson.common.DataProperties;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Tongson MainActivity";

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.btn_enter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //                send();

                //                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                //                startActivity(intent);

//                DataProperties.newInstance(getApplicationContext()).set("666", "666");
                Log.d(TAG, "value:" + DataProperties.newInstance(getApplicationContext()).get("666"));
                Log.d(TAG, "value:" + DataProperties.newInstance(getApplicationContext()).get("555"));
            }
        });
    }

    private void send() {
        Intent intent2 = new Intent();
        intent2.setAction("android.intent.action.TONGSONBS");
        intent2.putExtra("msg", "hello receiver.");
        sendBroadcast(intent2);
    }
}
