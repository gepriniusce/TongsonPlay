package pr.tongson.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pr.tongson.materialdesign.item.ItemListActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button loginActivityBtn;
    private Button baseActivityBtn;
    private Button fullScreenActivityBtn;
    private Button itemListActivityBtn;
    private Button navigationDrawerActivityBtn;
    private Button scrollingActivityBtn;
    private Button tabbedActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginActivityBtn = (Button) findViewById(R.id.btn_login_activity);
        baseActivityBtn = (Button) findViewById(R.id.btn_base_activity);
        fullScreenActivityBtn = (Button) findViewById(R.id.btn_full_screen_activity);
        itemListActivityBtn = (Button) findViewById(R.id.btn_item_list_activity);
        navigationDrawerActivityBtn = (Button) findViewById(R.id.btn_navigation_drawer_ativity);
        scrollingActivityBtn = (Button) findViewById(R.id.btn_scrolling_ativity);
        tabbedActivityBtn = (Button) findViewById(R.id.btn_tabbed_ativity);


        loginActivityBtn.setOnClickListener(this);
        baseActivityBtn.setOnClickListener(this);
        fullScreenActivityBtn.setOnClickListener(this);
        itemListActivityBtn.setOnClickListener(this);
        navigationDrawerActivityBtn.setOnClickListener(this);
        scrollingActivityBtn.setOnClickListener(this);
        tabbedActivityBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.btn_login_activity:
                i = new Intent(this, LoginActivity.class);
                startActivity(i);
                break;
            case R.id.btn_base_activity:
                i = new Intent(this, BasicActivity.class);
                startActivity(i);
                break;
            case R.id.btn_full_screen_activity:
                i = new Intent(this, FullscreenActivity.class);
                startActivity(i);
                break;
            case R.id.btn_item_list_activity:
                i = new Intent(this, ItemListActivity.class);
                startActivity(i);
                break;
            case R.id.btn_navigation_drawer_ativity:
                i = new Intent(this, NavigationDrawerActivity.class);
                startActivity(i);
                break;
            case R.id.btn_scrolling_ativity:
                i = new Intent(this, ScrollingActivity.class);
                startActivity(i);
                break;
            case R.id.btn_tabbed_ativity:
                i = new Intent(this, TabbedActivity.class);
                startActivity(i);
                break;
        }
    }
}
