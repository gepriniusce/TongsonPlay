package pr.tongson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView show= (TextView) findViewById(R.id.show);
        int a=5;
        int b;
        b=++a;
        
        show.setText("b="+b);
//        show.setText("new:"+"b="+b);
        
    }
}
