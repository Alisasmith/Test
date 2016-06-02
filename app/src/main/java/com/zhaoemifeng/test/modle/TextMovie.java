package com.zhaoemifeng.test.modle;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Project:Test
 * Author: zhaomeifeng
 * Date:   2016/6/1
 */
public class TextMovie {
    private String title;
    private String image1URL;
    private String image2URL;
    private String image3URL;
    private String image4URL;
    private String image5URL;
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String text5;
    private String author;
    private String authorbrief;
    private String times;

    public String getTimes() {
        return times;
    }

    public String getTitle() {
        return title;
    }

    public String getImage1URL() {
        return image1URL;
    }

    public String getImage2URL() {
        return image2URL;
    }

    public String getImage3URL() {
        return image3URL;
    }

    public String getImage4URL() {
        return image4URL;
    }

    public String getImage5URL() {
        return image5URL;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public String getText3() {
        return text3;
    }

    public String getText4() {
        return text4;
    }

    public String getText5() {
        return text5;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthorbrief() {
        return authorbrief;
    }
    public void parseJson(JSONObject json) throws JSONException {
        if (json != null) {
            title=json.getString("title");
            text1=json.getString("text1");
            text2=json.getString("text2");
            text3=json.getString("text3");
            text4=json.getString("text4");
            text5=json.getString("text5");
            times=json.getString("times");
            image1URL=json.getString("imageforplay");
            image2URL=json.getString("image1");
            image3URL=json.getString("image2");
            image4URL=json.getString("image3");
            image5URL=json.getString("image4");
            author=json.getString("author");
            authorbrief=json.getString("authorbrief");
        }else{
            Log.d("TextMovie", "解析出错 ");
        }
    }
}
