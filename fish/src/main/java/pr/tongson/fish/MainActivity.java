package pr.tongson.fish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.tongson.fish.R;

/**
 * http://www.jianshu.com/p/3dd3d1524851
 * http://www.jianshu.com/p/54f78c38a0f0
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivFish= (ImageView) findViewById(R.id.iv_fish);
        ivFish.setImageDrawable(new FishDrawable(this));
    }
}
