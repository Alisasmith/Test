package com.zhaoemifeng.test.modle;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Project:Test
 * Author: zhaomeifeng
 * Date:   2016/6/2
 */
public class TextPicture {
    private String title;
    private String text1;
    private String authorbrief;
    private String text2;
    private String imageURL;

    public String getTitle() {
        return title;
    }

    public String getText1() {
        return text1;
    }

    public String getAuthorbrief() {
        return authorbrief;
    }

    public String getText2() {
        return text2;
    }

    public String getImageURL() {
        return imageURL;
    }
    public void parseJson(JSONObject json) throws JSONException {
        if (json != null) {
            title=json.getString("title");
            text1=json.getString("text1");
            text2=json.getString("text2");
            imageURL=json.getString("image1");
            authorbrief=json.getString("authorbrief");
        }else{
            Log.d("TextMovie", "解析出错 ");
        }
    }
}
