package com.zhaoemifeng.test.activitys;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zhaoemifeng.test.R;

public class SkipFontActivity extends AppCompatActivity {
    private RadioGroup font_radioGroup;//声明RadioGroup
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_font);
        //Actingbar设置导航菜单，包含返回键跟标题
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);//返回键，真是的处理事件在onOptionsItemSelected
            actionBar.setTitle("字体设置");//设置导航菜单的标题
        }
        font_radioGroup=(RadioGroup)findViewById(R.id.main_tab_bar);//通过findViewById获得RadioGroup对象
        //添加事件监听器
        font_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.font_small){
                    TextView textView=(TextView) findViewById(R.id.tv_font);
                    textView.setText("我已经老了，在人来人往的大厅，有一位老人他向我走来,他说我认识你那是的你还很年轻，美丽，你的身边有许许多多的追求者,不过跟那时相比，我更喜欢现在你这经历了沧桑的容颜？ \n" +
                            "                               -《情人》");
                    textView.setTextSize(16);
                }else if(checkedId==R.id.font_msmall){
                    TextView textView=(TextView) findViewById(R.id.tv_font);
                    textView.setText("我已经老了，在人来人往的大厅，有一位老人他向我走来,他说我认识你那是的你还很年轻，美丽，你的身边有许许多多的追求者,不过跟那时相比，我更喜欢现在你这经历了沧桑的容颜？ \n" +
                            "                           -《情人》");
                    textView.setTextSize(18);
                }else if(checkedId==R.id.font_lsmall){
                    TextView textView=(TextView) findViewById(R.id.tv_font);
                    textView.setText("我已经老了，在人来人往的大厅，有一位老人他向我走来,他说我认识你那是的你还很年轻，美丽，你的身边有许许多多的追求者,不过跟那时相比，我更喜欢现在你这经历了沧桑的容颜？ \n" +
                            "                       -《情人》");
                    textView.setTextSize(20);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_skip_font, menu);
        return true;
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
