package com.zhaoemifeng.test.fragments.homes;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.zhaoemifeng.myliabry.NetWorkTask;
import com.zhaoemifeng.myliabry.NetworkTaskCallback;
import com.zhaoemifeng.test.R;
import com.zhaoemifeng.test.modle.TextPicture;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * A simple {@link Fragment} subclass.
 */
public class Picture1Fragment extends Fragment implements NetworkTaskCallback {
    private TextPicture image;
    private ImageView iv_image;
    private TextView txt_image_title,txt_image_text1,txt_image_text2,txt_image_author;

    public Picture1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        image = new TextPicture();
        Bundle bund1=getArguments();
        String id1=bund1.getString("image11");
        Log.d("test", id1);
        //TODO:加载网络
        NetWorkTask task=new NetWorkTask(getContext(),this);
        task.execute("http://api.shigeten.net/api/Diagram/GetDiagramContent?id=" + id1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_picture1, container, false);
        iv_image=(ImageView)inflate.findViewById(R.id.iv_image1);
        txt_image_author=(TextView)inflate.findViewById(R.id.txt_image1_author);
        txt_image_text1=(TextView)inflate.findViewById(R.id.txt_image1_text1);
        txt_image_text2=(TextView)inflate.findViewById(R.id.txt_image1_text2);
        txt_image_title=(TextView)inflate.findViewById(R.id.txt_image1_title);
        return inflate;
    }
    private void init(){
        txt_image_title.setText(image.getTitle());
        txt_image_author.setText(image.getAuthorbrief());
        txt_image_text1.setText(image.getText1());
        txt_image_text2.setText(image.getText2());
        String image11 = image.getImageURL();
        if (image11 != null) {
            Picasso.with(getContext()).load("http://api.shigeten.net/"+image11).into(iv_image);
        }
    }

    @Override
    public void onTaskFinnished(byte[] data) {
        if (data != null) {
            try {
                JSONObject obj = new JSONObject(new String(data, "UTF-8"));
                image.parseJson(obj);
                init();
            } catch (JSONException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else{
            Toast.makeText(getContext(), "网络异常", Toast.LENGTH_SHORT).show();
        }
    }
}
