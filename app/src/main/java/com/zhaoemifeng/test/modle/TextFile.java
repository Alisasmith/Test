package com.zhaoemifeng.test.modle;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Project:Test
 * Author: zhaomeifeng
 * Date:   2016/6/2
 */
public class TextFile {
    private String title;
    private String text;
    private String author;
    private String authorbrief;
    private String times;//阅读量
    private String summary;

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthorbrief() {
        return authorbrief;
    }

    public String getTimes() {
        return times;
    }

    public String getSummary() {
        return summary;
    }
    public void parseJson(JSONObject json) throws JSONException {
        if (json != null) {
            title=json.getString("title");
            text=json.getString("text");
            author=json.getString("author");
            authorbrief=json.getString("authorbrief");
            times=json.getString("times");
            summary=json.getString("summary");
        }else{
            Log.d("TextAssay", "解析出错 ");
        }
    }
}
