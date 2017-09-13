package pr.tongson.wave;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * http://www.jianshu.com/p/c8e70e045133
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RenderingView renderingView = (RenderingView)findViewById(R.id.renderview);
        renderingView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
    }





}
