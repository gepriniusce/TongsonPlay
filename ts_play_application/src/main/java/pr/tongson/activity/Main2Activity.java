package pr.tongson.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pr.tongson.R;
import pr.tongson.utils.DisplayMetricsUtil;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initMyView();
        initCount();
    }

    private void initCount() {
        TextView resultTv = findViewById(R.id.tv_result);
        resultTv.setTextSize(DisplayMetricsUtil.dp2sp(getApplicationContext(), 30));
        resultTv.setText("66666666666666");
        Button resultbtn = findViewById(R.id.btn_result);
        resultbtn.setTextSize(30);
        resultbtn.setText("66666666666666");
        TextView wrapTv = findViewById(R.id.tv_wrap_content);
        wrapTv.setText("" +  wrapTv.getTextSize());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void initMyView() {
        DisplayMetrics dm = getResources().getDisplayMetrics();

        StringBuffer stringBuffer = new StringBuffer();

        //        // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）  
        //        float density = dm.density;
        //
        //        stringBuffer.append("density").append(":").append(density).append("\n");
        //
        //        // 屏幕密度（每寸像素：120/160/240/320）  
        //        int densityDPI = dm.densityDpi;
        //        stringBuffer.append("densityDpi").append(":").append(densityDPI).append("\n");
        //        
        //        float scaledDensity = dm.scaledDensity;
        //        stringBuffer.append("scaledDensity").append(":").append(scaledDensity).append("\n");
        //
        //        float xdpi = dm.xdpi;
        //        float ydpi = dm.ydpi;
        //        stringBuffer.append("xdpi").append(":").append(xdpi).append("\n");
        //        stringBuffer.append("ydpi").append(":").append(ydpi).append("\n");
        //
        //        // 屏幕宽（像素，如：480px）  
        //        int screenWidth = dm.widthPixels;
        //        // 屏幕高（像素，如：800px）  
        //        int screenHeight = dm.heightPixels;
        //
        //
        //        stringBuffer.append("screenWidth").append(":").append(screenWidth).append("\n");
        //        stringBuffer.append("screenHeight").append(":").append(screenHeight).append("\n");
        //        
        //
        //        // 屏幕宽（px，如：480px）  
        //        screenWidth  = (int)(dm.widthPixels / density + 0.5f);
        //        // 屏幕高（px，如：800px） 
        //        screenHeight = (int)(dm.heightPixels / density + 0.5f);
        //
        //        stringBuffer.append("screenWidth").append(":").append(screenWidth).append("\n");
        //        stringBuffer.append("screenHeight").append(":").append(screenHeight).append("\n");

        stringBuffer.append(dm.toString());
        stringBuffer.append("densityDpi:" + dm.densityDpi);
        TextView screenMsgTv = findViewById(R.id.tv_screen_msg);
        screenMsgTv.setText(stringBuffer);
    }
}