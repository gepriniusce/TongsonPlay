package pr.tongson.pluginmodule.recyclerviewutils;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pr.tongson.pluginmodule.R;

public class MainActivity extends Activity {

    private WrapRecyclerView recylerview;
    private ArrayList<String> list;
    private MyRecyclerAdapter adapter;
    //	private MyStaggedRecyclerAdapter adapter;
    private ItemDecoration decor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<String>();
        for (int i = 0; i < 60; i++) {
            list.add("item" + i);
        }

        recylerview = (WrapRecyclerView) findViewById(R.id.recylerview);
        TextView headerView = new TextView(this);
        //		TextView tv = headerView.findViewById(id);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        headerView.setLayoutParams(params);
        headerView.setText("我是HeaderView");
        recylerview.addHeaderView(headerView);

        TextView footerView = new TextView(this);
        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        footerView.setLayoutParams(params);
        footerView.setText("我是FooterView");
        recylerview.addFooterView(footerView);


        adapter = new MyRecyclerAdapter(list);
//		adapter = new MyStaggedRecyclerAdapter(list);
        //LayoutManager布局摆放管理器(线性摆放、瀑布流)
//		recylerview.setLayoutManager(new LinearLayoutManager(this));//默认垂直
//        reverseLayout:数据倒置，从右边开始滑动
        recylerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
//        recylerview.setLayoutManager(new GridLayoutManager(this, 3));
        //瀑布流效果
//		recylerview.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
        recylerview.setAdapter(adapter);

        decor = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recylerview.addItemDecoration(decor);

        recylerview.setItemAnimator(new DefaultItemAnimator());
        adapter.setOnItemClickListener(new MyRecyclerAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "点我干嘛" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }


}
