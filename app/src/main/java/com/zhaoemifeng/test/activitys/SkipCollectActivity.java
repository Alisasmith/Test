package com.zhaoemifeng.test.activitys;

import android.support.annotation.DrawableRes;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.zhaoemifeng.test.R;

public class SkipCollectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_collect);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);

            actionBar.setTitle("我的收藏");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_skip_collect, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean ret = true;
        int itemId = item.getItemId();
        switch (itemId) {
            //因为搜索使用了searchView，所以，不需要再进行点击检查了
//            case R.id.action_search:
//                //Toast.makeText(MainActivity.this, "搜索功能", Toast.LENGTH_SHORT).show();
//                break;
            case android.R.id.home://对应：setDisplayHomeAsUpEnabled
                finish();
                break;
        }
        return ret;
    }
}



