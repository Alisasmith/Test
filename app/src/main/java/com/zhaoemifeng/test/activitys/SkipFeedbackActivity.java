package com.zhaoemifeng.test.activitys;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.zhaoemifeng.test.R;

public class SkipFeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_feedback);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);//返回键，真是的处理事件在onOptionsItemSelected
            actionBar.setTitle("意见反馈");//设置导航菜单的标题
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean ret=true;
        int itemId=item.getItemId();
        switch(itemId){
            case android.R.id.home:
                finish();
                break;
        }
        return ret;
    }
}
