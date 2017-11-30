package pr.tongson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        HttpRequest httpRequest=new HttpRequest();
        
        getLifecycle().addObserver(httpRequest);
    }
}
